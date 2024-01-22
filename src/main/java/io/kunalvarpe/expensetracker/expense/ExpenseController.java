package io.kunalvarpe.expensetracker.expense;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000")
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/insights")
	public ExpenseInsight expenseInsights(@RequestParam Integer userId) {
		return expenseService.expenseInsight(userId);
	}

	@GetMapping("/expenses")
	public List<ExpenseDto> expenses(@RequestParam Integer userId) {
		return expenseService.findAllExpenses(userId);
	}

	@PostMapping("/expenses")
	public ResponseEntity<String> createExpense(@RequestParam Integer userId, @RequestBody ExpenseDto expense) {
		expenseService.createExpense(userId, expense);
		return ResponseEntity.ok("Expense added successfully.");
	}

	@GetMapping("/expenses/{id}")
	public ExpenseDto getExpense(@PathVariable Integer id) {
		return expenseService.findExpense(id);
	}

	@DeleteMapping("/expenses/{id}")
	public ResponseEntity<String> deleteExpense(@PathVariable Integer id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.noContent().build();
	}
}
