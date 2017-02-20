/**
 * 
 */
package org.javabase.apps.service;

import java.util.List;

import org.javabase.apps.entity.Topic;
import org.javabase.apps.mapper.TopicMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Service
public class TopicServiceImpl implements TopicService{
    
    @Autowired
    TopicMapper topicMapper;

    @Override
    @Transactional(readOnly=true)
    public List<Topic> getAllTopic() {
        return topicMapper.getAllTopic();
    }

    @Override
    @Transactional(readOnly=true)
    public Topic getTopicById(int topicId) {
        return topicMapper.getTopicById(topicId);
    }

    @Override
    @Transactional(readOnly=true)
    public Topic getTopicByName(String topicName) {
        return topicMapper.getTopicByName(topicName);
    }

    @Override
    @Transactional(readOnly=true)
    public boolean isTopicExist(Topic topic) {
        return topicMapper.isTopicExist(topic);
    }

    @Override
    @Transactional
    public boolean addNewTopic(Topic topic) {
        return topicMapper.addNewTopic(topic);
    }

    @Override
    @Transactional
    public boolean updateTopic(Topic topic) {
        return topicMapper.updateTopic(topic);
    }

    @Override
    @Transactional
    public boolean deleteTopic(Topic topic) {
        return topicMapper.deleteTopic(topic);
    }

}
