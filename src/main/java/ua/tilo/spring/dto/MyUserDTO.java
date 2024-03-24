package ua.tilo.spring.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class MyUserDTO {
    @NotEmpty
    @Size(min=2,max = 20)
    private String userName;

    @NotEmpty
    @Size(min=2,max = 20)
    private String firstName;
    @NotEmpty
    @Size(min=2,max = 20)
    private String lastName;

    @Pattern(regexp = "^\\d{10}$")
    private String phoneNumber;
    @Size(min=2,max = 20)
    private String passWord;



    
}
