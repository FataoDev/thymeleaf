package Thymeleaf.Thymeleafdemo.service;

import Thymeleaf.Thymeleafdemo.entity.Employee;
import Thymeleaf.Thymeleafdemo.repository.EmpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmpServiceImp1 implements EmpService {

    @Autowired
    public EmpRepository empRepo;

    @Override
    public Employee saveEmp(Employee emp) {
        Employee newEmp = empRepo.save(emp);
        return newEmp;
    }

    @Override
    public List<Employee> getAllEmp() {
        return empRepo.findAll();
    }

    @Override
    public Employee getEmpById(int id) {
        return empRepo.findById(id).get();
    }

    @Override
    public boolean deleteEmp(int id) {
        Employee emp= empRepo.findById(id).get();
        if (emp!=null){
            empRepo.delete(emp);
            return true;
        }
        return false;
    }
}