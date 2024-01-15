package ru.skypro.lessons.springboot.JPAS.JPAS.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.core.io.Resource;
import lombok.SneakyThrows;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
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

    @PostMapping()
    public ResponseEntity<Long> statisticReport() throws JsonProcessingException {
        return new ResponseEntity<>(reportService.generatedStatisticReported(), HttpStatus.OK);
    }

    @GetMapping("/all")
    public List<Report> findAllReport() {
        return reportService.findAllReport();
    }


    @SneakyThrows
    @GetMapping(value = "/{id}/dowload")
    public ResponseEntity<Resource> dowloadFile(@PathVariable Long id){
        String nameFile = "Statistic.json";
        Resource resource = new ByteArrayResource(reportService.findGetReport(id));
        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION,"attachment; filename = \"" + nameFile + "\"")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .body(resource);
    }



}