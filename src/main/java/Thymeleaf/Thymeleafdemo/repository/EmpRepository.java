package Thymeleaf.Thymeleafdemo.repository;

import Thymeleaf.Thymeleafdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmpRepository extends JpaRepository<Employee, Integer> {

}
