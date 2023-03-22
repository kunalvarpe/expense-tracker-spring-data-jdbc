package io.kunalvarpe.expensetracker.expense;

import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;
import java.util.Comparator;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ExpenseService {

	private final ExpenseRepository expenseRepository;

	public ExpenseService(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	public ExpenseInsight expenseInsight(Integer userId) {
		Collection<Expense> expenses = expenseRepository.findByUserId(userId);
		Month currentMonth = LocalDate.now().getMonth();

		Optional<Double> totalExpense = expenses.stream().map(Expense::amount).reduce(Double::sum);
		Optional<Double> currentExpense = expenses.stream()
				.filter(expense -> currentMonth == expense.createdAt().getMonth())
				.map(Expense::amount)
				.reduce(Double::sum);
		Optional<Expense> maxExpense = expenses.stream().max(Comparator.comparing(Expense::amount));
		Optional<Expense> minExpense = expenses.stream().min(Comparator.comparing(Expense::amount));

		return new ExpenseInsight(
				totalExpense.orElse(0.0),
				currentExpense.orElse(0.0),
				maxExpense.map(Expense::category).map(Category::name).orElse(null),
				maxExpense.map(Expense::amount).orElse(0.0),
				minExpense.map(Expense::category).map(Category::name).orElse(null),
				minExpense.map(Expense::amount).orElse(0.0)
		);
	}

	public Collection<Expense> findUser(Integer userId) {
		return expenseRepository.findByUserId(userId);
	}
}
