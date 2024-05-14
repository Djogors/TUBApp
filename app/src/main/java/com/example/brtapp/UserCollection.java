package com.example.brtapp;

import java.util.ArrayList;
import java.util.Collection;

public class UserCollection {

    private Collection<User> list;
    private static UserCollection instance;

    //Private constructor para prevenir ser instanciado fora
    private UserCollection() {
        list=new ArrayList<>();
    }

    //Metodo estatico para apenas existir uma instancia do objeto
    public  static UserCollection getInstance(){
        if(instance == null){
            instance = new UserCollection();
        }
        return instance;
    }

    public void insert(User user){list.add(user);}

    public void remove(User user){list.remove(user);}

    public User finduser(String email){
        for(User u : list){
            if(email != null && email.equals(u.getEmail())){
                return u;
            }
        }
        return null;
    }
}
