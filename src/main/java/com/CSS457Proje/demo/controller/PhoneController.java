package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.entity.Product;
import com.CSS457Proje.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Filter;

/**
 *
 * This Controller does database connection with webservice in terms of Phone entity
 */
@RestController
public class PhoneController {
    @Autowired
    private PhoneService phoneService;
    /**
     * This function adds Phone with given Phone informations with POST request method
     * @param phone with request body
     * @return Phone goes to savePhone function of PhoneService
     */
    @PostMapping("/addPhone")
    public Phone addPhone(@RequestBody Phone phone){
        return phoneService.savePhone(phone);
    }
    /**
     * This function get all Phones with their Phone informations with GET request method
     * @return getPhones function of PhoneService
     */
    @GetMapping("/getPhones")

    public List<Phone> getProducts() { return phoneService.getPhones(); }
    

    public List<Phone> getPhones() { return phoneService.getPhones(); }

    /**
     * @return 
     */
    //getPhones2 is just for testing
    @GetMapping("/getPhones2")
    public List<Phone> getPhones2() {
        List<Phone> Phones = phoneService.getPhones();
        Phone p1 = new Phone();
        p1.setProductID(11);
        p1.setName("testphone3");
        Phones.add(p1);
        return Phones; }
    /**
     * This function get Phone that has given id with their Phone informations with GET request method
     * @param id
     * @return id goes to getPhone function of PhoneService
     */
    @GetMapping("/getPhone/{id}")
    public Phone getPhone(@PathVariable int id){
        return phoneService.getPhone(id);
    }
    /**
     * This function delete Phone that has given id with their Phone informations with Delete request method
     * @param id
     * id goes to deletePhone function of PhoneService
     */
    @DeleteMapping("/deletePhone/{id}")
    public void deletePhone(@PathVariable int id){
        phoneService.deletePhone(id);
    }
    /**
     * This function get Phones that has given brand or alike brand with their Phone informations with GET request method
     * @param brand name
     * @return brand goes to getPhonebyBrand function of PhoneService
     */
    @GetMapping("/getPhonebyBrand/{brand}")
    public List<Phone> getPhonebyBrand(@PathVariable String brand){ return phoneService.getPhonebyBrand(brand); }

    @GetMapping("/getPhonebyInternalmemory/{internalmemory}")
    public List<Phone> getPhonebyInternalMemory(@PathVariable int internalmemory){ return phoneService.getPhonebyInternalmemory(internalmemory); }
    /**
     * This function get Phones that has given name or alike name with their Phone informations with GET request method
     * @param name
     * @return name goes to getPhonebyName function of PhoneService
     */
    @GetMapping("/getPhonebyName/{name}")
    public List<Phone> getPhonebyName(@PathVariable String name){ return phoneService.getPhonebyName(name); }
    /**
     * This function get Phones that has given price or alike price with their Phone informations with GET request method
     * @param price
     * @return price goes to getPhonebyPrice function of PhoneService
     */
    @GetMapping("/getPhonebyPrice/{price}")
    public List<Phone> getPhonebyPrice(@PathVariable int price){ return phoneService.getPhonebyPrice(price); }
    /**
     * This function get Phones that has given model or alike model with their Phone informations with GET request method
     * @param model
     * @return model goes to getPhonebyModel function of PhoneService
     */
    @GetMapping("/getPhonebyModel/{model}")
    public List<Phone> getPhonebyModel(@PathVariable String model){ return phoneService.getPhonebyModel(model); }
    /**
     * This function get Phones that has given screen size or alike screen size with their Phone informations with GET request method
     * @param screenSize
     * @return screenSize goes to getPhonebyScreenSize function of PhoneService
     */
    @GetMapping("/getPhonebyScreensize/{screenSize}")
    public List<Phone> getPhonebyScreenSize(@PathVariable String screenSize){ return phoneService.getPhonebyScreenSize(screenSize); }
    /**
     * This function get Phones that has given many criteria or alike many criteria with their Phone informations with GET request method
     * @param productID,name,price,operator,brand,model,screenSize,storageCapacity,memory,processor,screenResolution,extraFeatures
     * @return list of Phone that filtered with given filter situations
     */
    @GetMapping("/filterPhonesWithCriteria")
    @ResponseBody
    public List<Phone> filterPhonesWithCriteria(@RequestParam(required = false,defaultValue = "-999") int productID,
                                        @RequestParam(required = false) String name,
                                        @RequestParam(required = false,defaultValue = "-999") int minprice,
                                        @RequestParam(required = false,defaultValue = "-999") int maxprice,
                                        @RequestParam(required = false) String brand,
                                        @RequestParam(required = false) String model,
                                        @RequestParam(required = false) String screenSize,
                                        @RequestParam(required = false,defaultValue = "-999") int internalMemory,
                                                @RequestParam(required = false) List<Integer> extraFeatures) {
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
        if(extraFeatures != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                List<Integer> tempExtraFeatureID = new ArrayList<>();
                for (ExtraFeature e:filteredList.get(i).getFeatures()) {
                    tempExtraFeatureID.add(e.getFeatureID());
                }
                if(!tempExtraFeatureID.containsAll(extraFeatures) || filteredList.get(i).getFeatures().size() == 0) filteredList.remove(i);
            }
        }
        return  filteredList;
    }

}
