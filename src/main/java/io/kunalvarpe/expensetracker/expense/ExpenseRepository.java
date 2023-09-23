package io.kunalvarpe.expensetracker.expense;

import java.util.List;

import jakarta.annotation.Nonnull;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.transaction.annotation.Transactional;

public interface ExpenseRepository extends ListCrudRepository<Expense, Integer> {

	List<Expense> findByUserId(Integer userId);

	@Transactional(readOnly = true)
	@Query("select * from expenses order by id desc")
	@Nonnull
	List<Expense> findAll() throws DataAccessException;

}
