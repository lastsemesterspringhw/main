package services;

import model.Administrator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.AdministratorRepository;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {

    @Autowired
    private AdministratorRepository administratorRepository;

    @Override
    public void save(Administrator administrator) {
        administratorRepository.save(administrator);
    }

    @Override
    public void deleteAdmin(int id) {
        administratorRepository.delete(id);
    }

    @Override
    public List<Administrator> getAllAdmins() {
        return administratorRepository.findAll();
    }
}
