package com.app.service;

import com.app.model.Users;

import java.util.List;

public interface UsersService {

    void add (Users user);
    void delete (Users user);
    List<Users> read();
    void update (Users user);
    Users showUser(int id);

}
