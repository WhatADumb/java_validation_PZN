package self.java.validation.data;

public record LoginRequest(String username, String password) {

    public LoginRequest{
        //do something
    }

    //Constructor Overloading
    public LoginRequest(){
        this("", "");
    }
    public LoginRequest(String username){
        this(username, "");
    }
}
