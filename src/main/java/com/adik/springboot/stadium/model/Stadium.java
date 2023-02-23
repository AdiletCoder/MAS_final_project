package com.adik.springboot.stadium.model;

import com.adik.springboot.stadium.exceptions.ValidationException;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity()
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Stadium implements Serializable {

    public Stadium(@NotBlank(message = "Name can not be empty")
                   @Size(min = 3, max = 250) String name,
                   @NotBlank(message = "Address can not be empty")
                   @Size(min = 3, max = 500) String address) {
        this.name = name;
        this.address = address;
    }

    @Id
    @SequenceGenerator(
            name = "stadion_sequence",
            sequenceName = "stadion_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "stadion_sequence"
    )
    private Long id;

    @NotBlank(message = "Name can not be empty")
    @Size(min = 3, max = 250)
    private String name;

    @NotBlank(message = "Address can not be empty")
    @Size(min = 3, max = 500)
    private String address;

    @OneToMany(orphanRemoval = true, mappedBy = "stadium", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Sector> sectors = new HashSet<>();

    public void addSector(Sector s) {
        if (s.getStadium() != this) {
            throw new ValidationException("You are trying to add sector, which does not belong to this stadium!");
        }
        this.sectors.add(s);

    }

    public void removeSector(Sector s) {
        if (this.sectors.contains(s)) {
            this.sectors.remove(s);
            s.delete();
        }

    }

    public void delete() {
        for (Sector s : this.sectors) {
            removeSector(s);
        }
    }
}
