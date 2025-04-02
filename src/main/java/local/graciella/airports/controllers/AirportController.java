/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.graciella.airports.controllers;

import local.graciella.airports.DTO.AirportMinDTO;
import java.util.List;
import local.graciella.airports.DTO.AirportNearMeDTO;
import local.graciella.airports.entities.Airport;
import local.graciella.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;




/**
 *
 * @author sesideva
 */
@RestController
public class AirportController {
    @Autowired
private AirportService airportService;

/**
 * Endpoint /airports/airport
 * Retorna TODOS os aeroportos da base de dados.
 * @return
 */
@GetMapping("/airport")
public List<Airport> findAll() {
    List<Airport> result = airportService.findAll();
    return result;
}

/**
 * Endpoint /airports/city/{cityName}  
 * preparado para devolver código de status conforme  
 * padronização REST.  
 * @param cityName  
 * @return  
 */
@GetMapping("/city/{cityName}")  
public ResponseEntity<List<Airport>> findByCityIgnoreCase(@PathVariable String cityName) {  
    List<Airport> result = airportService.findByCity(cityName);  

    if (result.isEmpty()) {  
        // Ops.. lista vazia...  
        // notFound devolve 404  
        return ResponseEntity.notFound().build();  
    } else {  
        // Eba! Tem dados!  
        // ok devolve 200  
        return ResponseEntity.ok(result);  
    }  
}
@GetMapping("/country/{countryName}")
public ResponseEntity<List<AirportMinDTO>> findByCountryIgnoreCase(@PathVariable String countryName) {

    List<AirportMinDTO> result = airportService.findByCountry(countryName);
    if (result.isEmpty()) {
        // Ops.. lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}



@GetMapping("/iatacode/{iataCode}")
public ResponseEntity<Airport> findByIataCode(@PathVariable String iataCode) {
    Airport result = airportService.findByIataCode(iataCode);

    if (result == null) {
        // Ops.. Aeroporto vazio...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}

/**
 * Endpoint /airports/nearme
 * Retorna os aeroportos próximos à coordenada enviada como parâmetro
 * da requisição GET.
 *
 * @param latitude
 * @param longitude
 * @return
 */
@GetMapping("/nearme")
public ResponseEntity<List<AirportNearMeDTO>> findNearMe(
    @RequestParam double latitude,
    @RequestParam double longitude) {

    List<AirportNearMeDTO> result = airportService.findNearMe(latitude, longitude);

    if (result.isEmpty()) {
        // Ops... lista vazia...
        // notFound devolve 404
        return ResponseEntity.notFound().build();
    } else {
        // Eba! Tem dados!
        // ok devolve 200
        return ResponseEntity.ok(result);
    }
}

}