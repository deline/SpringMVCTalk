package com.delineneo.web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * User: deline
 * Date: 2/05/13
 * Time: 8:55 PM
 */
@Controller
@RequestMapping(value = "/player")
public class ViewPlayerController {



    @RequestMapping(value = "{playerId}")
    public String viewPlayerDetails(@PathVariable int playerId) {
        return "playerDetails";
    }

}
