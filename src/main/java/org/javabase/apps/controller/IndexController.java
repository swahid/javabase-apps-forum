package org.javabase.apps.controller;

import javax.servlet.http.HttpSession;

import org.javabase.apps.service.ThreadService;
import org.javabase.apps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Controller
public class IndexController {
    
    private static final Logger log = LoggerFactory.getLogger(IndexController.class);
    
    @Autowired
    UserService userservice;
    
    @Autowired
    ThreadService threadService;
    
    @Autowired
    HttpSession response;
    
    @RequestMapping(value = { "/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        
        model.addAttribute("allThreadList", threadService.getAllThread());
        log.info("Welcome home! ");
        return "index";
    }
    
}
