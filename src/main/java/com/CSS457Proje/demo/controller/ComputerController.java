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
}
