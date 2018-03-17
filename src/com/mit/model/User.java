package com.mit.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.hibernate.validator.constraints.NotEmpty;
 
@Entity
@Table(name="login_master")
public class User implements Serializable{
 
    @Id @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer loginId;
 
    @NotEmpty
    @Column(name="userName", unique=true, nullable=false)
    private String userName;
     
    @NotEmpty
    @Column(name="password", nullable=false)
    private String password;
         
    @NotEmpty
    @Column(name="email", nullable=false)
    private String email;
 
   /* @NotEmpty
    @Column(name="LAST_NAME", nullable=false)
    private String lastName;
 
    @NotEmpty
    @Column(name="EMAIL", nullable=false)
    private String email;*/
 
   /* @NotEmpty
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "APP_USER_USER_PROFILE", 
             joinColumns = { @JoinColumn(name = "USER_ID") }, 
             inverseJoinColumns = { @JoinColumn(name = "USER_PROFILE_ID") })
    private Set<UserProfile> userProfiles = new HashSet<UserProfile>();*/
 
    
 
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
 
   
 
   /* public String getEmail() {
        return email;
    }
 
    public void setEmail(String email) {
        this.email = email;
    }*/
 
  /*  public Set<UserProfile> getUserProfiles() {
        return userProfiles;
    }
 
    public void setUserProfiles(Set<UserProfile> userProfiles) {
        this.userProfiles = userProfiles;
    }*/
 
    public Integer getLoginId() {
		return loginId;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}