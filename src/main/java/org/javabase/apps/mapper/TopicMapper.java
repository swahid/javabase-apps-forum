/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.javabase.apps.entity.Topic;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
public interface TopicMapper {
    
    public List<Topic> getAllTopic();
    public Topic getTopicById(int topicId);
    public Topic getTopicByName(String topicName);
    public boolean isTopicExist(Topic topic);
    public boolean addNewTopic(Topic topic);
    public boolean updateTopic(Topic topic);
    public boolean deleteTopic(Topic topic);
    

}
