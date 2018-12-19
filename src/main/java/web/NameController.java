package web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping ("/name")
public class NameController {
    @RequestMapping (value="/{firstname}", method = RequestMethod.GET)
    public String sayHello(Model uiModel, @PathVariable(value = "firstname") String name){
        uiModel.addAttribute("firstname", name);
        return "name";
    }
}
