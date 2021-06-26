package com.CSS457Proje.demo.service;

import com.CSS457Proje.demo.controller.PhoneController;
import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.repository.phonerepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PhoneServiceTest {

    @InjectMocks
    PhoneService phoneService;

    @Mock
    phonerepository phonerepository;

    @Test
    void getPhones() {
        Phone p1 = new Phone();
        Phone p2 = new Phone();
        p1.setProductID(1);
        p2.setProductID(2);
        p1.setName("testphone1");
        p2.setName("testphone2");
        List<Phone> phones = new ArrayList<>();
        phones.add(p1);
        phones.add(p2);

        when(phonerepository.findAll()).thenReturn(new ArrayList(phones));

        List<Phone> phoneList = phoneService.getPhones2();
        Assertions.assertEquals(phones.size()+1, phoneList.size());
        Assertions.assertEquals("testphone3", phoneList.get(phoneList.size()-1).getName());
        Assertions.assertEquals("testphone1", phoneList.get(0).getName());
    }
}
