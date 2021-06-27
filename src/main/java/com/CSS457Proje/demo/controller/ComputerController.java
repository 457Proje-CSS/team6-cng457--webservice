package com.CSS457Proje.demo.controller;

import com.CSS457Proje.demo.entity.Computer;
import com.CSS457Proje.demo.entity.ExtraFeature;
import com.CSS457Proje.demo.entity.Phone;
import com.CSS457Proje.demo.service.ComputerService;
import com.CSS457Proje.demo.service.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Çağatay Gültekin
 * @author Soykan Kamal
 * @Serhat Korkmaz
 */

/**
 *
 * This Controller does database connection with webservice in terms of Computer entity
 */
@RestController
public class ComputerController {
    @Autowired
    private ComputerService computerService;
    /**
     * This function adds Computer with given Computer informations with POST request method
     * @param computer with request body
     * @return Computer goes to saveComputer function of ComputerService
     */
    @PostMapping("/addComputer")
    public Computer addComputer(@RequestBody Computer computer){
        return computerService.saveComputer(computer);
    }
    /**
     * This function get all Computers with their Computer informations with GET request method
     * @return getComputers function of ComputerService
     */
    @GetMapping("/getComputers")

    public List<Computer> getComputer() { return computerService.getComputers(); }


    public List<Computer> getComputers() { return computerService.getComputers(); }

    //getComputers2 is just for testing
    @GetMapping("/getComputers2")
    public List<Computer> getComputers2() {
        List<Computer> computers = computerService.getComputers();
        Computer c1 = new Computer();
        c1.setProductID(10);
        c1.setName("testcomputer3");
        computers.add(c1);
        return computers; }

