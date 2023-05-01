package com.app.service;

import com.app.model.Users;
import com.app.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UsersService  {

    private final UsersRepository usersRepository;

    @Autowired
    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Transactional
    public void add(Users user) {
        usersRepository.save(user);
    }

    @Transactional
    public void delete(Users user) {
        usersRepository.delete(user);
    }

    @Transactional(readOnly = true)
    public List<Users> read() {
        return usersRepository.findAll();
    }

    @Transactional
    public void update(Users user) {
       usersRepository.save(user);
    }
    @Transactional
    public Users showUser(int id) {
        return usersRepository.getOne(id);
    }
}
