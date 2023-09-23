package io.kunalvarpe.expensetracker.expense;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ExpenseController {

	private final ExpenseService expenseService;

	public ExpenseController(ExpenseService expenseService) {
		this.expenseService = expenseService;
	}

	@GetMapping("/insights")
	public String expenseInsights(String userId, Model model) {
		ExpenseInsight expenseInsight = expenseService.expenseInsight(1);
		model.addAttribute("expenseInsight", expenseInsight);
		return "expenses/insights";
	}

	@GetMapping("/expenses")
	public String expenses(String userId, Model model) {
		List<Expense> expenses = expenseService.findUser(1);
		model.addAttribute("expenses", expenses);
		return "expenses/expenses";
	}
}
