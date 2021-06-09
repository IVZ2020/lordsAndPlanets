package com.planets.aplication.controller;

import com.planets.aplication.domain.Lord;
import com.planets.aplication.domain.Role;
import com.planets.aplication.service.LordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping(path = "/mainPage")
public class MainController {

    private final LordService lordService;

    @Autowired
    public MainController(LordService lordService) {
        this.lordService = lordService;
    }

    public LordService getLordService() {
        return lordService;
    }

    @GetMapping
    public ModelAndView showMainPage (ModelAndView modelAndView) {
        modelAndView.addObject("supremeLord", new Lord());
        modelAndView.setViewName("mainPage");
        return modelAndView;
    }

//    @PostMapping
//    public ModelAndView createSupremeLord (@ModelAttribute("supremeLord") Lord supremeLord,
//                                            ModelAndView modelAndView
//                                            ) {
//
////        modelAndView.addObject(lordService.getLordByName(supremeLord.getLordName()));
//        modelAndView.setViewName("/supremeLordPage");
//        return null;
//    }
}
