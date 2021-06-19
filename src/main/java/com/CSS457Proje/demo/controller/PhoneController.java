package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Filter;

@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;

    @PostMapping("/addPhone")
    public Phone addProduct(@RequestBody Phone phone){
        return phoneService.savePhone(phone);
    }

    @GetMapping("/getPhones")
    public List<Phone> getProducts() { return phoneService.getPhones(); }

    @GetMapping("/getPhone/{id}")
    public Phone getProduct(@PathVariable int id){
        return phoneService.getPhone(id);
    }

    @DeleteMapping("/deletePhone/{id}")
    public void deleteProduct(@PathVariable int id){
        phoneService.deletePhone(id);
    }

    @GetMapping("/getPhonebyBrand/{brand}")
    public List<Phone> getPhonebyBrand(@PathVariable String brand){ return phoneService.getPhonebyBrand(brand); }

    @GetMapping("/getPhonebyInternalmemory/{internalmemory}")
    public List<Phone> getPhonebyInternalMemory(@PathVariable int internalmemory){ return phoneService.getPhonebyInternalmemory(internalmemory); }

    @GetMapping("/getPhonebyName/{name}")
    public List<Phone> getPhonebyName(@PathVariable String name){ return phoneService.getPhonebyName(name); }

    @GetMapping("/getPhonebyPrice/{price}")
    public List<Phone> getPhonebyPrice(@PathVariable int price){ return phoneService.getPhonebyPrice(price); }

    @GetMapping("/getPhonebyModel/{model}")
    public List<Phone> getPhonebyModel(@PathVariable String model){ return phoneService.getPhonebyModel(model); }

    @GetMapping("/getPhonebyScreensize/{screenSize}")
    public List<Phone> getPhonebyScreenSize(@PathVariable String screenSize){ return phoneService.getPhonebyScreenSize(screenSize); }

    @GetMapping("/filterPhonesWithCriteria")
    @ResponseBody
    public List<Phone> filterPhonesWithCriteria(@RequestParam(required = false,defaultValue = "-999") int productID,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false,defaultValue = "-999") int minprice,
                                        @RequestParam(required = false,defaultValue = "-999") int maxprice,
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String model,
                                        @RequestParam(required = false) String screenSize,
                                        @RequestParam(required = false,defaultValue = "-999") int internalMemory) {
        List<Phone> filteredList = phoneService.getPhones();
        for(Phone p: filteredList) System.out.println(p.getProductID()+p.getName());

        if(productID!=-999)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(filteredList.get(i).getProductID() != productID) filteredList.remove(i);
            }
        }
        if(name != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getName().contains(name)) filteredList.remove(i);
            }
        }
        if(minprice != -999 && maxprice == -999)
        {
            for (int i = filteredList.size() - 1; i >= 0; i--) {
                if (filteredList.get(i).getPrice() < minprice) filteredList.remove(i);
            }

        }
        else if(minprice == -999 && maxprice != -999)
        {
            for (int i = filteredList.size() - 1; i >= 0; i--) {
                if (filteredList.get(i).getPrice() > maxprice) filteredList.remove(i);
            }

        }
        if(minprice != -999 && maxprice != -999)
        {
            for (int i = filteredList.size() - 1; i >= 0; i--) {
                if (filteredList.get(i).getPrice() > maxprice) filteredList.remove(i);
            }
            for (int i = filteredList.size() - 1; i >= 0; i--) {
                if (filteredList.get(i).getPrice() < minprice) filteredList.remove(i);
            }

        }
        if(brand != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getBrand().contains(brand)) filteredList.remove(i);
            }
        }
        if(model != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getModel().contains(model)) filteredList.remove(i);
            }
        }
        if(screenSize != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getScreenSize().equals(screenSize)) filteredList.remove(i);
            }
        }
        if(internalMemory!=-999)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(filteredList.get(i).getInternalMemory() != internalMemory) filteredList.remove(i);
            }
        }
        return  filteredList;
    }

}
