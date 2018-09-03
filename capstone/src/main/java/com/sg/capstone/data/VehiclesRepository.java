/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.capstone.data;

import com.sg.capstone.model.Vehicles;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author blair
 */
@Repository
public interface VehiclesRepository extends JpaRepository<Vehicles, Integer> {

    @Query(value = "SELECT vehicles.* "
            + "FROM vehicles "
            + "INNER JOIN models ON vehicles.model_id = models.id "
            + "INNER JOIN brand ON models.brand_id = brand.id "  
            + "WHERE brand.name = ?1 ", nativeQuery = true)
    List<Vehicles> findVehicles(String name);

}
