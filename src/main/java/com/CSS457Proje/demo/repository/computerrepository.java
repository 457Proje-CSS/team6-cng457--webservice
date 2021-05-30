package com.CSS457Proje.demo.repository;

import com.CSS457Proje.demo.entity.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface computerrepository extends JpaRepository<Computer,Integer> {
    @Query("SELECT c from Computer c WHERE c.brand LIKE %?1%")
    public List<Computer> getComputerbyBrand(String brand);

    @Query("SELECT c from Computer c WHERE c.name LIKE %?1%")
    public List<Computer> getComputerbyName(String name);

    @Query("SELECT c from Computer c WHERE c.price=?1")
    public List<Computer> getComputerbyPrice(int price);

    @Query("SELECT c from Computer c WHERE c.model LIKE %?1%")
    public List<Computer> getComputerbyModel(String model);

    @Query("SELECT c from Computer c WHERE c.screenSize LIKE %?1%")
    public List<Computer> getComputerbyScreenSize(String screenSize);

    @Query("SELECT c from Computer c WHERE c.storageCapacity=?1")
    public List<Computer> getComputerbyStorageCapacity(int storageCapacity);

    @Query("SELECT c from Computer c WHERE c.memory=?1")
    public List<Computer> getComputerbyMemory(int memory);

    @Query("SELECT c from Computer c WHERE c.processor LIKE %?1%")
    public List<Computer> getComputerbyProcessor(String processor);

    @Query("SELECT c from Computer c WHERE c.screenResolution LIKE %?1%")
    public List<Computer> getComputerbyScreenResolution(String screenResolution);
}
