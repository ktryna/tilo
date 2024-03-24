package ua.tilo.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ua.tilo.spring.model.MyUser;


public interface MyUserRepository extends JpaRepository<MyUser, Long> {

    MyUser findMyUserByPhoneNumber(String phoneNumber);
    MyUser findMyUserByUserName(String userName);
    void deleteMyUserByPhoneNumber(String phoneNumber);

}