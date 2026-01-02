package com.ullas.repository;

import com.ullas.db.DatabaseConnection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserRepository {
    private DatabaseConnection db;

    @Autowired
    public UserRepository(DatabaseConnection db) {
        this.db = db;
    }

    public List<String> findAll(){
        return db.getUsers();
    }

    public void save(String user){
        db.addUser(user);
    }
    public void delete(String user){
        db.deleteUser(user);
    }
}
