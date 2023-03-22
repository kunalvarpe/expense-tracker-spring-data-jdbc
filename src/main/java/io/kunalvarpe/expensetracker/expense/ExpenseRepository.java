package io.kunalvarpe.expensetracker.expense;

import java.util.Collection;

import org.springframework.data.repository.Repository;

public interface ExpenseRepository extends Repository<Expense, Integer> {

	Collection<Expense> findByUserId(Integer userId);

}
