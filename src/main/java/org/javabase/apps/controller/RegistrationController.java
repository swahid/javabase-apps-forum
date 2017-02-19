/**
 * 
 */
package org.javabase.apps.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javabase.apps.entity.User;
import org.javabase.apps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Controller
@RequestMapping(value="registration")
public class RegistrationController {
    
    @Autowired
    UserService userService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String registration() {
        return "registration";
    }
    
    @ResponseBody
    @RequestMapping(value="new", method = RequestMethod.POST)
    public Map<String, Object> newRegistration(@RequestBody User user){
        Map<String, Object> response = new HashMap<>();
        
        user.setAccountActive(true);
        user.setNonExpired(true);
        user.setNonLocked(true);
        user.setRegistrationDate(new Date());
        boolean save =userService.addUser(user);
        if (save) {
            response.put("suceess", true);
            response.put("message", "Registration Sucess");
            response.put("url", "login");
        }else {
            response.put("suceess", false);
            response.put("message", "Registration Failed");
        }
        return response;
    }

}
