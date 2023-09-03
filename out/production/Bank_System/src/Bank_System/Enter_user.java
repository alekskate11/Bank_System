package Bank_System;

public class Enter_user {

    private int id;
    private String login;
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
    public int getId() {
        return id;
    }
    public  static int  IdGenerator() {
        int id_new=(int)(1+Math.random()*100000);
        return id_new;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Enter_user() {
    }

    public Enter_user(int id, String login) {
        this.id = id;
        this.login = login;
    }

    @Override
    public String toString() {
        return
                " Your user id : " + id +
                ", login : '" + login;
    }
}
