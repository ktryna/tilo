package ua.tilo.spring.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ua.tilo.spring.dto.MyUserDTO;
import ua.tilo.spring.mapper.MyUserMapper;
import ua.tilo.spring.model.MyUser;
import ua.tilo.spring.service.MyUserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/api/v1/users")
@AllArgsConstructor
public class MyUserController {
    private final MyUserService service;

    @GetMapping
    public List<MyUser> findAllStudent() {
        //todo
        return service.findAllUser();
    }


    @PostMapping("save_user")
    public Object saveStudent(@RequestBody @Valid MyUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().stream()
                    .map(e -> String.format("(%s) %s",e.getField(), e.getDefaultMessage()))
                    .toList();
        }
        service.saveUser(MyUserMapper.INSTANCE.toStudent(user));
        Map<String,String> result = new HashMap<>();
        result.put("result","OK");
        result.put("message","Student successfully saved");
        return result;
    }

    @GetMapping("/{phoneNumber}")
    public MyUser findByPhoneNumber(@PathVariable String phoneNumber) {
        return service.findByPhoneNumber(phoneNumber);
    }
    // /api/v1/students/oleg12@gmail.com

    @PutMapping("update_student")
    public Object updateStudent(@RequestBody @Valid MyUserDTO user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()){
            return bindingResult.getFieldErrors().stream()
                    .map(e -> String.format("(%s) %s",e.getField(), e.getDefaultMessage()))
                    .toList();
        }
        service.saveUser(MyUserMapper.INSTANCE.toStudent(user));
        Map<String,String> result = new HashMap<>();
        result.put("result","OK");
        result.put("message","Student successfully saved");
        return result;
    }

    @DeleteMapping("delete_student/{phoneNumber}")
    public void deleteStudent(@PathVariable String phoneNumber) {
        service.deleteUser(phoneNumber);
    }
}
