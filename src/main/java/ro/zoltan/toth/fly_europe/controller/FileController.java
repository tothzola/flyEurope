package ro.zoltan.toth.fly_europe.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import ro.zoltan.toth.fly_europe.domain.Flight;
import ro.zoltan.toth.fly_europe.service.FileService;

import java.util.List;

@Controller
public class FileController {

    @Autowired
    private FileService fileService;

    @RequestMapping("/file")
    public ModelAndView showUploadFilesPage() {
        return new ModelAndView("files-page");
    }

    @RequestMapping(method = RequestMethod.POST, path="/upload-file")
    public String uploadFile(@ModelAttribute("fileUrl") final String url, final Model model)  {
        final List<String> content = fileService.readContent(url);
        final List<Flight> flights = fileService.transformContent(content);
        boolean result = fileService.insertAll(flights);
        model.addAttribute("fileUploaded", result);
        return "upload-successful";
    }

}
