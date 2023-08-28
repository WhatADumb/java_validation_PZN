package self.java.validation.data;

public enum Level {
    STANDARD("You're at Standard version"), PREMIUM("You're at Premium version"), VIP("You're at VIP version");

    private String desc;

    //In ENUM Constructor don't add modifier
    Level(String desc){
        this.desc = desc;
    }

    public String getDesc(){
        return this.desc;
    }
}
