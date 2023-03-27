package demo.Controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MVC_Controller {
    @GetMapping("/")
    public String index(ModelMap model)
    {
        return "/createtable";
    }

    @GetMapping("/commontableview")
    public String common(ModelMap model, HttpServletRequest request, HttpServletResponse response)
    {
        model.addAttribute("restApi","rest/tableview");
        return "CommonTableView";
    }
}
