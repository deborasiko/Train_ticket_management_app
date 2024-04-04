package mvc.models;

public class Admin {
    private String username = "admin";
    private String password = "1234trains";

    /*protected Admin(String uname, String pssw){
        this.username = uname;
        this.password = pssw;
    }*/

    public String getUname(){
        return this.username;
    }
    public String getPassW(){
        return this.password;
    }
}
