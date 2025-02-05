package com.github.glo2003.payroll;

public class HourlySalaryCalculator implements SalaryCalculator {

  @Override
  public float calculateSalary(Employee employee) {
    HourlyEmployee hourlyEmployee = (HourlyEmployee) employee;
    return hourlyEmployee.getAmount() * hourlyEmployee.getRate();
  }
}
