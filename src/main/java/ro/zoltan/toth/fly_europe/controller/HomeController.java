package ro.zoltan.toth.fly_europe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import ro.zoltan.toth.fly_europe.domain.Airport;
import ro.zoltan.toth.fly_europe.repository.AirportRepository;
import ro.zoltan.toth.fly_europe.service.AirportService;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private AirportService airportService;

    @Autowired
    private AirportRepository airportRepository;

    @RequestMapping("/")
    public String viewHomePage(final Model model) {
        return viewPage(model, 1, "id", "asc");
    }

    @PostMapping("/search")
    public String search(final Model model,
                         @ModelAttribute("keyword") final String keyword) {
        int pageNum = 1;
        String sortField = "id";
        String sortDir = "asc";

        Page<Airport> page = airportService.searchByNameAndCity(pageNum, sortField, sortDir, keyword);
        List<Airport> listAirports = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", "desc");

        model.addAttribute("listAirports", listAirports);

        return "index";

    }

    @RequestMapping("/page/{pageNum}")
    public String viewPage(final Model model,
                           @PathVariable(name = "pageNum") int pageNum,
                           @Param("sortField") String sortField,
                           @Param("sortDir") String sortDir) {

        Page<Airport> page = airportService.listAll(pageNum, sortField, sortDir);
        List<Airport> listAirports = page.getContent();

        model.addAttribute("currentPage", pageNum);
        model.addAttribute("totalPages", page.getTotalPages());
        model.addAttribute("totalItems", page.getTotalElements());

        model.addAttribute("sortField", sortField);
        model.addAttribute("sortDir", sortDir);
        model.addAttribute("reverseSortDir", sortDir.equals("asc") ? "desc" : "asc");

        model.addAttribute("listAirports", listAirports);

        return "index";
    }

//    @RequestMapping("/new")
//    public String showNewAirportForm(Model model) {
//        Airport airport = new Airport();
//        model.addAttribute("airport", airport);
//        return "new_airport";
//    }

    @PreAuthorize("hasRole('administrator')")
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveAirport(@ModelAttribute("airport") Airport airport) {
        airportService.save(airport);
        return "redirect:/";
    }

    @RequestMapping("/airport/{id}")
    public ModelAndView showEditAirportForm(@PathVariable(name = "id") Long id) {
        ModelAndView mav = new ModelAndView("airport");
        Airport airport = airportService.get(id);
        mav.addObject("airport", airport);
        return mav;
    }

    @RequestMapping("/delete/{id}")
    public String deleteAirport(@PathVariable(name = "id") Long id) {
        airportService.delete(id);
        return "redirect:/";
    }

    @GetMapping("/403")
    public String error403() {
        return "error/403";
    }

}
