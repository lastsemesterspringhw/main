package homework.department.service;

import homework.department.model.Department;
import org.springframework.ui.Model;

import java.util.List;

public interface DepartmentService {
    void saveDepartment(Department department);

    List<Department> findAllDepartments();

    Department findDepartmentById(Long id);

    void deleteDepartmentById(Long id);
}
