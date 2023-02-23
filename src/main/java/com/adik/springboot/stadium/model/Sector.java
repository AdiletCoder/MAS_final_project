package com.adik.springboot.stadium.model;

import com.adik.springboot.stadium.exceptions.ValidationException;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "sector")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Sector implements Serializable {

    public Sector(@NotBlank(message = "Name can not be empty!") @Size(min = 3, max = 500) String name, @Min(1) int numberOfSeats, Stadium stadium) {
        this.name = name;
        this.numberOfSeats = numberOfSeats;
        setStadium(stadium);
    }

    @Id
    @SequenceGenerator(
            name = "sector_sequence",
            sequenceName = "sector_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "sector_sequence"
    )
    private Long id;

    @NotBlank(message = "Name can not be empty!")
    @Size(min = 3, max = 500)
    private String name;

    @Min(1)
    private int numberOfSeats;

    @ManyToOne(optional = false)
    @JoinColumn(name = "stadium_id", nullable = false, updatable = false)
    private Stadium stadium;

    @OneToMany(orphanRemoval = true, mappedBy = "sector", cascade = {CascadeType.REMOVE, CascadeType.PERSIST}, fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Seat> seats = new HashSet<>();

    @ManyToOne(optional = false)
    @JoinColumn(name = "stime_id", nullable = true, updatable = true)
    private  Time time;

    private Boolean isDeleted = false;

    private void setStadium(Stadium stadium) {
        this.stadium = stadium;
        stadium.addSector(this);
    }

    public void delete() {
        if (this.isDeleted = true) {
            return;
        }
        if (this.time == null) {
            return;
        }
        reassignTime();
        this.isDeleted = true;
        this.stadium.removeSector(this);
        for (Seat s : this.seats) {
            removeSeat(s);
        }
    }

    public void setTime(Time  t) {

        if (this.time == t) {
            return;
        }
        if (this.time != null && t == null) {
            reassignTime();
        } else if (this.time == null) {
            assignTime(t);
        } else if (this.time != null && t != null) {
            reassignTime();
            assignTime(t);
        }

    }

    public void assignTime(Time t) {
        this.time = t;
        t.addSector(this);
    }

    public void reassignTime() {
        Time time = this.time;
        this.time = null;
        time.removeSector(this);
    }

    public void addSeat(Seat s) {
        if (s.getSector() != this) {
            throw new ValidationException("You are trying to add seat, which does not belong to this sector!");
        }
        this.seats.add(s);
    }

    public void removeSeat(Seat s) {
        if (this.seats.contains(s)) {
            this.seats.remove(s);
            s.delete();
        }

    }

}
