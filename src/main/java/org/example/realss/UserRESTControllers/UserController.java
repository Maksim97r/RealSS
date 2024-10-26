package org.example.realss.UserRESTControllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/api")
public class UserController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello";
    }
}
