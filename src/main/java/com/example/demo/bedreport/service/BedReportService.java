package com.example.demo.bedreport.service;

import com.example.demo.bedreport.bean.BedReport;
import com.example.demo.bedreport.dao.BedReportRepository;
import org.elasticsearch.client.transform.transforms.pivot.SingleGroupSource;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.*;

@Service
public class BedReportService {

    private ElasticsearchOperations elasticsearchOperations;

    @Autowired
    public BedReportService(ElasticsearchOperations elasticsearchOperations) {
        this.elasticsearchOperations = elasticsearchOperations;
    }

    public Iterable<BedReport> findByEstadoAndMunicipio(String state, String city) {
        QueryBuilder queryBuilder = boolQuery()
                .must(matchQuery("municipio", city).operator(Operator.AND).fuzziness(Fuzziness.TWO))
                .must(matchQuery("estado", state).operator(Operator.AND).fuzziness(Fuzziness.TWO));
        NativeSearchQuery nativequery = new NativeSearchQuery(queryBuilder);
        return elasticsearchOperations.search(nativequery, BedReport.class).map(c->c.getContent()).toList();
    }
}
