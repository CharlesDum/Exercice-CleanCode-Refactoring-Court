package com.github.glo2003.payroll;


public abstract class Employee {
    private final String name;
    private final String role;
    private final int vacation_days;
    private SalaryCalculator salaryCalculator;

    public Employee(String name, String role, int vacation_days) {
        this.name = name;
        this.role = role;
        this.vacation_days = vacation_days;
    }

    public float calculateSalary() {
        return salaryCalculator.calculateSalary(this);
    }

    public abstract void raiseSalary(float raise);

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public int getVacation_days() {
        return vacation_days;
    }

    public void setSalaryCalculator(SalaryCalculator salaryCalculator) {
        this.salaryCalculator = salaryCalculator;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", vacation_days=" + vacation_days +
                '}';
    }
}
