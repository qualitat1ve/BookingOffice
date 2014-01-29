import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class UserBean implements Serializable{
    private String user;
    private String password;
    private String text;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }


    public String getPassword() {
        return password;
    }


    public void setPassword(String password) {
        this.password = password;
    }


    public String checkUser(){
        if(user.equals("officer") && this.password.equals("officer")){
            return "officer.xhtml";
        } else if (user.equals("accountant") && this.password.equals("accountant")){
            return "accountant.xhtml";
        } else if (user.equals("analyst") && this.password.equals("analyst")) {
            return "analyst.xhtml";
        } else if (user.equals("administrator") && this.password.equals("administrator")) {
            return "administrator.xhtml";
        } else return "loginFailed.xhtml";
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}