/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.service;

import com.sg.capstone.data.AppointmentsRepository;
import com.sg.capstone.data.BrandRepository;
import com.sg.capstone.data.ContactRepository;
import com.sg.capstone.data.ModelsRepository;
import com.sg.capstone.data.SalesRepository;
import com.sg.capstone.data.SpecialsRepository;
import com.sg.capstone.data.UsersRepository;
import com.sg.capstone.data.Vehicle_TypesRepository;
import com.sg.capstone.data.VehiclesRepository;
import com.sg.capstone.model.Brand;
import com.sg.capstone.model.Contact;
import com.sg.capstone.model.Criteria;
import com.sg.capstone.model.Models;
import com.sg.capstone.model.Sales;
import com.sg.capstone.model.Vehicles;
import com.sg.capstone.model.vehicle_types;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author blair
 */
@Service
public class vehicleService {

    @Autowired
    private ModelsRepository modelsRepository;

    @Autowired
    private BrandRepository brandRepository;

    @Autowired
    private Vehicle_TypesRepository vehicle_TypesRepository;

    @Autowired
    private UsersRepository usersRepository;

    @Autowired
    private SalesRepository salesRepository;

    @Autowired
    private SpecialsRepository specialsRepository;

    @Autowired
    private AppointmentsRepository appointmentsRepository;

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Autowired
    private ContactRepository contactRepository;

    public List<Brand> getAllBrands() {
        return brandRepository.findAll();

    }

    public Brand save(Brand brand) {
        return brandRepository.save(brand);

    }

    public List<Models> getAllModels() {
        return modelsRepository.findAll();

    }

    public Models save(Models model) {
        return modelsRepository.save(model);

    }

    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();

    }

    public Vehicles save(Vehicles vehicle) {
        return vehiclesRepository.save(vehicle);

    }
  
  
    public List<vehicle_types> getAllVehicleTypes() {
        return vehicle_TypesRepository.findAll();

    }

    public vehicle_types save(vehicle_types vehicletype) {
        return vehicle_TypesRepository.save(vehicletype);

    }

    public List<Sales> getAllSales() {
        return salesRepository.findAll();

    }

    public Sales save(Sales sale) {
        return salesRepository.save(sale);

    }

    public List<Contact> getAllContacts() {
        return contactRepository.findAll();

    }

    public Contact save(Contact contact) {
        return contactRepository.save(contact);

    }

    public List<Vehicles> search(Criteria criteria) {
        return vehiclesRepository.findVehicles(criteria.getSearch());
    }

    public List<Vehicles> GetSearchResult() {
        return vehiclesRepository.findAll();

    }

 
}
