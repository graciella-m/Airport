/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package local.graciella.airports.controllers;

import java.util.List;
import local.graciella.airports.entities.Airport;
import local.graciella.airports.service.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
