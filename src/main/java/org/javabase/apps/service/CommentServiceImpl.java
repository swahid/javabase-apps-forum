/**
 * 
 */
package org.javabase.apps.service;

import java.util.List;

import org.javabase.apps.entity.Comment;
import org.javabase.apps.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Service
public class CommentServiceImpl implements CommentService{
    
    @Autowired
    CommentMapper commentMapper;

    @Override
    @Transactional(readOnly=true)
    public List<Comment> getAllComment() {
        return commentMapper.getAllComment();
    }

    @Override
    @Transactional(readOnly=true)
    public Comment getCommentbyId(int id) {
        return commentMapper.getCommentbyId(id);
    }

    @Override
    @Transactional
    public Boolean addComment(Comment content) {
        return commentMapper.addComment(content);
    }

    @Override
    @Transactional
    public Boolean updateComment(Comment content) {
        return commentMapper.updateComment(content);
    }

    @Override
    @Transactional
    public Boolean deleteComment(Comment content) {
        return commentMapper.deleteComment(content);
    }

    @Override
    @Transactional(readOnly=true)
    public List<Comment> getCommentbyContentId(int contentId) {
        return commentMapper.getCommentbyContentId(contentId);
    }

}
