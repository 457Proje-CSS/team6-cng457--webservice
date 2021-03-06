package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.repository.computerrepository;
import com.CSS457Proje.demo.repository.phonerepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Service;

import javax.persistence.LockModeType;
import java.util.ArrayList;
import java.util.List;

@Service
public class ComputerService {
    @Autowired
    private computerrepository computerrepository;

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public Computer saveComputer(Computer computer){
        return computerrepository.save(computer);
    }

    public List<Computer> getComputers(){ return computerrepository.findAll(); }

    //getComputers2 is just for testing
    public List<Computer> getComputers2()  {
        Computer c1 = new Computer();
        c1.setProductID(3);
        c1.setName("testcomputer3");
        List<Computer> computers = computerrepository.findAll();
        computers.add(c1);
        return computers;
    }

    public Computer getComputer(int id){
        return computerrepository.findById(id).orElse(null);
    }

    @Lock(LockModeType.PESSIMISTIC_WRITE)
    public void deleteComputer(int id){ computerrepository.deleteById(id); }

    public List<Computer> getComputerbyBrand(String brand){return  computerrepository.getComputerbyBrand(brand); }

    public List<Computer> getComputerbyName(String name){return  computerrepository.getComputerbyName(name); }

    public List<Computer> getComputerbyPrice(int price){return  computerrepository.getComputerbyPrice(price); }

    public List<Computer> getComputerbyModel(String model){return  computerrepository.getComputerbyModel(model); }

    public List<Computer> getComputerbyScreenSize(String screenSize){return  computerrepository.getComputerbyScreenSize(screenSize); }

    public List<Computer> getComputerbyStorageCapacity(int storageCapacity){return  computerrepository.getComputerbyStorageCapacity(storageCapacity); }

    public List<Computer> getComputerbyMemory(int memory){return  computerrepository.getComputerbyMemory(memory); }

    public List<Computer> getComputerbyProcessor(String processor){return  computerrepository.getComputerbyProcessor(processor); }

    public List<Computer> getComputerbyScreenResolution(String screenResolution){return  computerrepository.getComputerbyScreenResolution(screenResolution); }

}
