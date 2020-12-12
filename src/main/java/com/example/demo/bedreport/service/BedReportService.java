package com.example.demo.bedreport.service;

import com.example.demo.bedreport.bean.BedReport;
import com.example.demo.bedreport.dao.BedReportRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
import org.springframework.data.elasticsearch.core.query.*;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.boolQuery;
import static org.elasticsearch.index.query.QueryBuilders.queryStringQuery;

@Service
public class BedReportService {

    private ElasticsearchOperations elasticsearchOperations;

    private BedReportRepository bedReportRepository;

    @Autowired
    public BedReportService(ElasticsearchOperations elasticsearchOperations, BedReportRepository bedReportRepository) {
        this.elasticsearchOperations = elasticsearchOperations;
        this.bedReportRepository = bedReportRepository;
    }

    public Iterable<BedReport> findByEstadoAndMunicipio(String state, String city) {
//        Criteria criteria = new Criteria("estado").is(state);
//                criteria.and("cidade").is(city);
//        Query query = new CriteriaQuery(criteria);
//        bedReportRepository.findByEstadoLikeAndMunicipioLike(state,city);

        QueryBuilder queryBuilder = boolQuery()
//                .should(
//                queryStringQuery(state).analyzeWildcard(true)
//                        .field("estado"))
                .should(queryStringQuery(city).analyzeWildcard(true)
                .field("cidade"));
        NativeSearchQuery nativequery = new NativeSearchQuery(queryBuilder);
        return elasticsearchOperations.search(nativequery, BedReport.class).map(c->c.getContent()).toList();
    }
}
