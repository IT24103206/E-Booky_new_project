package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.PrintedBook;
import org.example.ebooky_new_project.model.Purchasing;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PurchasingRepositoryImpl implements PurchasingRepository {

    private final File file = new File("purchasing.txt");
    private final BookRepository bookRepository = new BookRepositoryImpl();
    public PurchasingRepositoryImpl(){
        if(!file.exists()){
            try{
                file.createNewFile();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }



    @Override
    public List<Purchasing> getAllPurchasing() {
        List<Purchasing> purchasingList = new ArrayList<>();

        try{
            ObjectMapper mapper = new ObjectMapper();
            purchasingList = mapper.readValue(file,mapper.getTypeFactory().constructType(List.class,Purchasing.class));
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return purchasingList;
    }

    @Override
    public Purchasing addPurchasing(Purchasing purchasing) {
        System.out.println("Adding Done");
        List<Purchasing> purchasingList = getAllPurchasing();
//        if(purchasing.getPurchaseBook() instanceof PrintedBook){
//            int bookCount = ((PrintedBook) purchasing.getPurchaseBook()).getAvailableStock();
//            ((PrintedBook) purchasing.getPurchaseBook()).setAvailableStock(bookCount-purchasing.getQuantity());
//            bookRepository.updateBook(purchasing.getPurchaseBook());
//        }
        ObjectMapper mapper = new ObjectMapper();
        purchasingList.add(purchasing);
        try{
            mapper.writeValue(file,purchasingList);
            System.out.println(purchasing.getPurchaseBook().getBookId());
            return purchasing;
        }catch (Exception ex){
            ex.printStackTrace();
            System.out.println(ex);
        }

        return null;
    }

    @Override
    public Purchasing updatePurchasing(Purchasing purchasing) {
        return null;
    }

    @Override
    public boolean deletePurchasing(int id) {
        return false;
    }


}
