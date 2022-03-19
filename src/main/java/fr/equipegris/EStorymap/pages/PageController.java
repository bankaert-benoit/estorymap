package fr.equipegris.EStorymap.pages;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {

    @RequestMapping("/")
    public String index(){
        return "index.html";
    }
    
    @RequestMapping("/analyse")
    public String analyse() {
    	return "analyse.html";
    }

    @RequestMapping("/result")
    public String result() { return "result.html";}

    @RequestMapping("/settings")
    public String settings() {return "settings.html";}

    @RequestMapping("/about")
    public String about() {return "about.html";}

}
