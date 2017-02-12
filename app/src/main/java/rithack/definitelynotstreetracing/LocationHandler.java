package rithack.definitelynotstreetracing;

public class LocationHandler{

    public String usersName;
    private APIActivity apiGetter;

    public LocationHandler(String name){
        usersName = name;
        start();
    }

    private void start(){
        apiGetter = new APIActivity();
    }

    public String getUser(){
        return usersName;
    }

    /*public float getLocation(){
        // Using Google Location API get location of user
        return ;

    }*/

}