package io.kunalvarpe.expensetracker.expense;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;

/**
 * @author Kunal Varpe
 */
public record ExpenseDto(
		@Id
		Integer id,
		String name,
		Category category,
		Double amount,
		String currency,
		LocalDateTime createdAt,
		LocalDateTime updatedAt
) {
}