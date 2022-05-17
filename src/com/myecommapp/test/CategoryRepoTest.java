package com.myecommapp.test;

import static org.junit.Assert.assertEquals;
import org.junit.Ignore;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.myecommapp.model.Category;
import com.myecommapp.repository.CategoryRepository;

class CategoryRepoTest {
	CategoryRepository categoryRepo;
	Category cat;

	@BeforeEach
	void setUp()  {
		categoryRepo = new CategoryRepository();
		cat = new Category();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	//@Ignore
	@Test
	void testAdd() {
		cat.setCategoryName("Test CASE!");
		assertEquals("Failed to add Category !", true, categoryRepo.add(cat));
	}
	@Ignore
	@Test
	void testDelete() {
		cat.setCategoryId("CAT0000034");
		assertEquals("Failed to DELETE Category!", true, categoryRepo.delete(cat));
	}
	@Ignore
	@Test
	void testUpdate() {
		cat.setCategoryName("TEST CASE UPDATED !");
		cat.setCategoryId("CAT0000042");
		assertEquals("Failed to UPDATE Category", true, categoryRepo.update(cat));
	}

}
