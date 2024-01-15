package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import jakarta.annotation.Resource;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;

import java.io.IOException;
import java.util.List;

public interface ReportService {

    List<Report> findAllReport();

    Long  generatedStatisticReported() throws JsonProcessingException;

    byte[]findGetReport(Long id) throws IOException;

}
