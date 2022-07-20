package com.expenses.manager.services;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.expenses.manager.firebase.FirestoreInstance;
import com.expenses.manager.model.Expense;
import com.expenses.manager.model.GenericResponse;
import com.expenses.manager.model.dto.ExpenseDTO;
import com.expenses.manager.repository.ExpenseRepository;
import com.expenses.manager.transformers.ExpenseTransformer;
import com.expenses.manager.util.ResponseCode;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;

@Service
public class ExpenseService implements ExpenseRepository {

    @Override
    public GenericResponse findAll() {
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        ApiFuture<QuerySnapshot> apiFuture = firestoreDB.collection("expenses").get();
        List<ExpenseDTO> expenses = new ArrayList<ExpenseDTO>();
        try {
            List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
            System.out.println("Iterating documents list -->>");
            for (QueryDocumentSnapshot document : documents) {
                Expense expense = document.toObject(Expense.class);
                System.out.println(expense);
                expenses.add(ExpenseTransformer.convertExpenseToExpenseDTO(expense));
            }

            if (documents.size() > 0) {
                response.setCode(ResponseCode.SUCCESS.getCode());
                response.setMessage(ResponseCode.SUCCESS.getMessage());
                response.setData(expenses);
                return response;
            }

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("No Data found");
        response.setCode(ResponseCode.NO_CONTENT.getCode());
        response.setMessage(ResponseCode.NO_CONTENT.getMessage());
        response.setData(null);
        return response;
    }

    @Override
    public GenericResponse findById(Integer id) {
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        DocumentReference documentReference = firestoreDB.collection("expenses").document(id.toString());
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        try {
            Expense expense = apiFuture.get().toObject(Expense.class);
            response.setCode(ResponseCode.SUCCESS.getCode());
            response.setMessage(ResponseCode.SUCCESS.getMessage());
            response.setData(ExpenseTransformer.convertExpenseToExpenseDTO(expense));
            return response;

        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        response.setCode(ResponseCode.NOT_FOUND.getCode());
        response.setMessage(ResponseCode.NOT_FOUND.getMessage());
        response.setData(null);
        return response;
    }

    @Override
    public GenericResponse save(Expense expense) {
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        ApiFuture<WriteResult> createdDocument = firestoreDB.collection("expenses").document(expense.getEntryDate().toString())
                .create(expense);
        try {
            String documentUpdateTime = createdDocument.get().getUpdateTime().toString();
            System.out.println("UserService.getAll() --> Document Updated At " + documentUpdateTime);
            //-- Transfer expense to expenseDTO
            response.setCode(ResponseCode.SUCCESS.getCode());
            response.setMessage(ResponseCode.SUCCESS.getMessage());
            response.setData(ExpenseTransformer.convertExpenseToExpenseDTO(expense));
            return response;
        } catch (InterruptedException | ExecutionException e) {
            response.setCode(ResponseCode.INVALID_DATA.getCode());
            response.setMessage(ResponseCode.INVALID_DATA.getMessage());
            response.setData(e.getMessage());
            System.out.println("UserService.getAll() --> Exception Occured");
            e.printStackTrace();
        }
        return response;
    }

    @Override
    public GenericResponse updateById(Integer id, Expense expense) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GenericResponse deleteById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GenericResponse findAllByCurrentMonth() {
        System.out.println("UserService.findAllByCurrentMonth() --> is called");
        GenericResponse response = new GenericResponse();
        Integer monthIndex = LocalDate.now().getMonth().getValue() - 1;
        List<Expense> currentMonthExpenses = filterDataByMonth(monthIndex);
        if (currentMonthExpenses.size() > 0) {
            response.setCode(ResponseCode.SUCCESS.getCode());
            response.setMessage(ResponseCode.SUCCESS.getMessage());
            response.setData(currentMonthExpenses);
            return response;
        }
        response.setCode(ResponseCode.NO_CONTENT.getCode());
        response.setMessage(ResponseCode.NO_CONTENT.getMessage());
        response.setData(currentMonthExpenses);
        return response;
    }

    private List<Expense> getAll() {
        System.out.println("UserService.getAll() --> is called");
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        ApiFuture<QuerySnapshot> apiFuture = firestoreDB.collection("expenses").get();
        List<Expense> expenses = new ArrayList<Expense>();
        try {
            List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
            for (QueryDocumentSnapshot document : documents) {
                Expense expense = document.toObject(Expense.class);
                System.out.println(expense);
                expenses.add(expense);
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        return expenses;
    }

    private List<Expense> filterDataByMonth(Integer monthIndex) {
        System.out.println("UserService.filterDataByMonth() --> is called");
        List<Expense> expenses = getAll();
//        expenses = expenses.stream().filter(ele -> ele.getTimestamp().getMonth() == monthIndex)
//                .collect(Collectors.toList());
        return expenses;
    }
}
