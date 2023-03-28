package com.example.projekt;

import jakarta.persistence.*;

@Entity
public class Colors {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private String name;
    private Integer red;
    private Integer green;
    private Integer blue;
    @ManyToOne
    private UserAccount userAccount;

    public Colors() {
    }

    public Colors(Long id, String name, Integer red, Integer green, Integer blue, UserAccount userAccount) {
        Id = id;
        this.name = name;
        this.red = red;
        this.green = green;
        this.blue = blue;
        this.userAccount = userAccount;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRed() {
        return red;
    }

    public void setRed(Integer red) {
        this.red = red;
    }

    public Integer getGreen() {
        return green;
    }

    public void setGreen(Integer green) {
        this.green = green;
    }

    public Integer getBlue() {
        return blue;
    }

    public void setBlue(Integer blue) {
        this.blue = blue;
    }

    public UserAccount getUser() {
        return userAccount;
    }

    public void setUser(UserAccount userAccount) {
        this.userAccount = userAccount;
    }
}
