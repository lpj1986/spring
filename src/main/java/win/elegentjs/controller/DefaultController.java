package win.elegentjs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(path = "/index")
public class DefaultController {


    public ModelAndView index() {
        return new ModelAndView("index");
    }
}
