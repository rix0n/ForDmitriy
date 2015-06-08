package DAO.Entity;

/**
 * Created by 1 on 02.06.2015.
 */
public class User extends ABaseEntity {

    private String name = null;
    private String email = null;
    /*private int id;*/

    public User(){}

    public User(String email, String name){
        this.email = email;
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

}
