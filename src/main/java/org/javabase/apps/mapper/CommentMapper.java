/**
 * 
 */
package org.javabase.apps.mapper;

import java.util.List;

import org.javabase.apps.entity.Comment;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
public interface CommentMapper {
    
    public List<Comment> getAllComment();
    public Comment getCommentbyId(int id);
    public List<Comment> getCommentbyContentId(int contentId);
    public Boolean addComment(Comment content);
    public Boolean updateComment(Comment content);
    public Boolean deleteComment(Comment content);

}
