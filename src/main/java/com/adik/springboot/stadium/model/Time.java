package com.adik.springboot.stadium.model;


import com.adik.springboot.stadium.exceptions.ValidationException;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.FutureOrPresent;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "time")
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Time {

    public Time(@NotNull @FutureOrPresent LocalDateTime startingDateTime,
                @NotNull LocalDateTime endingDateTime) {
        this.startingDateTime = startingDateTime;
        this.endingDateTime = endingDateTime;
    }

    @Id
    @SequenceGenerator(
            name = "time_sequence",
            sequenceName = "time_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "time_sequence"
    )
    private Long id;

    @NotNull
    @FutureOrPresent
    private LocalDateTime startingDateTime;

    @NotNull
    private LocalDateTime endingDateTime;

    @ManyToOne(optional = true)
    @JoinColumn(name = "game_id", nullable = true, updatable = true)
    private Game game;


    @OneToMany(mappedBy = "time", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Sector> sectors = new HashSet<>();

    @OneToMany(mappedBy = "time", cascade = CascadeType.REMOVE, fetch = FetchType.EAGER)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NotNull Ticket> tickets = new HashSet<>();


    public void setGame(Game g) {

        if (this.game == g) {
            return;
        }
        if (this.game != null && g == null) {
            reassignGame();
        } else if (this.game == null && g != null) {
            assignGame(g);
        } else if (this.game != null && g != null) {
            reassignGame();
            assignGame(g);
        }

    }

    public void delete() {
        reassignGame();
        for (Ticket t : this.tickets) {
            removeTicket(t);
        }
        for (Sector s : this.sectors){
            removeSector(s);
        }
    }


    public void assignGame(Game g) {
        this.game = g;
        g.addTime(this);
    }

    public void reassignGame() {
        Game game = this.game;
        this.game = null;
        game.removeTime(this);
    }



    public void addSector(Sector s) {
        if (s.getTime() != this) {
            throw new ValidationException("You are trying to add sector, which does not belong to this match!");
        }
        this.sectors.add(s);
    }

    public void removeSector(Sector s) {
        if (this.sectors.contains(s)) {
            this.sectors.remove(s);
            s.reassignTime();
        }

    }

    public void addTicket(Ticket t) {
        if (t.getTime() != this) {
            throw new ValidationException("You are trying to add ticket, which does not belong to this match!");
        }
        this.tickets.add(t);
    }

    public void removeTicket(Ticket t) {
        if (this.tickets.contains(t)) {
            this.tickets.remove(t);
            t.delete();
        }
    }
}
