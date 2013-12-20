package com.kukushkin.booking.office.dao;

import com.kukushkin.booking.office.entity.Account;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {

    @Override
    protected Class<Account> getType() {
        return Account.class;
    }

    @Override
	public void setPermissions(int accountId, int userRole) {
        getEntityManger().getTransaction().begin();
		getEntityManger().find(Account.class, accountId).setUserRole(userRole);
        getEntityManger().getTransaction().commit();
		
	}

	@Override
	public void addAdditionalPermissions(int accountId, int permissions) {
		throw new UnsupportedOperationException("This possibility in the current version of the application is not implemented!");
	}
}
