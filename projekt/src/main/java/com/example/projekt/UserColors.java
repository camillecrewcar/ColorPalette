package com.example.projekt;

import java.util.ArrayList;

public class UserColors {
    public ArrayList<ColorRGB> userColors;
    public UserAccount currentUser;
    private static UserColors instance = null;
    private void UserColors(){

    }
    public static UserColors getInstance(){
        if(instance==null){
            instance = new UserColors();
        }
        return instance;
    }
}
