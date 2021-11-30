package com.sales.taxes.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class StoreTest {

	private Store store;
	
	@Before
	public void setUp() {
		store = new Store();
	}

	@Test
	public void searchExistingItem() {
		String name = new String("book");
		String expectedName = new String("books");
		String result = store.searchItem(name);
		Assert.assertEquals(expectedName, result);
	}
	
	@Test
	public void searchNonExistingItem() {
		String name = new String("test");
		String result = store.searchItem(name);
		Assert.assertEquals(null, result);
	}
	
    @After
    public void teardown() {
    	store = null;
    }
}
