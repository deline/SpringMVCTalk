package com.delineneo.web.controller.old;

import com.delineneo.service.PlayerService;
import com.delineneo.web.form.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.SimpleFormController;


/**
 * User: deline
 * Date: 6/05/13
 * Time: 7:34 PM
 */
public class AddPlayerController extends SimpleFormController {

    @Autowired
    private PlayerService playerService;

    public AddPlayerController() {
        setCommandClass(Player.class);
        setCommandName("player");
    }

    @Override
    protected ModelAndView onSubmit(Object command) throws Exception {
        playerService.save((Player)command);
        ModelAndView modelAndView = new ModelAndView(getSuccessView());
        modelAndView.addObject("player");
        return modelAndView;
    }
}
