package com.adik.springboot.stadium.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.Embeddable;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Status {

    @NotBlank(message = "Status name can not be empty")
    @Size(min = 5, max = 255)
    private String statusName;

    @Min(0)
    private int discount;
}
