package com.adik.springboot.stadium.model;

import jakarta.persistence.Entity;
import com.adik.springboot.stadium.exceptions.ValidationException;
import lombok.*;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Entity(name = "game")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Game implements Serializable {
    private static final long serialVersionUID = 1L;

    public Game(@NotBlank(message = "Teams name cannot be empty")
                @Size(min = 3, max = 250) String teamsName,
                @NotNull @Size(min = 1)
                List<@NotBlank @Size(min = 3, max = 100) String> tournaments) {
        this.teamsName = teamsName;
        this.tournaments = tournaments;
    }

    @Id
    @SequenceGenerator(
            name = "game_sequence",
            sequenceName = "game_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = SEQUENCE,
            generator = "game_sequence"
    )
    private Long id;

    @NotBlank(message = "Teams name cannot be empty")
    @Size(min = 3, max = 250)
    private String teamsName;

    @ElementCollection
    @NotNull
    @Size(min = 1)
    private List<@NotBlank @Size(min = 3, max = 100) String> tournaments  = new ArrayList<>();

    @OneToMany(mappedBy = "game", fetch = FetchType.LAZY)
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<@NonNull Time> times = new HashSet<>();


    public void addTournament(String tour) {
        this.tournaments.add(tour);
    }

    public void removeTournament(String tour) {
        this.tournaments.remove(tour);
    }

    public void addTime(Time t) {
        if (t.getGame() != this) {
            throw new ValidationException("You are trying to add time, which does not belong to this tournament!");
        }
        this.times.add(t);
    }

    public void removeTime(Time t) {
        if (this.times.contains(t)) {
            this.times.remove(t);
            t.reassignGame();
        }

    }

}
