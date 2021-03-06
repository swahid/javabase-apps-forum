package org.javabase.apps.entity;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
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
@Table(name = "topic")
public class Topic implements java.io.Serializable {

    private static final long serialVersionUID = -1024616343156079501L;

    private Integer     topicId;
    private Date        createDate;
    private String      createUser;
    private String      topicDescription;
    private String      topicFlag;
    private String      topicImage;
    private String      topicName;
    private Date        updateDate;
    private String      updateUser;
    private Set<Thread> threads = new HashSet<Thread>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "topic_id", unique = true, nullable = false)
    public Integer getTopicId() {
        return this.topicId;
    }

    public void setTopicId(Integer topicId) {
        this.topicId = topicId;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", length = 19)
    public Date getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @Column(name = "create_user", length = 50)
    public String getCreateUser() {
        return this.createUser;
    }

    public void setCreateUser(String createUser) {
        this.createUser = createUser;
    }

    @Column(name = "topic_description")
    public String getTopicDescription() {
        return this.topicDescription;
    }

    public void setTopicDescription(String topicDescription) {
        this.topicDescription = topicDescription;
    }

    @Column(name = "topic_flag", length = 10)
    public String getTopicFlag() {
        return this.topicFlag;
    }

    public void setTopicFlag(String topicFlag) {
        this.topicFlag = topicFlag;
    }

    @Column(name = "topic_image", length = 50)
    public String getTopicImage() {
        return this.topicImage;
    }

    public void setTopicImage(String topicImage) {
        this.topicImage = topicImage;
    }

    @Column(name = "topic_name", nullable = false, length = 50)
    public String getTopicName() {
        return this.topicName;
    }

    public void setTopicName(String topicName) {
        this.topicName = topicName;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "update_date", length = 19)
    public Date getUpdateDate() {
        return this.updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    @Column(name = "update_user", length = 50)
    public String getUpdateUser() {
        return this.updateUser;
    }

    public void setUpdateUser(String updateUser) {
        this.updateUser = updateUser;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "topic")
    public Set<Thread> getThreads() {
        return this.threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

}
