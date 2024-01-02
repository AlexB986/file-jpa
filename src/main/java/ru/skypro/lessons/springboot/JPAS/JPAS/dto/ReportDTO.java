package ru.skypro.lessons.springboot.JPAS.JPAS.dto;




public class ReportDTO {
    private String deportamentName;
    private Integer count_employee;
    private Integer max_salary;
    private Integer min_salary;
    private Integer avg_salary;

    public ReportDTO() {
    }

    public ReportDTO( String deportament_name, Integer count_employee, Integer max_salary, Integer min_salary, Integer avg_salary) {
        this.deportamentName = deportament_name;
        this.count_employee = count_employee;
        this.max_salary = max_salary;
        this.min_salary = min_salary;
        this.avg_salary = avg_salary;
    }


    public String getDeportamentName() {
        return deportamentName;
    }

    public void setDeportamentName(String deportamentName) {
        this.deportamentName = deportamentName;
    }

    public Integer getCount_employee() {
        return count_employee;
    }

    public void setCount_employee(Integer count_employee) {
        this.count_employee = count_employee;
    }

    public Integer getMax_salary() {
        return max_salary;
    }

    public void setMax_salary(Integer max_salary) {
        this.max_salary = max_salary;
    }

    public Integer getMin_salary() {
        return min_salary;
    }

    public void setMin_salary(Integer min_salary) {
        this.min_salary = min_salary;
    }

    public Integer getAvg_salary() {
        return avg_salary;
    }

    public void setAvg_salary(Integer avg_salary) {
        this.avg_salary = avg_salary;
    }

    @Override
    public String toString() {
        return "ReportDTO{" +
                ", deportamentName='" + deportamentName + '\'' +
                ", count_employee=" + count_employee +
                ", max_salary=" + max_salary +
                ", min_salary=" + min_salary +
                ", avg_salary=" + avg_salary +
                '}';
    }
}
