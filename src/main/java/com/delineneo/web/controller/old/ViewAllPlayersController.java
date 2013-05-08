package com.delineneo.web.controller.old;

import com.delineneo.service.PlayerService;
import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;
import org.springframework.web.servlet.mvc.AbstractController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.ServletRequestUtils.getIntParameter;

/**
 * User: deline
 * Date: 6/05/13
 * Time: 7:58 PM
 */
public class ViewAllPlayersController extends AbstractController {

    @Autowired
    private PlayerService playerService;

    @Override
    protected ModelAndView handleRequestInternal(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView modelAndView = new ModelAndView("allPlayers", "players", playerService.getAllPlayers());
        return modelAndView;
    }
}
