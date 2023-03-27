package demo.Controller;

import demo.Service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class Restcontroller {

    @Autowired
    UserService userService;

    @PostMapping("rest/registration")
    public ResponseEntity<String> index(@RequestParam Map<String, Object> param, HttpServletRequest request) throws JSONException {
        return (userService.createTableView(param, request));
//        return ResponseEntity.ok("Data saved successfully");
    }

    @GetMapping("rest/getkey")
    public ResponseEntity<String>getKey(@RequestParam Map<String, Object> param, HttpServletRequest request)
    {
        return (userService.getKey(param,request));
    }

    @GetMapping("rest/tableview")
    public Object getTableView(@RequestParam Map<String, Object> param, HttpServletRequest request, HttpServletResponse response) throws JSONException {
        return userService.getTableView(param,request,response);
    }
}
