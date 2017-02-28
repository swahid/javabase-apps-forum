/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.javabase.apps.entity.Thread;
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
public class ThreadMapperImpl implements ThreadMapper{
    
    @Autowired
    SessionFactory session;
    
    @Override
    public List<Thread> getAllThread() {
        return session.getCurrentSession().createCriteria(Thread.class).list();
    }

    @Override
    public Boolean addThread(Thread Thread) {
        try {
            session.getCurrentSession().save(Thread);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public Boolean updateThread(Thread thread) {
        try {
            session.getCurrentSession().update(thread);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteThread(Thread Thread) {
        try {
            session.getCurrentSession().delete(Thread);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    @Override
    public Thread getThreadbyId(int id) {
        return (Thread) session.getCurrentSession().get(Thread.class, id);
    }
    
    @Override
    public List<Thread> searchThreadByParam(String searchBy, String searchParam) {
        List<Thread> threadList = new ArrayList<>();
        if (searchBy.equalsIgnoreCase("searchBy") || StringUtils.isEmpty(searchParam)) {
            
        }else {
            if (searchBy.equalsIgnoreCase("threadDescription") || searchBy.equalsIgnoreCase("threadTitle") || searchBy.equalsIgnoreCase("createUser")) {
                String hql = "FROM Thread t WHERE t."+searchBy+" Like :searchParam";
                Query query = session.getCurrentSession().createQuery(hql);
                threadList =query.setParameter("searchParam", searchParam+ "%").list();
            }
            
        }
        
        
        return threadList;
    }


}
