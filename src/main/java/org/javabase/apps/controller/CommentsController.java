/**
 * 
 */
package org.javabase.apps.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javabase.apps.entity.Comment;
import org.javabase.apps.entity.Thread;
import org.javabase.apps.entity.User;
import org.javabase.apps.service.CommentService;
import org.javabase.apps.service.ThreadService;
import org.javabase.apps.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
    public Map<String, Object> addComment(@RequestBody Map<String, String> param){
        Map<String, Object> response = new HashMap<>();
        
        Comment comment = new Comment();
        Thread thread   = new Thread();
        User user       = new User();
        
        String threadId = param.get("threadId");
        thread.setThreadId(Integer.valueOf(threadId));
        user.setUsername(param.get("username"));
        user.setPassword(param.get("password"));
        user.setFirstName(param.get("firstName"));
        user.setFirstName(param.get("lastName"));
        
        boolean addUser = userService.addUser(user);
        if (!addUser) {
            response.put("error", true);
            response.put("message", "user not create");
            return response;
        }
        
        comment.setCommentDescription(param.get("commentDescription"));
        comment.setCommentTitle(param.get("commentTitle"));
        comment.setCreateUser(param.get("createUser"));
        comment.setThread(thread);
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

}
