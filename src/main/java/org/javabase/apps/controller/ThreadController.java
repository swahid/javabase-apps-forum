/**
 * 
 */
package org.javabase.apps.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javabase.apps.entity.Comment;
import org.javabase.apps.service.CommentService;
import org.javabase.apps.service.ThreadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value="thread")
public class ThreadController {
    
    @Autowired
    ThreadService threadService;
    
    @Autowired
    CommentService commentService;
    
    @RequestMapping(value="new",method=RequestMethod.GET)
    public String thread(){
        return "create_thread";
    }
    @RequestMapping(value="home",method=RequestMethod.GET)
    public String threadList(){
    	return "redirect:/home";
    }
    
    @RequestMapping(value="view/{contentId}",method=RequestMethod.GET)
    public String loadThread(@PathVariable int contentId, Model model){
        
//        Thread thread =threadService.getThreadbyId(contentId);
//        
//        model.addAttribute("viewContent", thread);
//        model.addAttribute("comments", commentService.getCommentbyContentId(thread.getThreadId()));
        return "view_thread";
    }
    
    @ResponseBody
    @RequestMapping(value="create",method=RequestMethod.POST)
    public Map<String, Object> newThread(@RequestBody Map<String, Object> entity){
        Map<String, Object> response = new HashMap<>();
        
        
        /*try {
            Thread.setCreateDate(new Date());
             boolean save = threadService.addThread(Thread);
            if (save) {
                response.put("suceess", true);
                response.put("message", "Thread Post");
                response.put("path", "home");
            }else {
                response.put("error", true);
                response.put("message", "unable to save");
            }
        } catch (Exception e) {
            response.put("suceess", false);
            response.put("message", "unable to save");
            e.printStackTrace();
        }*/
        response.put("suceess", true);
        response.put("message", "Thread Post");
        return response;
    }
    
    @ResponseBody
    @RequestMapping(value="view/comment/new",method=RequestMethod.POST)
    public Map<String, Object> addComment(@RequestBody Comment comment){
        Map<String, Object> response = new HashMap<>();
        
        comment.setCreateDate(new Date());
        boolean save = commentService.addComment(comment);
        
        if (save) {
            response.put("suceess", true);
            response.put("message", "Comment Published");
        }else {
            response.put("error", true);
            response.put("message", "Comment Unable to Published");
        }
        return response;
    }

}
