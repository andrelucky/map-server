package com.map.nbio.mapserver.controller;

import com.map.nbio.mapserver.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private StockService stockService;

    @GetMapping(path = "/")
    public String home() {
        return "index";
    }
}
