package com.kukushkin.booking.office.dao;

import com.kukushkin.booking.office.entity.Account;

public class AccountDaoImpl extends BaseDao<Account> implements AccountDao {


	@Override
	public void update(Account persistent) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
		getEntityManger().getTransaction().begin();
		getEntityManger().remove(getEntityManger().find(Account.class, id));
		getEntityManger().getTransaction().commit();
	}

	@Override
	public void setPermissions(int accountId, int userRole) {
		getEntityManger().find(Account.class, accountId).setUserRole(userRole);
		
	}

	@Override
	public void addAdditionalPermissions(int accountId, int permissions) {
		throw new UnsupportedOperationException("This possibility in the current version of the application is not implemented!");
	}
}
