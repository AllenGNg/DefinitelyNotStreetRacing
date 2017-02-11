
public class LocationHandler{

    String usersName;

    public LocationHandler(String name){
        usersName = name;
    }

    public String getUser(){
        return usersName;
    }

    public float getLocation(){
        // Using Google Location API get location of user
        return null;

    }

}