package PlanetBook.Controller;

import PlanetBook.Entity.PlanetSystem;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by MICHAL on 14.3.2017.
 */

/// IN PROGRESS ///

@RestController
public class UserController {

    @RequestMapping("user/login")
    public String login(@RequestParam("login") String user, @RequestParam("passHash") String hash) {
        return  "token";
    }

    @RequestMapping("user/logout")
    public boolean logout(@RequestParam("login") String user, @RequestParam("token") String token) {
        return  true;
    }
}