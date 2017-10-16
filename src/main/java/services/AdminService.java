package services;

import model.Administrator;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdminService {
    void save(Administrator administrator);
    void deleteAdmin(int id);

    List<Administrator> getAllAdmins();
}
