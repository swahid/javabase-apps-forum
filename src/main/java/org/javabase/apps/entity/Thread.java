package org.javabase.apps.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author      Saurav Wahid<saurav1161@gmail.com>
 * @version     1.0.0
 * @since       1.0.0
 */
@Entity
@Table(name = "thread")
public class Thread implements java.io.Serializable {

    private static final long serialVersionUID = 3494183225956885799L;

    private Integer      threadId;
    private Topic        topic;
    private User         user;
    private String       threadDescription;
    private String       threadFlag;
    private String       threadImage;
    private String       threadTitle;
    private Date         createDate;
    private String       createUser;
    private Date         updateDate;
    private String       updateUser;
    private Set<Comment> comments = new HashSet<Comment>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "thread_id", unique = true, nullable = false)
    public Integer getThreadId() {
        return this.threadId;
    }

    public void setThreadId(Integer threadId) {
        this.threadId = threadId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "topic_id", nullable = false)
    public Topic getTopic() {
        return this.topic;
    }

    public void setTopic(Topic topic) {
        this.topic = topic;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Column(name = "thread_description", nullable = false, length = 500)
    public String getThreadDescription() {
        return this.threadDescription;
    }

    public void setThreadDescription(String threadDescription) {
        this.threadDescription = threadDescription;
    }

    @Column(name = "thread_flag", length = 10)
    public String getThreadFlag() {
        return this.threadFlag;
    }

    public void setThreadFlag(String threadFlag) {
        this.threadFlag = threadFlag;
    }

    @Column(name = "thread_image", length = 50)
    public String getThreadImage() {
        return this.threadImage;
    }

    public void setThreadImage(String threadImage) {
        this.threadImage = threadImage;
    }

    @Column(name = "thread_title", length = 100)
    public String getThreadTitle() {
        return this.threadTitle;
    }

    public void setThreadTitle(String threadTitle) {
        this.threadTitle = threadTitle;
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "thread")
    public Set<Comment> getComments() {
        return this.comments;
    }

    public void setComments(Set<Comment> comments) {
        this.comments = comments;
    }

}
