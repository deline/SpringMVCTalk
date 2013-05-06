package com.delineneo.web.controller.old;

import com.delineneo.web.form.Player;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: deline
 * Date: 6/05/13
 * Time: 7:58 PM
 */
public class ViewPlayerController extends AbstractCommandController {

    public ViewPlayerController() {
        setCommandClass(Player.class);
        setCommandName("player");
    }

    @Override
    protected ModelAndView handle(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
        return new ModelAndView("playerDetails");
    }
}
