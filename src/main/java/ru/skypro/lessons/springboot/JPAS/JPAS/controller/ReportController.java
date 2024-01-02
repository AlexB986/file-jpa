package ru.skypro.lessons.springboot.JPAS.JPAS.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;
import ru.skypro.lessons.springboot.JPAS.JPAS.service.ReportService;

import java.util.List;

@RestController
@RequestMapping("/report")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping()
    public ResponseEntity<String> statisticReport() {
        reportService.generatedStatisticReported();
        return ResponseEntity.ok("ok");
    }

    @GetMapping("/all")
    public List<Report> findAllReport() {
        return reportService.findAllReport();
    }



}