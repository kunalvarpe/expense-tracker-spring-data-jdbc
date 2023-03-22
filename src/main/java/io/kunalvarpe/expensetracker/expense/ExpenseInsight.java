package io.kunalvarpe.expensetracker.expense;

public record ExpenseInsight(
		Double totalExpense,
		Double currentExpense,
		String mostExpenseCategory,
		Double mostExpenseCategoryValue,
		String leastExpenseCategory,
		Double leastExpenseCategoryValue
) {
}
