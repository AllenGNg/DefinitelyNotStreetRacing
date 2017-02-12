package rithack.definitelynotstreetracing;

public class User{

    public String userName;
    
    public User(String name){
        userName = name;
    }

    public String getUserName(){
        return userName;
    }

    public void setUserName(String name){
        // Change on database the username first
        userName = name;
    }
}