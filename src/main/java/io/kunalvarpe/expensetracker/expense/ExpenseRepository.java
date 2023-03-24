package io.kunalvarpe.expensetracker.expense;

import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;
import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

public interface ExpenseRepository extends Repository<Expense, Integer> {

	Collection<Expense> findByUserId(Integer userId);

	@Transactional(readOnly = true)
	@Query("select * from expenses order by id desc")
	List<Expense> findAll() throws DataAccessException;

}
