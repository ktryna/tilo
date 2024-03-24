package ua.tilo.spring.service;

import ua.tilo.spring.model.MyUser;

import java.util.List;

public interface MyUserService {
    List<MyUser> findAllUser();
    MyUser saveUser(MyUser myUser);
    MyUser findByPhoneNumber(String phoneNumber);
    MyUser updateUser(MyUser myUser);
    void deleteUser(String phoneNumber);
}
