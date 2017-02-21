/**
 * 
 */
package org.javabase.apps.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
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
    
    @RequestMapping(value="view/{contentId}",method=RequestMethod.GET)
    public String loadThread(@PathVariable int contentId, Model model){
        
        Thread thread = threadService.getThreadbyId(contentId);
        
        List<Comment> commentList = new ArrayList<>();
        if (thread !=null) {
            commentList.addAll(thread.getComments());
        }
        
        model.addAttribute("viewThread", thread);
        model.addAttribute("commentList", commentList);
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
                response.put("error", true);
                response.put("message", "Thread Create");
            }
        } catch (Exception e) {
            response.put("error", true);
            response.put("message", "unable to save");
            e.printStackTrace();
        }
        return response;
    }
    @ResponseBody
    @RequestMapping(value="edit/update",method=RequestMethod.PUT)
    public Map<String, Object> editThread(@RequestBody Map<String, String> entity){
        Map<String, Object> response = new HashMap<>();
        
        try {
            User user        = new User();
            Topic topic      = new Topic();
            Thread thread    = new Thread();
            
            String threadId       = entity.get("threadId");
            String userId         = entity.get("userId");
            String updateUser     = entity.get("updateUser");
            String threadTitle    = entity.get("threadTitle");
            String topicId        = entity.get("topicId");
            String threadDescription = entity.get("threadDescription");
            
            user.setUserId(Integer.valueOf(userId));
            topic.setTopicId(Integer.valueOf(topicId));
            
            thread = threadService.getThreadbyId(Integer.valueOf(threadId));
            
//            thread.setUser(user);
//            thread.setTopic(topic);
            thread.setThreadTitle(threadTitle);
            thread.setUpdateUser(updateUser);
            thread.setUpdateDate(new Date());
            thread.setThreadDescription(threadDescription);
            
            boolean save = threadService.updateThread(thread);
            if (save) {
                response.put("success", true);
                response.put("message", "Thread Update");
                response.put("path", "all_thread");
            }else {
                response.put("error", true);
                response.put("message", "unable to update");
            }
        } catch (Exception e) {
            response.put("error", true);
            response.put("message", "unable to update");
            e.printStackTrace();
        }
        return response;
    }
    
    @RequestMapping(value="/edit/{threadId}_thread")
    public String editThread(@PathVariable int threadId, Model model){
        
        Thread thread = threadService.getThreadbyId(threadId);
        
        model.addAttribute("editThread",thread);
        
        return "create_thread";
    }
    @RequestMapping(value="/delete/{threadId}_thread")
    public String deleteThread(@PathVariable int threadId){
        
        Thread thread = threadService.getThreadbyId(threadId);
        if (thread !=null) {
            threadService.deleteThread(thread);
        }
        return "redirect:/threads";
    }

    @RequestMapping(value="all_thread",method=RequestMethod.GET)
    public String threadCreateRedirect(){
        return "redirect:/threads";
    }
    
    @RequestMapping(value="edit/all_thread",method=RequestMethod.GET)
    public String threadEditRedirect(){
        
        return "redirect:/threads";
    }
}
