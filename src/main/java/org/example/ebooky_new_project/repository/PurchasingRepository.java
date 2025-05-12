package org.example.ebooky_new_project.repository;

import org.example.ebooky_new_project.model.Purchasing;

import java.util.List;

public interface PurchasingRepository {
    List<Purchasing> getAllPurchasing();
    Purchasing addPurchasing(Purchasing purchasing);
    Purchasing updatePurchasing(Purchasing purchasing);
    boolean deletePurchasing(int id);
}
