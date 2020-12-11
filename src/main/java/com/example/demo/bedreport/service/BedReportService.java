package com.example.demo.bedreport.service;

import com.example.demo.bedreport.bean.BedReport;
import com.example.demo.bedreport.dao.BedReportRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BedReportService {

    @Autowired
    private BedReportRepository bedReportRepository;

    public Iterable<BedReport> findAll() {
        return bedReportRepository.findAll();
    }

    public Iterable<BedReport> findByEstadoAndMunicipio(String state, String city) {
        return bedReportRepository.findByEstadoAndMunicipio(state, city);
    }
}
