package com.adik.springboot.stadium.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "customer_support_representative")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class csRepresentative extends Person{

    public csRepresentative(@NotBlank(message = "Name can not be empty")
                            @Size(min = 3, max = 255) String name,
                            @NotBlank(message = "Telephone number can not be empty")
                            @Size(min = 6, max = 255) String telephoneNumber,
                            @NotBlank(message = "Email can not be empty")
                            @Email String email,
                            @NotNull @Size(min = 1) List<@NotBlank @Size(min = 3, max = 100) String> languages,
                            @NotNull Boolean isAvailable) {
        super(name, telephoneNumber, email);
        this.languages = languages;
        this.isAvailable = isAvailable;
    }

    @Id
    @SequenceGenerator(
            name = "staff_id_sequence",
            sequenceName = "staff_id_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "staff_id_sequence"
    )
    private Long id;

    @ElementCollection
    @NotNull
    @Size(min = 1)
    private List<@NotBlank @Size(min = 3, max = 100) String> languages = new ArrayList<>();

    @NotNull
    private Boolean isAvailable;


    @ManyToOne(optional = true)
    @JoinColumn(name = "customer_support_id", nullable = true, updatable = true)
    private CustomerSupport customerSupport;

    public void addLanguage(String lang) {
        this.languages.add(lang);
    }

    public void removeLanguage(String lang) {
        this.languages.remove(lang);
    }


    public void setCustomerSupport(CustomerSupport c) {

        if (this.customerSupport == c) {
            return;
        }
        if (this.customerSupport != null && c == null) {
            reassignCustomerSupport();
        } else if (this.customerSupport == null && c != null) {
            assignCustomerSupport(c);
        } else if (this.customerSupport != null && c != null) {
            reassignCustomerSupport();
            assignCustomerSupport(c);
        }

    }

    public void assignCustomerSupport(CustomerSupport c) {
        this.customerSupport = c;
        c.addEmployee(this);
    }

    public void reassignCustomerSupport() {
        CustomerSupport cs = this.customerSupport;
        this.customerSupport = null;
        cs.removeEmployee(this);
    }

    public void takeRequest() {
        this.isAvailable = false;
    }

    public void EndRequest() {
        this.isAvailable = true;
    }

    public void delete() {
        reassignCustomerSupport();
    }
}
