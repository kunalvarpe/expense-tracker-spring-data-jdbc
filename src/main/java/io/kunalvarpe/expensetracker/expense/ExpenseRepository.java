package io.kunalvarpe.expensetracker.expense;

import java.util.List;

import org.springframework.data.repository.ListCrudRepository;

public interface ExpenseRepository extends ListCrudRepository<Expense, Integer> {

	List<Expense> findByUserId(Integer userId);

}
