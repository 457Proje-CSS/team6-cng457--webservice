package com.CSS457Proje.demo.controller;


import com.CSS457Proje.demo.Application;
import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.service.ComputerService;
import com.CSS457Proje.demo.service.PhoneService;
import com.CSS457Proje.demo.service.PhoneServiceTest;
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
public class PhoneControllerTest {

    @InjectMocks
    PhoneController phoneController;

    @Mock
    PhoneService phoneService;

    @Autowired
    private TestRestTemplate restTemplate;

    @LocalServerPort
    private int port;

    @Test
    void getPhones() {
        Phone p1 = new Phone();
        Phone p2 = new Phone();
        p1.setProductID(8);
        p2.setProductID(9);
        p1.setName("testphone1");
        p2.setName("testphone2");
        List<Phone> phones = new ArrayList<>();
        phones.add(p1);
        phones.add(p2);

        when(phoneService.getPhones()).thenReturn(new ArrayList(phones));

        List<Phone> phoneList = phoneController.getPhones2();
        Assertions.assertEquals(phones.size()+1, phoneList.size());
        Assertions.assertEquals("testphone3", phoneList.get(phoneList.size()-1).getName());
    }

    @Test
    void getPhones2() { assertTrue(this.restTemplate.getForObject("http://localhost:" + port + "/getPhones2",Phone[].class)[0].getName().equals("testphone1")); }
}
