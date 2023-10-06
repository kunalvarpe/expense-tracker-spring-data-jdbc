package io.kunalvarpe.expensetracker;

import java.util.List;

import io.kunalvarpe.expensetracker.expense.Category;
import io.kunalvarpe.expensetracker.expense.Expense;
import io.kunalvarpe.expensetracker.expense.ExpenseRepository;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ExpenseTrackerApplicationTests {

	@LocalServerPort
	private Integer port;

	@Container
	static PostgreSQLContainer<?> postgreSQLContainer =
			new PostgreSQLContainer<>(DockerImageName.parse("postgres:14-alpine"));

	@BeforeAll
	static void beforeAll() {
		postgreSQLContainer.start();
	}

	@AfterAll
	static void afterAll() {
		postgreSQLContainer.stop();
	}

	@DynamicPropertySource
	static void configureProperties(DynamicPropertyRegistry dynamicPropertyRegistry) {
		dynamicPropertyRegistry.add("spring.datasource.url", postgreSQLContainer::getJdbcUrl);
		dynamicPropertyRegistry.add("spring.datasource.username", postgreSQLContainer::getUsername);
		dynamicPropertyRegistry.add("spring.datasource.password", postgreSQLContainer::getPassword);
	}

	@Autowired
	ExpenseRepository expenseRepository;

	@BeforeEach
	void setUp() {
		expenseRepository.deleteAll();
	}

	@Test
	void shouldGetAllExpenses() {
		var expenses = List.of(
				new Expense("diwali-shopping", Category.SHOPPING, 499.00, "INR", 1),
				new Expense("lunch-at-ab-bbq", Category.FOOD, 1899.00, "INR", 1),
				new Expense("shoose", Category.SHOPPING, 799.00, "INR", 1)
		);
		expenseRepository.saveAll(expenses);

		var expensesList = expenseRepository.findByUserId(1);
		assertThat(expensesList)
				.isNotEmpty()
				.hasSize(3);
	}

}
