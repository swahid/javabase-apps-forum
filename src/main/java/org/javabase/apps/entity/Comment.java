package org.javabase.apps.entity;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "comment", catalog = "jforum")
public class Comment implements java.io.Serializable {

    private static final long serialVersionUID = -7584024206750023448L;
    private Integer commentId;
    private String commentTitle;
    private String commentDescription;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private String commentFlag;
    private Integer contentId;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "comment_id", unique = true, nullable = false)
    public Integer getCommentId() {
        return this.commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    @Column(name = "comment_title", nullable = false, length = 100)
    public String getCommentTitle() {
        return this.commentTitle;
    }

    public void setCommentTitle(String commentTitle) {
        this.commentTitle = commentTitle;
    }

    @Column(name = "comment_description", nullable = false, length = 300)
    public String getCommentDescription() {
        return this.commentDescription;
    }

    public void setCommentDescription(String commentDescription) {
        this.commentDescription = commentDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_user", length = 30)
    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", length = 19)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "update_user", length = 45)
    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @Column(name = "comment_flag", length = 10)
    public String getCommentFlag() {
        return this.commentFlag;
    }

    public void setCommentFlag(String commentFlag) {
        this.commentFlag = commentFlag;
    }

    @Column(name = "content_id", unique = true, nullable = false)
	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

}
