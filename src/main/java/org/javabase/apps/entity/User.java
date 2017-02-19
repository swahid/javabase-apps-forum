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
@Table(name = "user")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = -1352472763010869081L;

    private Integer     userId;
    private Boolean     accountActive;
    private Date        expireDate;
    private String      firstName;
    private String      lastName;
    private Boolean     nonExpired;
    private Boolean     nonLocked;
    private String      password;
    private Date        registrationDate;
    private String      userEmail;
    private String      userImage;
    private String      userPhone;
    private String      username;
    private Set<Thread> threads = new HashSet<Thread>(0);

    @Id
    @GeneratedValue(strategy = IDENTITY)

    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "account_active")
    public Boolean getAccountActive() {
        return this.accountActive;
    }

    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "expire_date", length = 19)
    public Date getExpireDate() {
        return this.expireDate;
    }

    public void setExpireDate(Date expireDate) {
        this.expireDate = expireDate;
    }

    @Column(name = "first_name", length = 45)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "last_name", length = 45)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "non_expired")
    public Boolean getNonExpired() {
        return this.nonExpired;
    }

    public void setNonExpired(Boolean nonExpired) {
        this.nonExpired = nonExpired;
    }

    @Column(name = "non_locked")
    public Boolean getNonLocked() {
        return this.nonLocked;
    }

    public void setNonLocked(Boolean nonLocked) {
        this.nonLocked = nonLocked;
    }

    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", length = 19)
    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "user_email", length = 45)
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    @Column(name = "user_image", length = 45)
    public String getUserImage() {
        return this.userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    @Column(name = "user_phone", length = 45)
    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "user")
    public Set<Thread> getThreads() {
        return this.threads;
    }

    public void setThreads(Set<Thread> threads) {
        this.threads = threads;
    }

}
