package com.github.glo2003.payroll;

import com.github.glo2003.exceptions.EmployeeNotFoundException;
import com.github.glo2003.exceptions.InvalidSalaryRaiseException;
import com.github.glo2003.exceptions.UnknownEmployeeTypeException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class CompanyPayroll {
    private final List<Employee> employees;
    private final List<Paycheck> paychecks;

    public CompanyPayroll() {
        this.employees = new ArrayList<>();
        this.paychecks = new ArrayList<>();
    }

    public void processPending() {

        for (Paycheck paycheck : paychecks) {
            System.out.println("Sending " + paycheck.getAmount() + "$ to " + paycheck.getTo());
        }

        paychecks.clear();
    }

    public void addEmployee(Employee employee) {
        employees.add(employee);
    }

    public List<Employee> findSoftwareEngineer() {
        return findEmployeesByRole("engineer");
    }

    public List<Employee> findManager() {
        return findEmployeesByRole("manager");
    }


    public List<Employee> findVicePresidents() {
        return findEmployeesByRole("vp");
    }

    public List<Employee> findInterns() {
        return findEmployeesByRole("intern");
    }

    private List<Employee> findEmployeesByRole(String role) {
        List<Employee> foundEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (employee.getRole().equals(role)) {
                foundEmployees.add(employee);
            }
        }
        return foundEmployees;
    }

    public void createPending() {
        for (Employee employee : employees) {
            float salary = employee.calculateSalary();
            paychecks.add(new Paycheck(employee.getName(), salary));
        }
    }

    public void raiseSalary(Employee employee, float raise) {

        if (raise < 0) {
        throw new InvalidSalaryRaiseException("Raise amount cannot be negative");
        }

        if (!employees.contains(employee)) {
            throw new EmployeeNotFoundException("Employee not found in the list");
        }

        employee.raiseSalary(raise);
    }

    public float getAveragePayCheckPending() {
        if (paychecks.isEmpty()) {
            return Float.NaN;
        }

        return getTotalMoney() / paychecks.size();
    }

    public float getTotalMoney() {
        float total = 0.0f;

        for (Paycheck paycheck : paychecks) {
            total += paycheck.getAmount();
        }

        return total;
    }

    public List<Paycheck> getPendings() {
        return paychecks;
    }

}
