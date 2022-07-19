package com.expenses.manager.services;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.expenses.manager.firebase.FirestoreInstance;
import com.expenses.manager.model.Expense;
import com.expenses.manager.model.GenericResponse;
import com.expenses.manager.repository.ExpenseRepository;
import com.expenses.manager.util.ResponseCode;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QueryDocumentSnapshot;
import com.google.cloud.firestore.QuerySnapshot;

@Service
public class ExpenseService implements ExpenseRepository {

    @Override
    public GenericResponse findAll() {
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore db = FirestoreInstance.getFirestoreInstance();
        ApiFuture<QuerySnapshot> apiFuture = db.collection("expenses").get();
        List<Expense> expenses = new ArrayList<Expense>();
        try {
            List<QueryDocumentSnapshot> documents = apiFuture.get().getDocuments();
            System.out.println("Iterating documents list -->>");
            for (QueryDocumentSnapshot document : documents) {
                Expense employee = document.toObject(Expense.class);
                System.out.println(employee);
                expenses.add(employee);
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
        response.setCode(ResponseCode.NO_CONTENT.getCode());
        response.setMessage(ResponseCode.NO_CONTENT.getMessage());
        response.setData(null);
        return response;
    }

    @Override
    public GenericResponse findById(Integer id) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public GenericResponse save(Expense expense) {
        // TODO Auto-generated method stub
        return null;
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

}
