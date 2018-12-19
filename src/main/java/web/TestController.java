package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/hello")
public class TestController {
    @RequestMapping(method = RequestMethod.GET)
    public String hello(Model uiModel) {
        return "data";

    }
}