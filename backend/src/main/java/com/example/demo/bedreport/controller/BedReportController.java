package com.example.demo.bedreport.controller;

import com.example.demo.bedreport.bean.BedReport;
import com.example.demo.bedreport.service.BedReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.SearchHits;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("api/v1/bedreports")
public class BedReportController {

    private BedReportService bedReportService;

    @Autowired
    public BedReportController(BedReportService bedReportService) {
        this.bedReportService = bedReportService;
    }

    @CrossOrigin({"http://localhost:3000"})
    @GetMapping
    public ResponseEntity<Iterable<BedReport>> search(
            @RequestParam(value = "state", required = false) String state,
            @RequestParam(value = "city", required = false) String city,
            @RequestParam(value = "hospital", required = false) String hospital,
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "fromDate", required = false) LocalDateTime fromDate) {
        SearchHits<BedReport> searchHits = bedReportService.search(state, city, hospital, page, size, fromDate);
        return new ResponseEntity<>(searchHits.map(hit -> hit.getContent()).toList(), HttpStatus.OK);
    }

}
