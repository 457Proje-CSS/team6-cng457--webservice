package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.service.ComputerService;
import com.CSS457Proje.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;

    @PostMapping("/addComputer")
    public Computer addComputer(@RequestBody Computer computer){
        return computerService.saveComputer(computer);
    }

    @GetMapping("/getComputers")
    public List<Computer> getComputer() { return computerService.getComputers(); }

    @GetMapping("/getComputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }

    @DeleteMapping("/deleteComputer/{id}")
    public void deleteComputer(@PathVariable int id){ computerService.deleteComputer(id); }

    @GetMapping("/getComputerbyBrand/{brand}")
    public List<Computer> getComputerbyBrand(@PathVariable String brand){ return computerService.getComputerbyBrand(brand); }

    @GetMapping("/getComputerbyName/{name}")
    public List<Computer> getComputerbyName(@PathVariable String name){ return computerService.getComputerbyName(name); }

    @GetMapping("/getComputerbyPrice/{price}")
    public List<Computer> getComputerbyPrice(@PathVariable int price){ return computerService.getComputerbyPrice(price); }

    @GetMapping("/getComputerbyModel/{model}")
    public List<Computer> getComputerbyModel(@PathVariable String model){ return computerService.getComputerbyModel(model); }

    @GetMapping("/getComputerbyScreenSize/{screenSize}")
    public List<Computer> getComputerbyScreenSize(@PathVariable String screenSize){ return computerService.getComputerbyScreenSize(screenSize); }

    @GetMapping("/getComputerbyStorageCapacity/{storageCapacity}")
    public List<Computer> getComputerbyStorageCapacity(@PathVariable int storageCapacity){ return computerService.getComputerbyStorageCapacity(storageCapacity); }

    @GetMapping("/getComputerbyMemory/{memory}")
    public List<Computer> getComputerbyMemory(@PathVariable int memory){ return computerService.getComputerbyMemory(memory); }

    @GetMapping("/getComputerbyProcessor/{processor}")
    public List<Computer> getComputerbyProcessor(@PathVariable String processor){ return computerService.getComputerbyProcessor(processor); }

    @GetMapping("/getComputerbyProcessor/{screenResolution}")
    public List<Computer> getComputerbyScreenResolution(@PathVariable String screenResolution){ return computerService.getComputerbyScreenResolution(screenResolution); }
}
