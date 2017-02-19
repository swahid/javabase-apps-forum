/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.hibernate.SessionFactory;
import org.javabase.apps.entity.Content;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Repository
@SuppressWarnings("unchecked")
public class ContentMapperImpl implements ContentMapper{
    
    @Autowired
    SessionFactory session;
    
    @Override
    public List<Content> getAllContent() {
        return session.getCurrentSession().createCriteria(Content.class).list();
    }

    @Override
    public Boolean addContent(Content content) {
        try {
            session.getCurrentSession().save(content);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        
    }

    @Override
    public Boolean updateContent(Content content) {
        try {
            session.getCurrentSession().update(content);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Boolean deleteContent(Content content) {
        try {
            session.getCurrentSession().delete(content);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

	@Override
	public Content getContentbyId(int id) {
		return (Content) session.getCurrentSession().get(Content.class, id);
	}

}
