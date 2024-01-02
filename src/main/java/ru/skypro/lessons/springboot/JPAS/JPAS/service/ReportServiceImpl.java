package ru.skypro.lessons.springboot.JPAS.JPAS.service;

import org.springframework.stereotype.Service;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.EmployeeInfoDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.dto.ReportDTO;
import ru.skypro.lessons.springboot.JPAS.JPAS.model.Report;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.EmployeeRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.PositionRepository;
import ru.skypro.lessons.springboot.JPAS.JPAS.repository.ReportReposotory;

import java.util.List;
import java.util.UUID;

@Service
public class ReportServiceImpl implements ReportService {

    private EmployeeRepository employeeRepository;

    private PositionRepository positionRepository;
    private ReportReposotory reportReposotory;

    public ReportServiceImpl(EmployeeRepository employeeRepository,
                             PositionRepository positionRepository, ReportReposotory reportReposotory) {
        this.employeeRepository = employeeRepository;
        this.positionRepository = positionRepository;
        this.reportReposotory = reportReposotory;
    }

    @Override
    public List<Report> findAllReport() {
        return reportReposotory.findAllReport();
    }

    @Override
    public ReportDTO generatedStatisticReported() {
        List<ReportDTO> reportDTOS = employeeRepository.statisticReported();
        for (ReportDTO r : reportDTOS) {
            ReportDTO reportDTO = new ReportDTO();
//            reportDTO.setId_role(r.getId_role());
            reportDTO.setDeportamentName(r.getDeportamentName());
            reportDTO.setCount_employee(r.getCount_employee());
            reportDTO.setMax_salary(r.getMax_salary());
            reportDTO.setMin_salary(r.getMin_salary());
            reportDTO.setAvg_salary(r.getAvg_salary());
            System.out.println(reportDTO);
            return reportDTO;

        }
        return null;

    }

}