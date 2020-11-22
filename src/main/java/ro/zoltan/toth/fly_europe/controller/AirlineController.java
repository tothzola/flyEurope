package ro.zoltan.toth.fly_europe.controller;

import org.springframework.web.bind.annotation.RequestMapping;

public class AirlineController {

    @RequestMapping({"/airlines"})
    public String airlinesPage() {
        return "airlines";
    }
}
