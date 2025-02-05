package com.github.glo2003.payroll;

public class SalariedSalaryCalculator implements SalaryCalculator {

  @Override
  public float calculateSalary(Employee employee) {
    SalariedEmployee salariedEmployee = (SalariedEmployee) employee;
    return salariedEmployee.getBiweekly();
  }
}
