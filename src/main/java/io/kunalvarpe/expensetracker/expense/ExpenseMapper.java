package io.kunalvarpe.expensetracker.expense;

import org.springframework.stereotype.Service;

/**
 * @author Kunal Varpe
 */
@Service
public class ExpenseMapper {

	public ExpenseDto toDto(Expense expense) {
		return new ExpenseDto(expense.id(),
				expense.name(),
				expense.category(),
				expense.amount(),
				expense.currency(),
				expense.createdAt(),
				expense.updatedAt());
	}

	public Expense toEntity(ExpenseDto expense, Integer userId) {
		return new Expense(expense.id(),
				expense.name(),
				expense.category(),
				expense.amount(),
				expense.currency(),
				userId,
				expense.createdAt(),
				expense.updatedAt());
	}
}
