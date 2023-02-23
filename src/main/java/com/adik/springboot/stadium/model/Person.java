package com.adik.springboot.stadium.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@MappedSuperclass
@Data
@AllArgsConstructor
@NoArgsConstructor
public abstract class Person {

    @NotBlank(message = "Name can not be empty")
    @Size(min = 3, max = 255)
    private String name;

    @NotBlank(message = "Telephone number can not be empty")
    @Size(min = 6, max = 20)
    private String telephoneNumber;

    @NotBlank(message = "Email can not be empty")
    @Email
    private String email;

}
