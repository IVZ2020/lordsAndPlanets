package com.planets.aplication.service;

import com.planets.aplication.domain.Lord;
import com.planets.aplication.domain.Planet;
import com.planets.aplication.repository.LordRepository;
import com.planets.aplication.repository.PlanetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Component
@Service
public class PlanetService {


    private final PlanetRepository planetRepository;

    private final LordService lordService;

    public PlanetService(PlanetRepository planetRepository, LordService lordService) {
        this.planetRepository = planetRepository;
        this.lordService = lordService;
    }

    public void addNewPlanet (Planet planet) {
        planetRepository.save(planet);
    }

    public List<Planet> getAllPlanets () {
        return planetRepository.findAll();
    }

    public Planet getPlanetById (long id) {
        if (planetRepository.findById(id).isPresent()) {
            return planetRepository.findById(id).get();
        }
        return null;
    }

    public void deletePlanetById (long id) {
        planetRepository.deleteById(id);
    }

    public void assignLordToPlanet (long planetId, long lordId) {
            Planet planet = planetRepository.getById(planetId);
            planet.setLord(lordService.getLordById(lordId));
            planetRepository.save(planet);
    }
}
