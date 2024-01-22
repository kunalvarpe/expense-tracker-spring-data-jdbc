package io.kunalvarpe.expensetracker;

import java.util.stream.IntStream;

import io.kunalvarpe.expensetracker.expense.Category;
import io.kunalvarpe.expensetracker.expense.Expense;
import io.kunalvarpe.expensetracker.expense.ExpenseRepository;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ExpenseTrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseTrackerApplication.class, args);
	}

	@Bean
	public ApplicationRunner runner(ExpenseRepository expenseRepository) {
		var values = Category.values();
		var length = values.length;
		int batch = 5000;
		return args -> {
			int start = 1;
			int end = batch;
			for (int j = 1; j <= 100; j++) {
				var expenses = IntStream.range(start, end)
						.mapToObj(i -> new Expense("Expense" + i + 1, values[i % length], i * 2.5, "INR", 1))
						.toList();
				expenseRepository.saveAll(expenses);
				System.out.println(start + " " + end);
				start = end;
				end += batch;
			}

		};
	}
}
