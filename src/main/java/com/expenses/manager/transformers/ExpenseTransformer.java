package com.expenses.manager.transformers;

import com.expenses.manager.model.Expense;
import com.expenses.manager.model.dto.ExpenseDTO;
import com.expenses.manager.util.ConverterHelper;

public class ExpenseTransformer {
	
	public static ExpenseDTO convertExpenseToExpenseDTO(Expense expense) {
		ExpenseDTO expenseDTO = new ExpenseDTO();
		expenseDTO.setId(expense.getId());
		expenseDTO.setAmount(expense.getAmount());
		expenseDTO.setDescription(expense.getDescription());
		expenseDTO.setDate(ConverterHelper.convertMillisecondsToDateString(expense.getEntryDate()));
		return expenseDTO;
	}
}
