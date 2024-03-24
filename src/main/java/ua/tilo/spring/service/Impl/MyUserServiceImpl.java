package ua.tilo.spring.service.Impl;

import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.tilo.spring.model.MyUser;
import ua.tilo.spring.repository.MyUserRepository;
import ua.tilo.spring.service.MyUserService;

import java.util.List;

@Service
@AllArgsConstructor
public class MyUserServiceImpl implements MyUserService {
    private final MyUserRepository repository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<MyUser> findAllUser() {
        return repository.findAll();
    }

    @Override
    public MyUser saveUser(MyUser myUser) {
        myUser.setPassWord(passwordEncoder.encode(myUser.getPassWord()));
        myUser.setRoles("ROLE_USER");
        return repository.save(myUser);
    }

    @Override
    public MyUser findByPhoneNumber(String phoneNumber) {
        return repository.findMyUserByPhoneNumber(phoneNumber);
    }

    @Override
    public MyUser updateUser(MyUser myUser) {
        return repository.save(myUser);
    }

    @Override
    @Transactional
    public void deleteUser(String phoneNumber) {
        repository.deleteMyUserByPhoneNumber(phoneNumber);
    }
}
