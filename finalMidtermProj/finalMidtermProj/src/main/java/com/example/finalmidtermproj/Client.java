package com.example.finalmidtermproj;

public class Client {
    String cUserName ;
    String cPassWord ;

    public Client(String cUserName, String cPassWord) {
        this.cUserName = cUserName;
        this.cPassWord = cPassWord;
    }

    public String getcUserName() {
        return cUserName;
    }

    public void setcUserName(String cUserName) {
        this.cUserName = cUserName;
    }

    public String getcPassWord() {
        return cPassWord;
    }

    public void setcPassWord(String cPassWord) {
        this.cPassWord = cPassWord;
    }
}
