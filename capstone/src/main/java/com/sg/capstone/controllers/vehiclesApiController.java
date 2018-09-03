/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.controllers;

import com.sg.capstone.model.Brand;
import com.sg.capstone.model.Contact;
import com.sg.capstone.model.Criteria;
import com.sg.capstone.model.Models;
import com.sg.capstone.model.Sales;
import com.sg.capstone.model.Vehicles;
import com.sg.capstone.model.vehicle_types;
import com.sg.capstone.service.vehicleService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author blair
 */
@RestController
@RequestMapping("/api")
public class vehiclesApiController {

    @Autowired
    private vehicleService service;

    @GetMapping("/brand")
    public List<Brand> getAllBrands() {
        return service.getAllBrands();
    }

    @PostMapping("/brand")
    public ResponseEntity<Brand> addBrand(@RequestBody Brand brand) {
        brand = service.save(brand);
        return ResponseEntity.ok(brand);

    }

    @PutMapping("/brand")
    public ResponseEntity<Brand> updateBrand(@PathVariable int Id, @RequestBody Brand brand) {
        brand = service.save(brand);
        return ResponseEntity.ok(brand);
    }

    @GetMapping("/model")
    public List<Models> getAllModels() {
        return service.getAllModels();
    }

    @PostMapping("/model")
    public ResponseEntity<Models> addModel(@RequestBody Models model) {
        model = service.save(model);
        return ResponseEntity.ok(model);

    }

    @PutMapping("/model")
    public ResponseEntity<Models> updateModel(@PathVariable int Id, @RequestBody Models model) {
        model = service.save(model);
        return ResponseEntity.ok(model);
    }

    @GetMapping("/vehicles")
    public List<Vehicles> getAllVehicles() {
        return service.getAllVehicles();
    }

    @PostMapping("/vehicles")
    public ResponseEntity<Vehicles> addVehicles(@RequestBody Vehicles vehicle) {
        vehicle = service.save(vehicle);
        return ResponseEntity.ok(vehicle);

    }

    @PutMapping("/vehicles")
    public ResponseEntity<Vehicles> updateVehicles(@PathVariable int Id, @RequestBody Vehicles vehicle) {
        vehicle = service.save(vehicle);
        return ResponseEntity.ok(vehicle);
    }
    

    @GetMapping("/vehicleTypes")
    public List<vehicle_types> getAllVehicleTypes() {
        return service.getAllVehicleTypes();
    }

    @PostMapping("/vehicleTypes")
    public ResponseEntity<vehicle_types> addVehicleTypes(@RequestBody vehicle_types vehicletype) {
        vehicletype = service.save(vehicletype);
        return ResponseEntity.ok(vehicletype);

    }

    @PutMapping("/vehicleTypes")
    public ResponseEntity<vehicle_types> updateVehicleTypes(@PathVariable int Id, @RequestBody vehicle_types vehicletype) {
        vehicletype = service.save(vehicletype);
        return ResponseEntity.ok(vehicletype);
    }

    @GetMapping("/sales")
    public List<Sales> getAllSales() {
        return service.getAllSales();
    }

    @PostMapping("/sales")
    public ResponseEntity<Sales> addSales(@RequestBody Sales sale) {
        sale = service.save(sale);
        return ResponseEntity.ok(sale);
//addVSales
    }

    @PutMapping("/sales")
    public ResponseEntity<Sales> updateVehicleTypes(@PathVariable int Id, @RequestBody Sales sale) {
        sale = service.save(sale);
        return ResponseEntity.ok(sale);
    }

    @GetMapping("/contact")
    public List<Contact> getAllContacts() {
        return service.getAllContacts();
    }

    @PostMapping("/contact")
    public ResponseEntity<Contact> addContact(@RequestBody Contact contact) {
        contact = service.save(contact);
        return ResponseEntity.ok(contact);

    }

    @PutMapping("/contact")
    public ResponseEntity<Contact> updateContact(@PathVariable int Id, @RequestBody Contact contact) {
        contact = service.save(contact);
        return ResponseEntity.ok(contact);
    }

    @PostMapping("/search")
    public List<Vehicles> search(@RequestBody Criteria criteria) {
        return service.search(criteria);
    }
    
    @GetMapping("/search")
    public List<Vehicles> GetSearchResult() {
        return service.GetSearchResult();
    }

}
