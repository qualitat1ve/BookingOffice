import com.kukushkin.booking.office.entity.Account;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class AccountsBean {
    private List<Account> accountList = new ArrayList<Account>();
    private Account selectedAccount = new Account();
    private String[] loginSet = {
            "administrator",         //1
            "accountant",            //2
            "analyst",               //3
            "security officer"       //4
    };


    public AccountsBean() {
        createTestAccounts();
    }

    private void createTestAccounts() {
        Account account = new Account();
        account.setLogin("administrator");
        account.setPassword("administrator");
        account.setUserName("Vasiliy");
        account.setUserMiddleName("Nikiforovich");
        account.setUserSurname("Ustinov");
        account.setUserRole(1);
        accountList.add(account);
        Account account1 = new Account();
        account1.setLogin("analyst");
        account1.setPassword("analyst");
        account1.setUserName("Romuald");
        account1.setUserMiddleName("Bronislavovich");
        account1.setUserSurname("Medvedev");
        account1.setUserRole(2);
        accountList.add(account1);
        Account account2 = new Account();
        account2.setLogin("accountant");
        account2.setPassword("accountant");
        account2.setUserName("Petr");
        account2.setUserMiddleName("Ivanovich");
        account2.setUserSurname("Pupkin");
        account2.setUserRole(3);
        accountList.add(account2);
    }

    public String reInit() {
        selectedAccount = new Account();
        return null;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    public void setAccountList(List<Account> accountList) {
        this.accountList = accountList;
    }

    public Account getSelectedAccount() {
        return selectedAccount;
    }

    public void setSelectedAccount(Account selectedAccount) {
        this.selectedAccount = selectedAccount;
    }

    public String[] getLoginSet() {
        return loginSet;
    }

    public void setLoginSet(String[] loginSet) {
        this.loginSet = loginSet;
    }
}

