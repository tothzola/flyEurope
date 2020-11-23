package ro.zoltan.toth.fly_europe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AirlineController {

    @RequestMapping({"/airlines"})
    public String airlinesPage() {
        return "airlines";
    }
}
