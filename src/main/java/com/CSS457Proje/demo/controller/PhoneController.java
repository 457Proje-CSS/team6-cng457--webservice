package com.CSS457Proje.demo.controller;

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
     * This function adds Computer with given Computer informations with POST request method
     * @param phone with request body
     * @return Phone goes to savePhone function of ComputerService
     */
    @PostMapping("/addPhone")
    public Phone addProduct(@RequestBody Phone phone){
        return phoneService.savePhone(phone);
    }
    /**
     * This function get all Computers with their Computer informations with GET request method
     * @param
     * @return getComputers function of ComputerService
     */
    @GetMapping("/getPhones")
    public List<Phone> getProducts() { return phoneService.getPhones(); }
    /**
     * This function get Computer that has given id with their Computer informations with GET request method
     * @param id
     * @return id goes to getComputer function of ComputerService
     */
    @GetMapping("/getPhone/{id}")
    public Phone getProduct(@PathVariable int id){
        return phoneService.getPhone(id);
    }
    /**
     * This function delete Computer that has given id with their Computer informations with Delete request method
     * @param id
     * @return id goes to deleteComputer function of ComputerService
     */
    @DeleteMapping("/deletePhone/{id}")
    public void deleteProduct(@PathVariable int id){
        phoneService.deletePhone(id);
    }
    /**
     * This function get Computers that has given brand or alike brand with their Computer informations with GET request method
     * @param brand name
     * @return brand goes to getComputerbyBrand function of ComputerService
     */
    @GetMapping("/getPhonebyBrand/{brand}")
    public List<Phone> getPhonebyBrand(@PathVariable String brand){ return phoneService.getPhonebyBrand(brand); }

    @GetMapping("/getPhonebyInternalmemory/{internalmemory}")
    public List<Phone> getPhonebyInternalMemory(@PathVariable int internalmemory){ return phoneService.getPhonebyInternalmemory(internalmemory); }
    /**
     * This function get Computers that has given name or alike name with their Computer informations with GET request method
     * @param name
     * @return name goes to getComputerbyName function of ComputerService
     */
    @GetMapping("/getPhonebyName/{name}")
    public List<Phone> getPhonebyName(@PathVariable String name){ return phoneService.getPhonebyName(name); }
    /**
     * This function get Computers that has given price or alike price with their Computer informations with GET request method
     * @param price
     * @return price goes to getComputerbyPrice function of ComputerService
     */
    @GetMapping("/getPhonebyPrice/{price}")
    public List<Phone> getPhonebyPrice(@PathVariable int price){ return phoneService.getPhonebyPrice(price); }
    /**
     * This function get Computers that has given model or alike model with their Computer informations with GET request method
     * @param model
     * @return model goes to getComputerbyModel function of ComputerService
     */
    @GetMapping("/getPhonebyModel/{model}")
    public List<Phone> getPhonebyModel(@PathVariable String model){ return phoneService.getPhonebyModel(model); }
    /**
     * This function get Computers that has given screen size or alike screen size with their Computer informations with GET request method
     * @param screenSize
     * @return screenSize goes to getComputerbyScreenSize function of ComputerService
     */
    @GetMapping("/getPhonebyScreensize/{screenSize}")
    public List<Phone> getPhonebyScreenSize(@PathVariable String screenSize){ return phoneService.getPhonebyScreenSize(screenSize); }
    /**
     * This function get Computers that has given many criteria or alike many criteria with their Computer informations with GET request method
     * @param productID,name,price,operator,brand,model,screenSize,storageCapacity,memory,processor,screenResolution,extraFeatures
     * @return list of computer that filtered with given filter situations
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
