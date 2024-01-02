package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;

import java.util.List;

public interface ReportService {

    List<Report> findAllReport();

    ReportDTO generatedStatisticReported();

}
