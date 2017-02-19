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
@Table(name = "user", catalog = "jforum")
public class User implements java.io.Serializable {

    private static final long serialVersionUID = -3924336603223211546L;
    private Integer userId;
    private String userEmail;
    private Date expireDate;
    private String firstName;
    private Boolean accountActive;
    private Boolean nonExpired;
    private Boolean nonLocked;
    private String lastName;
    private String password;
    private String userPhone;
    private Date registrationDate;
    private String username;
    private String userImage;

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "user_id", unique = true, nullable = false)
    public Integer getUserId() {
        return this.userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Column(name = "user_email", length = 45)
    public String getUserEmail() {
        return this.userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
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

    @Column(name = "account_active")
    public Boolean getAccountActive() {
        return this.accountActive;
    }

    public void setAccountActive(Boolean accountActive) {
        this.accountActive = accountActive;
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

    @Column(name = "last_name", length = 45)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "password", nullable = false, length = 200)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "user_phone", length = 45)
    public String getUserPhone() {
        return this.userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "registration_date", length = 19)
    public Date getRegistrationDate() {
        return this.registrationDate;
    }

    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    @Column(name = "username", nullable = false, length = 30)
    public String getUsername() {
        return this.username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Column(name = "user_image", length = 45)
    public String getUserImage() {
        return this.userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

}

