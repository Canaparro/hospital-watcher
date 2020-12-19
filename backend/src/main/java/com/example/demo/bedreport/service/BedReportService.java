package com.example.demo.bedreport.service;

import com.example.demo.bedreport.bean.BedReport;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
public class BedReportService {

    private ElasticsearchOperations elasticsearchOperations;

    private final Pageable defaultPageable = PageRequest.of(0, 10);

    @Autowired
    public BedReportService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    //TODO: BREAK DOWN TO MAKE TESTS
    public SearchHits<BedReport> search(String state, String city, String hospital, Integer page, Integer size, LocalDateTime fromDate) {
        BoolQueryBuilder queryBuilder = boolQuery();
        if (fromDate != null) //&& !fromDate.isBlank())
            queryBuilder.must(rangeQuery(BedReport.LAST_MODIFICATION_DATE).gt(fromDate));//.parse(fromDate)));
        if (state != null && !state.isBlank())
            queryBuilder.must(matchQuery(BedReport.STATE, state).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        if (city != null && !city.isBlank())
            queryBuilder.must(matchQuery(BedReport.CITY, city).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        if (hospital != null && ! hospital.isBlank())
            queryBuilder.must(matchQuery(BedReport.HOSPITAL, hospital).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        return elasticsearchOperations.search(getPageableNativeSearchQuery(page, size, queryBuilder), BedReport.class);
    }

    private NativeSearchQuery getPageableNativeSearchQuery(Integer page, Integer size, QueryBuilder queryBuilder) {
        Pageable pageable = null;
        if(size != null && size != null)
            pageable = PageRequest.of(page, size);
        return new NativeSearchQuery(queryBuilder).setPageable(pageable != null ? pageable : defaultPageable);
    }
}
