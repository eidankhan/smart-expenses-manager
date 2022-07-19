package com.expenses.manager.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.expenses.manager.model.Expense;
import com.expenses.manager.model.GenericResponse;
import com.expenses.manager.services.ExpenseService;

@RestController
@RequestMapping("/expenses")
public class ExpenseController {

    @Autowired
    private ExpenseService expenseService;

    @GetMapping
    public GenericResponse getAll() {
        return expenseService.findAll();
    }

    @PostMapping
    public GenericResponse save(@RequestBody Expense expense) {
        return expenseService.save(expense);
    }
}
