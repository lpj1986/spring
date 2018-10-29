package win.elegentjs.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/index")
public class DefaultController {

    @RequestMapping(path = "")
    public String index() {
        return "index";
    }
}
