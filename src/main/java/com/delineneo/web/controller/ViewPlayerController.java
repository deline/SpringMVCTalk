package com.delineneo.web.controller;

import com.delineneo.service.PlayerService;
import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * User: deline
 * Date: 2/05/13
 * Time: 8:55 PM
 */
@Controller
@RequestMapping(value = "/player")
public class ViewPlayerController {

    @Autowired
    private PlayerService playerService;

    @RequestMapping(value = "{playerId}")
    public String viewPlayerDetails(@PathVariable int playerId, Model model) {
        model.addAttribute("player", playerService.getPlayer(playerId));
        return "playerDetails";
    }

    @RequestMapping(value="/all")
    public String viewAllPlayers(Model model) {
        List<Player> allPlayers = playerService.getAllPlayers();
        model.addAttribute("players", allPlayers);
        return "allPlayers";
    }
}
