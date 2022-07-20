package com.expenses.manager.repository;

import org.springframework.stereotype.Repository;

import com.expenses.manager.model.Expense;
import com.expenses.manager.model.GenericResponse;

@Repository
public interface ExpenseRepository {

    public GenericResponse findAll();

    public GenericResponse findById(Integer id);

    public GenericResponse save(Expense expense);

    public GenericResponse updateById(Integer id, Expense expense);

    public GenericResponse deleteById(Integer id);

    public GenericResponse findAllByCurrentMonth();

}
