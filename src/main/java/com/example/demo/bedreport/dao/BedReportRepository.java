package com.example.demo.bedreport.dao;

import com.example.demo.bedreport.bean.BedReport;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface BedReportRepository extends ElasticsearchRepository<BedReport, String> {

    List<BedReport> findByEstadoLikeAndMunicipioLike(String state, String city);
}
