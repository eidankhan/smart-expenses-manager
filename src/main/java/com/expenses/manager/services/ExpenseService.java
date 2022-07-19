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
import com.google.cloud.firestore.WriteResult;

@Service
public class ExpenseService implements ExpenseRepository {

    @Override
    public GenericResponse findAll() {
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        ApiFuture<QuerySnapshot> apiFuture = firestoreDB.collection("expenses").get();
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
        System.out.println("UserService.getAll() --> is called");
        GenericResponse response = new GenericResponse();
        Firestore firestoreDB = FirestoreInstance.getFirestoreInstance();
        ApiFuture<WriteResult> createdDocument = firestoreDB.collection("expenses").document(expense.getId().toString())
                .create(expense);
        try {
            String documentUpdateTime = createdDocument.get().getUpdateTime().toString();
            System.out.println("UserService.getAll() --> Document Updated At " + documentUpdateTime);
            response.setCode(ResponseCode.SUCCESS.getCode());
            response.setMessage(ResponseCode.SUCCESS.getMessage());
            response.setData(expense);
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

}
