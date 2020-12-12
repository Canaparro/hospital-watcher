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

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class BedReportService {

    private ElasticsearchOperations elasticsearchOperations;

    private final Pageable defaultPageable = PageRequest.of(0, 10);

    @Autowired
    public BedReportService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public SearchHits<BedReport> search(String state, String city, String hospital, Integer page, Integer size) {
        BoolQueryBuilder queryBuilder = boolQuery();
        if (state != null)
            queryBuilder.must(matchQuery(BedReport.STATE, state).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        if (city != null)
            queryBuilder.must(matchQuery(BedReport.CITY, city).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        if (hospital != null)
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
