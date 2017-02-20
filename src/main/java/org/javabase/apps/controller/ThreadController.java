/**
 * 
 */
package org.javabase.apps.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.javabase.apps.entity.Comment;
import org.javabase.apps.entity.Thread;
import org.javabase.apps.entity.Topic;
import org.javabase.apps.entity.User;
import org.javabase.apps.service.CommentService;
import org.javabase.apps.service.ThreadService;
import org.javabase.apps.service.TopicService;
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
    
    @Autowired
    TopicService topicService;
    
    @RequestMapping(value="new",method=RequestMethod.GET)
    public String thread(){
        return "create_thread";
    }
    @RequestMapping(value="all_thread",method=RequestMethod.GET)
    public String threadList(){
        
        return "redirect:/";
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
    public Map<String, Object> newThread(@RequestBody Map<String, String> entity){
        Map<String, Object> response = new HashMap<>();
        
        try {
            User user        = new User();
            Topic topic      = new Topic();
            Thread thread    = new Thread();
            
            String userId         = entity.get("userId");
            String createUser     = entity.get("createUser");
            String threadTitle    = entity.get("threadTitle");
            String topicName      = entity.get("topicName");
            String threadDescription = entity.get("threadDescription");
            
            user.setUserId(Integer.valueOf(userId));
            
            topic.setTopicName(topicName);
            topic.setCreateDate(new Date());
            topic.setCreateUser(createUser);
            topicService.addNewTopic(topic);
            topic = topicService.getTopicByName(topicName);
            
            thread.setUser(user);
            thread.setTopic(topic);
            thread.setThreadTitle(threadTitle);
            thread.setCreateUser(createUser);
            thread.setCreateDate(new Date());
            thread.setThreadDescription(threadDescription);
            
             boolean save = threadService.addThread(thread);
            if (save) {
                response.put("success", true);
                response.put("message", "Thread Create");
                response.put("path", "all_thread");
            }else {
                response.put("message", "Thread Create");
            }
        } catch (Exception e) {
            response.put("message", "unable to save");
            e.printStackTrace();
        }
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
