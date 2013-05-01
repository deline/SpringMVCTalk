package com.delineneo.web.controller;

import com.delineneo.service.PlayerService;
import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * User: deline
 * Date: 30/04/13
 * Time: 10:03 PM
 */
@Controller
@RequestMapping(value = "/player")
public class AddPlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addPlayer(Model model) {
        model.addAttribute(new Player());
        return "addPlayer";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String submit(@ModelAttribute @Valid Player player, BindingResult result) {
        if (result.hasErrors()) {
            return "addPlayer";
        } else {
            int playerId = playerService.save(player);
            return "redirect:/player/" + playerId;
        }
    }
}
