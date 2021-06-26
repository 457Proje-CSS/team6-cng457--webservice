package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.controller.ComputerController;
import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.repository.computerrepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ComputerServiceTest {

    @InjectMocks
    ComputerService computerService;

    @Mock
    computerrepository computerrepository;

    @Test
    void getComputers() {
        Computer c1 = new Computer();
        Computer c2 = new Computer();
        c1.setProductID(1);
        c2.setProductID(2);
        c1.setName("testcomputer1");
        c2.setName("testcomputer2");
        List<Computer> computers = new ArrayList<>();
        computers.add(c1);
        computers.add(c2);

        when(computerrepository.findAll()).thenReturn(new ArrayList(computers));

        List<Computer> computerList = computerService.getComputers2();
        Assertions.assertEquals(computers.size()+1, computerList.size());
        Assertions.assertEquals("testcomputer3", computerList.get(computerList.size()-1).getName());
        Assertions.assertEquals("testcomputer1", computerList.get(0).getName());
    }
}
