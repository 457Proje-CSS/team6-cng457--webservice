package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.repository.computerrepository;
import com.CSS457Proje.demo.repository.phonerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComputerService {
    @Autowired
    private computerrepository computerrepository;

    public Computer saveComputer(Computer computer){
        return computerrepository.save(computer);
    }

    public List<Computer> getComputers(){
        return computerrepository.findAll();
    }

    public Computer getComputer(int id){
        return computerrepository.findById(id).orElse(null);
    }

    public void deleteComputer(int id){ computerrepository.deleteById(id); }
}
