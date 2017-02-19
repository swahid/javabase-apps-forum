/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.hibernate.SessionFactory;
import org.javabase.apps.entity.Comment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author medisys
 *
 */
@Repository
@SuppressWarnings("unchecked")
public class CommentMapperImpl implements CommentMapper{
	
	@Autowired
	SessionFactory session;

	@Override
	public List<Comment> getAllComment() {
		return session.getCurrentSession().createCriteria(Comment.class).list();
	}

	@Override
	public Comment getCommentbyId(int id) {
		return (Comment) session.getCurrentSession().get(Comment.class, id);
	}

	@Override
	public Boolean addComment(Comment content) {
		try {
			session.getCurrentSession().save(content);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean updateComment(Comment content) {
		try {
			session.getCurrentSession().update(content);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Boolean deleteComment(Comment content) {
		try {
			session.getCurrentSession().delete(content);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public List<Comment> getCommentbyContentId(int contentId) {
		String hql = "from Comment where contentId="+contentId;
		return session.getCurrentSession().createQuery(hql).list();
	}

}
