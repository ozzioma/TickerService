package com.ozzy.bcsproject.tickerservice;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Ozzy on 007, Jul 07, 2015.
 */
@Controller
//@RequestMapping("/")
public class HomeController
{

    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request,
                              HttpServletResponse response) throws Exception {

        ModelAndView model = new ModelAndView();
        model.setViewName("index");
        model.addObject("title", "Ticker Price and Dividends Service");

        return model;
    }
}
