package com.example.demo.bedreport.controller;

import com.example.demo.bedreport.bean.BedReport;
import com.example.demo.bedreport.service.BedReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/bedreport")
public class BedReportController {

    private BedReportService bedReportService;

    @Autowired
    public BedReportController(BedReportService bedReportService) {
        this.bedReportService = bedReportService;
    }

    @GetMapping("/search")
    public Iterable<BedReport> getBedReportsByStateAndCity(@RequestParam("state") String state, @RequestParam("city") String city) {
        return bedReportService.findByEstadoAndMunicipio(state, city);
    }

}
