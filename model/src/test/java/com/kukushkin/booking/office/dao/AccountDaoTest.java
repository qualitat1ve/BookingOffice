package com.kukushkin.booking.office.dao;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class AccountDaoTest extends BaseTest {
	private static AccountDaoImpl accountDaoImpl;
	
	@BeforeClass
	public static void setUpBeforeClass() {
		accountDaoImpl = new AccountDaoImpl();
	}
	
	@AfterClass
	public static void tearDownClass() {
		accountDaoImpl = null;
	}

    @Ignore
	@Test
	public void testSetPermissions() {
	}

    @Ignore
	@Test
	public void testAddAdditionalPermissions() {
	}

    @Ignore
	@Test
	public void testAdd() {
	}

    @Ignore
	@Test
	public void testDelete() {
	}

    @Ignore
	@Test
	public void testUpdate() {
	}

    @Ignore
	@Test
	public void testRead() {
	}

}