    /**
     * This function get Computer that has given id with their Computer informations with GET request method
     * @param id
     * @return id goes to getComputer function of ComputerService
     */
    @GetMapping("/getComputer/{id}")
    public Computer getComputer(@PathVariable int id){
        return computerService.getComputer(id);
    }
    /**
     * This function delete Computer that has given id with their Computer informations with Delete request method
     * @param id
     * id goes to deleteComputer function of ComputerService
     */
    @DeleteMapping("/deleteComputer/{id}")
    public void deleteComputer(@PathVariable int id){ computerService.deleteComputer(id); }
    /**
     * This function get Computers that has given brand or alike brand with their Computer informations with GET request method
     * @param brand name
     * @return brand goes to getComputerbyBrand function of ComputerService
     */
    @GetMapping("/getComputerbyBrand/{brand}")
    public List<Computer> getComputerbyBrand(@PathVariable String brand){ return computerService.getComputerbyBrand(brand); }
    /**
     * This function get Computers that has given name or alike name with their Computer informations with GET request method
     * @param name
     * @return name goes to getComputerbyName function of ComputerService
     */
    @GetMapping("/getComputerbyName/{name}")
    public List<Computer> getComputerbyName(@PathVariable String name){ return computerService.getComputerbyName(name); }
    /**
     * This function get Computers that has given price or alike price with their Computer informations with GET request method
     * @param price
     * @return price goes to getComputerbyPrice function of ComputerService
     */
    @GetMapping("/getComputerbyPrice/{price}")
    public List<Computer> getComputerbyPrice(@PathVariable int price){ return computerService.getComputerbyPrice(price); }
    /**
     * This function get Computers that has given model or alike model with their Computer informations with GET request method
     * @param model
     * @return model goes to getComputerbyModel function of ComputerService
     */
    @GetMapping("/getComputerbyModel/{model}")
    public List<Computer> getComputerbyModel(@PathVariable String model){ return computerService.getComputerbyModel(model); }
    /**
     * This function get Computers that has given screen size or alike screen size with their Computer informations with GET request method
     * @param screenSize
     * @return screenSize goes to getComputerbyScreenSize function of ComputerService
     */
    @GetMapping("/getComputerbyScreenSize/{screenSize}")
    public List<Computer> getComputerbyScreenSize(@PathVariable String screenSize){ return computerService.getComputerbyScreenSize(screenSize); }
    /**
     * This function get Computers that has given storage capacity or alike storage capacity with their Computer informations with GET request method
     * @param storageCapacity
     * @return storageCapacity goes to getComputerbyStorageCapacity function of ComputerService
     */
    @GetMapping("/getComputerbyStorageCapacity/{storageCapacity}")
    public List<Computer> getComputerbyStorageCapacity(@PathVariable int storageCapacity){ return computerService.getComputerbyStorageCapacity(storageCapacity); }
    /**
     * This function get Computers that has given memory or alike memory with their Computer informations with GET request method
     * @param memory
     * @return memory goes to getComputerbyMemory function of ComputerService
     */
    @GetMapping("/getComputerbyMemory/{memory}")
    public List<Computer> getComputerbyMemory(@PathVariable int memory){ return computerService.getComputerbyMemory(memory); }
    /**
     * This function get Computers that has given processor or alike processor with their Computer informations with GET request method
     * @param processor
     * @return processor goes to getComputerbyProcessor function of ComputerService
     */
    @GetMapping("/getComputerbyProcessor/{processor}")
    public List<Computer> getComputerbyProcessor(@PathVariable String processor){ return computerService.getComputerbyProcessor(processor); }
    /**
     * This function get Computers that has given screen resolution or alike screen resolution with their Computer informations with GET request method
     * @param screenResolution
     * @return screenResolution goes to getComputerbyScreenResolution function of ComputerService
     */
    @GetMapping("/getComputerbyProcessor/{screenResolution}")
    public List<Computer> getComputerbyScreenResolution(@PathVariable String screenResolution){ return computerService.getComputerbyScreenResolution(screenResolution); }
    /**
     * This function get Computers that has given many criteria or alike many criteria with their Computer informations with GET request method
     * @param productID,name,price,operator,brand,model,screenSize,storageCapacity,memory,processor,screenResolution,extraFeatures
     * @return list of computer that filtered with given filter situations
     */
    @GetMapping("/filterComputersWithCriteria")
    @ResponseBody
    public List<Computer> filterPhonesWithCriteria(@RequestParam(required = false,defaultValue = "-999") int productID,
                                                @RequestParam(required = false) String name,
                                                @RequestParam(required = false,defaultValue = "-999") int minprice,
                                                @RequestParam(required = false,defaultValue = "-999") int maxprice,
                                                @RequestParam(required = false) String brand,
                                                @RequestParam(required = false) String model,
                                                @RequestParam(required = false) String screenSize,
                                                @RequestParam(required = false,defaultValue = "-999") int storageCapacity,
                                                @RequestParam(required = false,defaultValue = "-999") int memory,
                                                @RequestParam(required = false) String processor,
                                                @RequestParam(required = false) String screenResolution,
                                                   @RequestParam(required = false) List<Integer> extraFeatures) {
        List<Computer> filteredList = computerService.getComputers();
        /**
         * If the given argument is not null, the list is filtered by that argument. More than one argument can be given.
         */
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
        if(storageCapacity!=-999)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(filteredList.get(i).getStorageCapacity() != storageCapacity) filteredList.remove(i);
            }
        }
        if(memory!=-999)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(filteredList.get(i).getMemory() != memory) filteredList.remove(i);
            }
        }
        if(processor != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getProcessor().contains(processor)) filteredList.remove(i);
            }
        }
        if(screenResolution != null)
        {
            for(int i=filteredList.size()-1; i>=0; i--) {
                if(!filteredList.get(i).getScreenResolution().contains(screenResolution)) filteredList.remove(i);
            }
        }
        /*if(extraFeatures != null)
        {
            for (Integer id:extraFeatures) {
                for(int i=filteredList.size()-1; i>=0; i--) {
                    if(!filteredList.get(i).getFeatures().contains(id)) filteredList.remove(i);
                }
            }
        }*/
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
