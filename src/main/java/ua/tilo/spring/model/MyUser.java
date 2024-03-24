package ua.tilo.spring.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "users")
public class MyUser {
    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true)
    private String userName;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String phoneNumber;

    private String passWord;
//    @Column(columnDefinition = "varchar(255) default 'user'")  ні на що не впливає
    private String roles;



}
