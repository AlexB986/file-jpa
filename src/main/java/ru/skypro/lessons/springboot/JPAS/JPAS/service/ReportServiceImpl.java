package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.PositionRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.ReportRepository;

import java.io.DataInput;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    private EmployeeRepository employeeRepository;

    private PositionRepository positionRepository;
    private ReportRepository reportRepository;

    public ReportServiceImpl(EmployeeRepository employeeRepository,
                             PositionRepository positionRepository, ReportRepository reportReposotory) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.reportRepository = reportReposotory;
    }

    @Override
    public List<Report> findAllReport() {
        return reportRepository.findAllReport();
    }

    @Override
    public Long generatedStatisticReported() throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        List<ReportDTO> reportDTOS = employeeRepository.statisticReported();
        byte[] jsonReport = objectMapper.writeValueAsBytes(reportDTOS);

        Report report = new Report(jsonReport);
        reportRepository.saveAndFlush(report);

        return report.getId();
    }

    @Override
    public byte[] findGetReport(Long id) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        byte[] byteData = reportRepository.findGetReport(id);
        String json = objectMapper.writeValueAsString(byteData);
        ReportDTO report = objectMapper.readValue(json,ReportDTO.class);
        System.out.println(report);

        return null;
    }

}