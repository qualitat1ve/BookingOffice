import org.primefaces.context.RequestContext;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class DialogBean implements Serializable{
    public void loginDialog() {
        RequestContext.getCurrentInstance().openDialog("loginDialog");
    }
}
