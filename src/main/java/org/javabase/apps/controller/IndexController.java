package org.javabase.apps.controller;

import java.security.Principal;

import org.javabase.apps.entity.Thread;
import org.javabase.apps.service.ThreadService;
import org.javabase.apps.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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
    UserService userService;
    
    @Autowired
    ThreadService threadService;
    
    @RequestMapping(value = { "/", "/home","/threads"}, method = RequestMethod.GET)
    public String home(Model model, Principal principal) {
        
        if (principal != null) {
            model.addAttribute("loginUser", userService.getUserByUsername(principal.getName()));
        }
        
        model.addAttribute("allThreadList", threadService.getAllThread());
        model.addAttribute("search", new Thread());
        log.debug("Welcome home! ");
        return "index";
    }
    
    @RequestMapping(value="/search",method=RequestMethod.POST)
    public String threadSearch(@ModelAttribute(value="search") Thread thread, Model model){
        
        String searchBy     = thread.getThreadTitle();
        String searchParam  = thread.getThreadDescription();
        
        model.addAttribute("allThreadList", threadService.searchThreadByParam(searchBy, searchParam));
        return "index";
    }
    
}
