package io.kunalvarpe.expensetracker.expense;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("expenses")
public record Expense(

		@Id
		Integer id,
		String name,
		Category category,
		Double amount,
		String currency,
		Integer userId,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
) {
}
