package com.planets.aplication.controller;

import com.planets.aplication.domain.Lord;
import com.planets.aplication.domain.Planet;
import com.planets.aplication.service.LordService;
import com.planets.aplication.service.PlanetService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path="/planets")
public class PlanetsController {

    private final PlanetService planetService;

    private final LordService lordService;

    public PlanetsController(PlanetService planetService, LordService lordService) {
        this.planetService = planetService;
        this.lordService = lordService;
    }

    @GetMapping(path = "/newPlanet")
    public ModelAndView showPlanets (
                                    ModelAndView modelAndView
    ) {
        modelAndView.addObject("newPlanet", new Planet());
        modelAndView.setViewName("newPlanet");
        return modelAndView;
    }

    @PostMapping(path = "/newPlanet")
    public ModelAndView addNewPlanet (
                                      @ModelAttribute("newPlanet") Planet newPlanet,
                                      ModelAndView modelAndView
    ) {

//        newPlanet.setLord(lordService.getLordById(1));
        planetService.addNewPlanet(newPlanet);
        modelAndView.addObject("newPlanet", newPlanet);
        modelAndView.setViewName("newPlanet");
        return modelAndView;
    }

    @GetMapping(path = "/showAllPlanets")
    public ModelAndView showAllPlanets (
                                        ModelAndView modelAndView
    ) {
        modelAndView.addObject("allLords", lordService.getAllLords());
        modelAndView.addObject("allPlanets", planetService.getAllPlanets());
        modelAndView.setViewName("showAllPlanets");
        return modelAndView;
    }

    @GetMapping(path = "/showPlanet/{planetId}")
    public ModelAndView showLord(
                                    @PathVariable("planetId") Long id,
                                    ModelAndView modelAndView
    ) {
        modelAndView.addObject("assignedLord", new Lord());
        modelAndView.addObject("allLords", lordService.getAllLords());
        modelAndView.addObject("chosenPlanet", planetService.getPlanetById(id));
        modelAndView.setViewName("showPlanet");
        return modelAndView;
    }

    @PostMapping(path ="/deletePlanet/{planetId}")
    public ModelAndView deletePlanet (
                                        @PathVariable("planetId") Long id,
                                        ModelAndView modelAndView
    ) {
        planetService.deletePlanetById(id);
        modelAndView.setViewName("redirect:/planets/showAllPlanets");
        return modelAndView;
    }

    @PostMapping(path="/assignLord/{planetId}")
    public ModelAndView assignLordToPlanet (
                                            @ModelAttribute("assignedLord") Lord assignedLord,
                                            @PathVariable("planetId") long planetId,
                                            ModelAndView modelAndView
    ) {
        planetService.assignLordToPlanet(planetId, assignedLord.getId());
        modelAndView.setViewName("lordAssigned");
        return modelAndView;
    }

    @GetMapping(path="/lordAssigned")
    public ModelAndView lordAssistedPage (
                                            ModelAndView modelAndView
    ) {
        modelAndView.setViewName("lordAssigned");
        return modelAndView;
    }
}
