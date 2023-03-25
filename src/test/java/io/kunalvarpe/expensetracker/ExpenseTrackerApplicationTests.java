package io.kunalvarpe.expensetracker;

import io.kunalvarpe.expensetracker.expense.ExpenseRepository;
import org.junit.jupiter.api.Test;
import org.testcontainers.junit.jupiter.Testcontainers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@Testcontainers
@SpringBootTest
@ActiveProfiles("test")
class ExpenseTrackerApplicationTests {

	@Autowired
	private ExpenseRepository expenseRepository;

	@Test
	void testFindAll() {
		expenseRepository.findAll();
	}

}
