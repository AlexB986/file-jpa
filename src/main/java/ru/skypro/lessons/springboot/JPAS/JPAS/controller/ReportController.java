package ru.skypro.lessons.springboot.JPAS.JPAS.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
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

    @GetMapping()
    public ResponseEntity<ReportDTO> statisticReport() {
        return new ResponseEntity<>(reportService.generatedStatisticReported(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Report> findAllReport() {
        return reportService.findAllReport();
    }


}
