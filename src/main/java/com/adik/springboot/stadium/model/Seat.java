package com.adik.springboot.stadium.model;

import com.adik.springboot.stadium.exceptions.ValidationException;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.Positive;

import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "seat")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Seat {

    public Seat(Sector sector,
                @Positive int seatNumber,
                @Positive double regularPrice) {
        this.seatNumber = seatNumber;
        this.regularPrice = regularPrice;
        setSector(sector);
    }

    @Id
    @SequenceGenerator(
            name = "seat_sequence",
            sequenceName = "seat_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "seat_sequence"
    )
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "sector_id", nullable = false, updatable = false)
    private Sector sector;

    @Positive
    private int seatNumber;

    @Positive
    private double regularPrice;

    @OneToMany(mappedBy = "seat", fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull Ticket> tickets = new HashSet<>();

    private Boolean isDeleted = false;

    private void setSector(Sector s) {
        this.sector = s;
        s.addSeat(this);
    }

    public void delete() {

        if (isDeleted) {
            return;
        }
        this.isDeleted = true;
        this.sector.removeSeat(this);
        for (Ticket t : this.tickets) {
            removeTicket(t);
        }
    }

    public void addTicket(Ticket t) {
        if (t.getSeat() != this) {
            throw new ValidationException("You are trying to add ticket, which does not belong to this seat!");
        }
        this.tickets.add(t);

    }

    public void removeTicket(Ticket t) {
        if (this.tickets.contains(t)) {
            this.tickets.remove(t);
            t.delete();
        }

    }

    public Boolean isAvailable(Time time) {
        for (Ticket t : this.tickets) {
            if (t.getTime().getId() == time.getId()) {
                return false;
            }
        }
        return true;
    }
}
