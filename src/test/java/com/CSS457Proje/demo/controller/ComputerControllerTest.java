package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.Application;
import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.service.ComputerService;
import com.CSS457Proje.demo.service.PhoneService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ComputerControllerTest {
    @InjectMocks
    ComputerController computerController;

    @Mock
    ComputerService computerService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void getComputers() {
        Computer c1 = new Computer();
        Computer c2 = new Computer();
        c1.setProductID(8);
        c2.setProductID(9);
        c1.setName("testcomputer1");
        c2.setName("testcomputer2");
        List<Computer> computers = new ArrayList<>();
        computers.add(c1);
        computers.add(c2);

        when(computerService.getComputers()).thenReturn(new ArrayList(computers));

        List<Computer> computerList = computerController.getComputers2();
        Assertions.assertEquals(computers.size()+1, computerList.size());
        Assertions.assertEquals("testcomputer3", computerList.get(computerList.size()-1).getName());
    }

    @Test
    void getComputers2() { assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/getComputers",Computer[].class)[0].getName().equals("testcomputer1")); }}
