package model.users;

import model.Wallet;

/**
 * Arne Cools
 * 27/10/2021
 */
public class User extends Visitor{
    private Wallet wallet;
    private String addres;

    public User(String addres){
        wallet = new Wallet();
        this.addres = addres;
    }
}
