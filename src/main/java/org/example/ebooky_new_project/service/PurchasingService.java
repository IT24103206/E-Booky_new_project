package org.example.ebooky_new_project.service;

import org.example.ebooky_new_project.model.Book;
import org.example.ebooky_new_project.model.Purchasing;
import org.example.ebooky_new_project.model.User;


import java.util.List;
import java.util.Optional;

public interface PurchasingService {
    List<Purchasing> getAllPurchasing();
    List<Purchasing> getAllPurchasing(User user);
    List<Purchasing> getAllPurchasing(Book book);

    Optional<Purchasing> addPurchasing(Purchasing purchasing);
    Optional<Purchasing> updatePurchasing(Purchasing purchasing);
}
