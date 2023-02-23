package com.adik.springboot.stadium.model;

import com.adik.springboot.stadium.exceptions.ValidationException;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerSupport {
    public CustomerSupport(@NotBlank(message = "Telephone number can not be empty!") @Size(min = 6, max = 20) String telephoneNumber, @NotBlank(message = "Email can not be empty!") @Email String email) {
        this.telephoneNumber = telephoneNumber;
        this.email = email;
    }

    @Id
    @SequenceGenerator(
            name = "customer_support_sequence",
            sequenceName = "customer_support_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "customer_support_sequence"
    )
    private Long id;

    @NotBlank(message = "Telephone number can not be empty!")
    @Size(min = 6, max = 20)
    private String telephoneNumber;

    @NotBlank(message = "Email can not be empty!")
    @Email
    private String email;

    @OneToMany(mappedBy = "customerSupport", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull csRepresentative> employees = new HashSet<>();

    @OneToMany(mappedBy = "contacts", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull User> users = new HashSet<>();

    public void addEmployee(csRepresentative c) {
        if (c.getCustomerSupport() != this) {
            throw new ValidationException("You are trying to add employee, which does not belong to this customer support!");
        }
        this.employees.add(c);
    }

    public void removeEmployee(csRepresentative c) {
        if (this.employees.contains(c)) {
            this.employees.remove(c);
            c.reassignCustomerSupport();
        }

    }

    public void addUser(User u) {
        if (u.getContacts() != this) {
            throw new ValidationException("You are trying to add user, who did not contact  this customer support!");
        }
        this.users.add(u);
    }

    public void removeUser(User u) {
        if (this.users.contains(u)) {
            this.users.remove(u);
            u.reassignContacts();
        }
    }

    public void AssignUserRequest() {
        for (csRepresentative e : this.employees) {
            if (e.getIsAvailable()) {
                e.takeRequest();
            }
        }


    }


}
