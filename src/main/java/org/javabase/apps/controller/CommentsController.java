/**
 * 
 */
package org.javabase.apps.controller;

import java.security.Principal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.javabase.apps.entity.Comment;
import org.javabase.apps.entity.Thread;
import org.javabase.apps.entity.User;
import org.javabase.apps.service.CommentService;
import org.javabase.apps.service.ThreadService;
import org.javabase.apps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author OITI
 *
 */
@Controller
@RequestMapping("thread/view/comment")
public class CommentsController {
    
    @Autowired
    UserService userService;
    
    @Autowired
    ThreadService threadService;
    
    @Autowired
    CommentService commentService;
    
    @ResponseBody
    @RequestMapping(value="/create",method=RequestMethod.POST)
    public Map<String, Object> addComment(@RequestBody Map<String, String> param, final Principal principal){
        Map<String, Object> response = new HashMap<>();
        
        Comment comment = new Comment();
        Thread thread   = new Thread();
        User user       = new User();
        
        if (!StringUtils.isEmpty(param.get("password"))) {
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            String hashedPassword = passwordEncoder.encode(param.get("password"));
            user.setUsername(param.get("username"));
            user.setPassword(hashedPassword);
            user.setFirstName(param.get("firstName"));
            user.setFirstName(param.get("lastName"));
            user.setAccountActive(true);
            user.setNonExpired(true);
            user.setNonLocked(true);
            user.setRegistrationDate(new Date());
            
            boolean addUser = userService.addUser(user);
            if (!addUser) {
                response.put("error", true);
                response.put("message", "user not create");
                return response;
            }
        }else {
            param.put("createUser", principal.getName());
        }
        String threadId = param.get("threadId");
        thread.setThreadId(Integer.valueOf(threadId));
        
        comment.setCommentDescription(param.get("commentDescription"));
        comment.setCommentTitle(param.get("commentTitle"));
        comment.setThread(thread);
        comment.setCreateUser(param.get("createUser"));
        comment.setCreateDate(new Date());
        
        boolean save = commentService.addComment(comment);
        if (save) {
            response.put("suceess", true);
            response.put("message", "Comment Published");
        }else {
            response.put("error", true);
            response.put("message", "Unable to Published");
        }
        return response;
    }
    @ResponseBody
    @RequestMapping(value="/edit/update",method=RequestMethod.PUT)
    public Map<String, Object> updateComment(@RequestBody Map<String, String> param,Model model){
        Map<String, Object> response = new HashMap<>();
        
        Comment comment = new Comment();
        Thread thread   = new Thread();
        String threadId = param.get("threadId");
        String commentId = param.get("commentId");
        
        comment = commentService.getCommentbyId(Integer.valueOf(commentId));
        
        thread.setThreadId(Integer.valueOf(threadId));
        comment.setCommentDescription(param.get("commentDescription"));
        comment.setCommentTitle(param.get("commentTitle"));
        comment.setThread(thread);
        comment.setUpdateUser(param.get("createUser"));
        comment.setUpdateDate(new Date());
        
        boolean update = commentService.updateComment(comment);
        if (update) {
            response.put("suceess", true);
            response.put("message", "Comment Edit");
            response.put("path", "/thread/view/"+threadId);
        }else {
            response.put("error", true);
            response.put("message", "Unable to Edit");
        }
        return response;
    }
    
    @RequestMapping(value="/edit/{commentId}_comment")
    public String editThread(@PathVariable int commentId, Model model, Principal principal){
        
        Comment comment = commentService.getCommentbyId(commentId);
        Thread thread = threadService.getThreadbyId(comment.getThread().getThreadId());
        
        List<Comment> commentList = new ArrayList<>();
        if (thread !=null) {
            commentList.addAll(thread.getComments());
        }
        if (principal != null) {
            model.addAttribute("loginUser", userService.getUserByUsername(principal.getName()));
        }
        model.addAttribute("editCommnet", comment);
        model.addAttribute("viewThread", thread);
        model.addAttribute("commentList", commentList);
        
        return "view_thread";
    }
    @RequestMapping(value="/delete/{commentId}_comment")
    public String deleteThread(@PathVariable int commentId,Model model, Principal principal){
        
        Comment comment = commentService.getCommentbyId(commentId);
        if (comment !=null) {
            commentService.deleteComment(comment);
        }
        if (principal != null) {
            model.addAttribute("loginUser", userService.getUserByUsername(principal.getName()));
        }
        return "redirect:/thread/view/"+comment.getThread().getThreadId();
    }

}
