package com.myloginapp;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
@Entity
// This annotation specifies the name of the database table this entity maps to.
// Our table is named 'users' in MySQL.
@Table (name= "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name= "username", unique = true, nullable = false)
    private String username;

    @Column(name= "password", nullable = false)
    private String password;
    
    public User(){

    }
    public User (String username, String password){
        this.username= username;
        this.password= password;
    }
    // Getters and Setters for each field.
    // These are crucial for JPA to read from and write to the database.

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id= id;
    }
    public String getUsername(){
        return username;
    }
    public void setUsername(String username){
        this.username = username;
    }
    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password= password;
    }
// Optional: Override toString() for easier debugging
    @Override
    public String toString() {
        return "User{ " +
        "id=" + id +
        " , username='"+ username +'\''+
        '}';
    }

}
