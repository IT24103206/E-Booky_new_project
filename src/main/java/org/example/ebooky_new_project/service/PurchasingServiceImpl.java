package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Purchasing;
import org.example.ebooky_new_project.model.User;
import org.example.ebooky_new_project.repository.PurchasingRepository;
import org.example.ebooky_new_project.repository.PurchasingRepositoryImpl;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PurchasingServiceImpl implements PurchasingService {
    private final PurchasingRepository repository;
    public PurchasingServiceImpl(){
        this.repository = new PurchasingRepositoryImpl();


    }

    @Override
    public List<Purchasing> getAllPurchasing() {
        return repository.getAllPurchasing();
    }

    @Override
    public List<Purchasing> getAllPurchasing(User user) {
        List<Purchasing> purchasingList = repository.getAllPurchasing();
        List<Purchasing> userPurchaseList = new ArrayList<>();
        for (Purchasing p: purchasingList){
            if(p.getPurchaseUser().getUserId()==user.getUserId()){
                userPurchaseList.add(p);
            }
        }
        return purchasingList;
    }

    @Override
    public List<Purchasing> getAllPurchasing(Book book) {
        List<Purchasing> purchasingList = repository.getAllPurchasing();
        List<Purchasing> bookPurchaseList = new ArrayList<>();
        for (Purchasing p: purchasingList){
            if(p.getPurchaseBook().getBookId()==book.getBookId()){
                bookPurchaseList.add(p);
            }
        }
        return bookPurchaseList;
    }

    @Override
    public Optional<Purchasing> addPurchasing(Purchasing purchasing) {
        Purchasing addPurchase = repository.addPurchasing(purchasing);
        if(addPurchase != null){
            return Optional.of(addPurchase);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Purchasing> updatePurchasing(Purchasing purchasing) {
        return null;
    }
}