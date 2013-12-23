package com.kukushkin.booking.office.dao;

import static org.junit.Assert.*;
import org.junit.AfterClass;
import org.junit.BeforeClass;
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

	@Test
	public void testSetPermissions() {
		fail("Not yet implemented");
	}

	@Test
	public void testAddAdditionalPermissions() {
		fail("Not yet implemented");
	}

	@Test
	public void testAdd() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteT() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeleteInt() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		fail("Not yet implemented");
	}

	@Test
	public void testRead() {
		fail("Not yet implemented");
	}

}
