package com.planets.aplication.controller;

import com.planets.aplication.domain.Lord;
import com.planets.aplication.domain.Role;
import com.planets.aplication.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
@RequestMapping(path= "/lords")
public class LordsController {


    private final LordService lordService;

    @Autowired
    public LordsController(LordService lordService) {
        this.lordService = lordService;
    }

    public LordService getLordService() {
        return lordService;
    }

    @GetMapping(path = "/newLord")
    public ModelAndView newLord2Post(ModelAndView modelAndView) {
        modelAndView.addObject("newLord", new Lord());
        modelAndView.setViewName("newLord");
        return modelAndView;
    }

    @PostMapping(path = "/newLord")
    public ModelAndView newLord2(
            @ModelAttribute("newLord") Lord newLord,
            ModelAndView modelAndView
    ) {
        newLord.setLordRole(Role.LORD);
        lordService.addUser(newLord);
        modelAndView.setViewName("newLord");
        return modelAndView;
    }


    @GetMapping(path = "/deleteLord")
    public ModelAndView deleteLord(
            ModelAndView modelAndView
    ) {
        modelAndView.setViewName("deleteLord");
        return modelAndView;
    }

    @PostMapping(path = "/deleteLord/{id}")
    public ModelAndView deleteLord(
            @PathVariable Long id,
            ModelAndView modelAndView) {
        lordService.deleteLordById(id);
        modelAndView.setViewName("redirect:/lords/showAllLords");
        return modelAndView;
    }

    @GetMapping(path = "/findYoungest")
    public ModelAndView findYoungestLords(
            ModelAndView modelAndView
    ) {
        List<Lord> tenYoungestLords = lordService.findTenYoungestLords();
        modelAndView.setViewName("tenYoungestLords");
        modelAndView.addObject("tenYoungestLords", tenYoungestLords);
        return modelAndView;
    }

    @GetMapping(path = "/showAllLords")
    public ModelAndView showAllLords(
            ModelAndView modelAndView
    ) {
        modelAndView.addObject("allLords", lordService.getAllLords());
        modelAndView.setViewName("showAllLords");
        return modelAndView;
    }

    @GetMapping(path = "/showLord/{lordId}")
    public ModelAndView showLord(
            @PathVariable("lordId") Long id,
            ModelAndView modelAndView
    ) {
        modelAndView.addObject("chosenLord", lordService.getLordById(id));
        modelAndView.setViewName("showLord");
        return modelAndView;
    }

    @GetMapping(path = "/supremeLordPage")
    public ModelAndView showSupremeLordPage(
            ModelAndView modelAndView
    ) {
        modelAndView.setViewName("supremeLordPage");
        return modelAndView;
    }

    @PostMapping(path="/createSupremeLord")
    public ModelAndView createSupremeLord (
                                            @ModelAttribute("supremeLord") Lord supremeLord,
                                            ModelAndView modelAndView
    ) {
        supremeLord.setLordRole(Role.SUPREME_LORD);
        supremeLord.setLordAge(3141);
        lordService.addUser(supremeLord);
        modelAndView.setViewName("/supremeLordPage");
        return modelAndView;
    }
}
