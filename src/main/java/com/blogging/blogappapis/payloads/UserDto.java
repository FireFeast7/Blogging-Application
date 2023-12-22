package com.blogging.blogappapis.payloads;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Integer id;

    @NotNull
    @NotBlank
    @Size(min = 5,message = "Enter Name Properly")
    private String name;

    @Email
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8,max = 20,message = "Must match Patter")
    @Pattern(regexp = "^.{8,}$")
    private String password;

    @NotNull
    @NotBlank
    @Size(max = 200,message = "Cannot be more than 200")
    private String about;
}
