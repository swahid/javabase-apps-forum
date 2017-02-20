/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.javabase.apps.entity.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Repository
@SuppressWarnings("unchecked")
public class TopicMapperImpl implements TopicMapper{
    
    
    @Autowired
    SessionFactory session;
    
    @Override
    public List<Topic> getAllTopic() {
        return session.getCurrentSession().createCriteria(Topic.class).list();
    }

    @Override
    public Topic getTopicById(int topicId) {
        return (Topic) session.getCurrentSession().get(Topic.class, topicId);
    }

    @Override
    public Topic getTopicByName(String topicName) {
        String hql = "From Topic where topicName = :topicName";
        
        Query query = session.getCurrentSession().createQuery(hql);
        
        query.setParameter("topicName", topicName);
        
        List<Topic> topicList = query.list();
        Topic topic = new Topic();
        
        if (topicList.size()>0) {
            topic = topicList.get(0);
        }
        return topic;
    }

    @Override
    public boolean isTopicExist(Topic topic) {
        Topic checkTopicById   = getTopicByName(topic.getTopicName());
        
        if (checkTopicById !=null) {
            return true;
        }else {
            return false;
        }
        
    }

    @Override
    public boolean addNewTopic(Topic topic) {
        try {
            String hql = "From Topic where topicName = :topicName";
            Query query = session.getCurrentSession().createQuery(hql);
            query.setParameter("topicName", topic.getTopicName());
            List<Topic> topicList = query.list();
            
            if (topicList.size()>0) {
                session.getCurrentSession().update(topic);
            }else {
                session.getCurrentSession().saveOrUpdate(topic);
            }
            
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateTopic(Topic topic) {
        try {
            session.getCurrentSession().update(topic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTopic(Topic topic) {
        try {
            session.getCurrentSession().delete(topic);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
