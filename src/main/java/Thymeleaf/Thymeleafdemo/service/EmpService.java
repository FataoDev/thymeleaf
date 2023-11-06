package Thymeleaf.Thymeleafdemo.service;

import Thymeleaf.Thymeleafdemo.entity.Employee;

import java.util.List;

public interface EmpService {
    public Employee saveEmp(Employee emp);

    public List<Employee> getAllEmp();
    public Employee getEmpById(int id);
    public boolean deleteEmp(int id);
}
