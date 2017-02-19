package org.javabase.apps.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Entity
@Table(name = "content", catalog = "jforum")
public class Content implements java.io.Serializable {

    private static final long serialVersionUID = -501261577145670547L;
    private Integer contentId;
    private String contentTitle;
    private String contentDescription;
    private Date createDate;
    private String createUser;
    private Date updateDate;
    private String updateUser;
    private int topicId;
    private String contentFlag;
    private String contentImage;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "content_id", unique = true, nullable = false)
    public Integer getContentId() {
        return this.contentId;
    }

    public void setContentId(Integer contentId) {
        this.contentId = contentId;
    }

    @Column(name = "content_title", nullable = false, length = 100)
    public String getContentTitle() {
        return this.contentTitle;
    }

    public void setContentTitle(String contentTitle) {
        this.contentTitle = contentTitle;
    }

    @Column(name = "content_description", nullable = false, length = 500)
    public String getContentDescription() {
        return this.contentDescription;
    }

    public void setContentDescription(String contentDescription) {
        this.contentDescription = contentDescription;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_user", length = 45)
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

    @Column(name = "topic_id", nullable = false)
    public int getTopicId() {
        return this.topicId;
    }

    public void setTopicId(int topicId) {
        this.topicId = topicId;
    }

    @Column(name = "content_flag", length = 10)
    public String getContentFlag() {
        return this.contentFlag;
    }

    public void setContentFlag(String contentFlag) {
        this.contentFlag = contentFlag;
    }

    @Column(name = "content_image", length = 50)
    public String getContentImage() {
        return this.contentImage;
    }

    public void setContentImage(String contentImage) {
        this.contentImage = contentImage;
    }

}
