package org.example.ebooky_new_project.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.ebooky_new_project.model.User;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepositoryImpl implements UserRepository {

    private File file = new File("user.txt");
    private final ObjectMapper objectMapper = new ObjectMapper();

    public UserRepositoryImpl(){
        try{
            if(!file.exists()){ //if file doesn't exist it will create
                file.createNewFile();
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }

        objectMapper.activateDefaultTyping(
                objectMapper.getPolymorphicTypeValidator(),
                ObjectMapper.DefaultTyping.JAVA_LANG_OBJECT,
                JsonTypeInfo.As.PROPERTY
        );
    }

    @Override
    public List<User> getAllUsers() {
        List<User> userList= new ArrayList<>();

        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            String line;
            while ((line = br.readLine()) != null) {
                User user = objectMapper.readValue(line, User.class);
                userList.add(user);
            }
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return userList;
    }

    @Override
    public User saveUser(User user) {
        List<User> users = getAllUsers();
        int userId = 1;
        if(users.size()==0){
            userId = 1;
        }else{
            userId = users.get(users.size()-1).getUserId()+1;
        }
        user.setUserId(userId);
        users.add(user);

        try(FileWriter fw = new FileWriter(file,true);
            PrintWriter pw = new PrintWriter(fw)){

            String json = objectMapper.writeValueAsString(user);
            pw.println(json);
            return user;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public Optional<User> updateUser(User user) {
        List<User> users = getAllUsers();
        for (User u:users){
            if(u.getUserId() == user.getUserId()){
                u.setEmail(user.getEmail());
                u.setFirstName(user.getFirstName());
                u.setLastName(user.getLastName());
                u.setPassword(user.getPassword());
                try {
                    saveAllUsers(users);
                    return Optional.of(user);
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return Optional.empty();
    }

    @Override
    public boolean deleteUser(int Id) {
        List<User> users = getAllUsers();

        for(User u: users){
            if(u.getUserId()==Id){
                users.remove(u);
                try{
                    saveAllUsers(users);
                    return true;
                }catch (Exception ex){
                    ex.printStackTrace();
                }
            }
        }
        return false;
    }

    public void saveAllUsers(List<User> users) {
        try (FileWriter fw = new FileWriter(file, false);
             PrintWriter pw = new PrintWriter(fw)) {

            for (User user : users) {
                String json = objectMapper.writeValueAsString(user);
                pw.println(json);  // Write each user on a new line
            }

            System.out.println("All users saved successfully!");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
