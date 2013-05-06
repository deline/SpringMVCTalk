package com.delineneo.web.controller.old;

import com.delineneo.service.PlayerService;
import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.springframework.web.bind.ServletRequestUtils.getIntParameter;

/**
 * User: deline
 * Date: 6/05/13
 * Time: 7:58 PM
 */
public class ViewPlayerController extends AbstractCommandController {

    @Autowired
    private PlayerService playerService;

    @Override
    protected Player getCommand(HttpServletRequest request) throws Exception {
        return playerService.getPlayer(getIntParameter(request, "id"));
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        ModelAndView modelAndView = new ModelAndView("playerDetails", "player", command);
        return modelAndView;
    }


}
