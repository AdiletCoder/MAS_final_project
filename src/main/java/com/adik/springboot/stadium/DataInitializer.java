package com.adik.springboot.stadium;
import com.adik.springboot.stadium.model.*;
import com.adik.springboot.stadium.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final GameRepository gameRepository;

    private final SectorRepository sectorRepository;
    private final SeatRepository seatRepository;
    private final StadiumRepository stadiumRepository;
    private final TimeRepository timeRepository;

    private final CustomerSupportRepository csrepository;
    private final csRepresentativeRepository representative;
    private final UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {

        List<String> tournaments = new ArrayList<>();
        tournaments.add("FIFA World Cup");
        tournaments.add("Confederation Cup");
        String teamsName = "Poland vs Belgium";
        Game game = new Game(teamsName, tournaments);

        List<String> tournaments1 = new ArrayList<>();
        tournaments1.add("UEFA Champions League");
        tournaments1.add("UEFA Europe League");
        String teamsName1 = "Legia vs Valencia";
        Game game1 = new Game(teamsName1, tournaments1);

        List<String> tournaments2 = new ArrayList<>();
        tournaments2.add("Copa America");
        tournaments2.add("Copa Libertadores");
        String teamsName2 = "Argentina vs Brazil";
        Game game2 = new Game(teamsName2, tournaments2);

        List<String> tournaments3 = new ArrayList<>();
        tournaments3.add("British Premier League");
        tournaments3.add("FA Cup");
        String teamsName3 = "Southampton vs Tottenhem";
        Game game3 = new Game(teamsName3, tournaments3);

        List<String> tournaments4 = new ArrayList<>();
        tournaments4.add("Seria A");
        tournaments.add("Italian Cup");
        String teamsName4 = "Juventus vs Milan";
        Game game4 = new Game(teamsName4, tournaments4);

        List<String> tournaments5 = new ArrayList<>();
        tournaments5.add("La liga");
        tournaments5.add("Spain King's Cup");
        String teamsName5 = "Barcelona vs Real Madrid";
        Game game5 = new Game(teamsName5, tournaments5);

        List<String> tournaments6 = new ArrayList<>();
        tournaments6.add("League 1");
        tournaments6.add("France Cup");
        String teamsName6 = "PSG vs Lille";
        Game game6 = new Game(teamsName6, tournaments6);

        List<String> tournaments7 = new ArrayList<>();
        tournaments7.add("Africa Cup of Nations");
        tournaments7.add("Copa Del Rey");
        String teamsName7 = "Ghana vs South Africa";
        Game game7 = new Game(teamsName7, tournaments);

        List<String> tournaments8 = new ArrayList<>();
        tournaments8.add("AFC Asian Cup");
        tournaments8.add("AFC Championship");
        String teamsName8 = "Japan vs Kyrgyzstan";
        Game game8 = new Game(teamsName8, tournaments8);

        gameRepository.save(game);
        gameRepository.save(game1);
        gameRepository.save(game2);
        gameRepository.save(game3);
        gameRepository.save(game4);
        gameRepository.save(game5);
        gameRepository.save(game6);
        gameRepository.save(game7);
        gameRepository.save(game8);


        Stadium stamfordBridge = new Stadium("StamfordBridge", "Fulham Rd., London SW6 1HS");
        Stadium maracana = new Stadium("Maracanã", "Maracanã, Rio de Janeiro");


        Time t1 = new Time(LocalDateTime.of(2023, 10, 2, 10, 30), LocalDateTime.of(2023, 12, 2, 18, 30));
        t1.setGame(game);
        Time t2 = new Time(LocalDateTime.of(2023, 7, 14, 15, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t2.setGame(game);
        Time t3 = new Time(LocalDateTime.of(2023, 8, 8, 14, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t3.setGame(game);
        Time t4 = new Time(LocalDateTime.of(2023, 10, 1, 16, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t4.setGame(game);
        Time t5 = new Time(LocalDateTime.of(2023, 11, 2, 9, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t5.setGame(game);
        Time t6 = new Time(LocalDateTime.of(2023, 8, 9, 13, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t6.setGame(game);
        Time t7 = new Time(LocalDateTime.of(2023, 7, 16, 12, 30), LocalDateTime.of(2023, 12, 2, 20, 30));
        t7.setGame(game);
        Time t8 = new Time(LocalDateTime.of(2023, 10, 30, 14, 30), LocalDateTime.of(2023, 12, 2, 18, 30));
        t8.setGame(game);
        Time t9 = new Time(LocalDateTime.of(2023, 10, 29, 15, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t9.setGame(game);
        Time t10 = new Time(LocalDateTime.of(2023, 10, 27, 16, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t10.setGame(game);
        Time t11 = new Time(LocalDateTime.of(2023, 7, 23, 17, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t11.setGame(game);
        Time t12 = new Time(LocalDateTime.of(2023, 6, 20, 9, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t12.setGame(game);
        Time t13 = new Time(LocalDateTime.of(2023, 9, 7, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t13.setGame(game);
        Time t14 = new Time(LocalDateTime.of(2023, 11, 4, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t14.setGame(game);
        Time t15 = new Time(LocalDateTime.of(2023, 9, 12, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t15.setGame(game);
        Time t16 = new Time(LocalDateTime.of(2023, 6, 19, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t16.setGame(game);
        Time t17 = new Time(LocalDateTime.of(2023, 9, 18, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t17.setGame(game);
        Time t18 = new Time(LocalDateTime.of(2023, 8, 16, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t18.setGame(game);
        Time t19 = new Time(LocalDateTime.of(2023, 9, 18, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t19.setGame(game);
        Time t20 = new Time(LocalDateTime.of(2023, 8, 16, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t20.setGame(game);

        Time t21 = new Time(LocalDateTime.of(2023, 8, 16, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t21.setGame(game1);
        Time t22 = new Time(LocalDateTime.of(2023, 9, 18, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t22.setGame(game1);
        Time t23 = new Time(LocalDateTime.of(2023, 8, 16, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t23.setGame(game1);

        Time t24 = new Time(LocalDateTime.of(2023, 6, 19, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t24.setGame(game2);
        Time t25 = new Time(LocalDateTime.of(2023, 9, 18, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t25.setGame(game2);

        Time t27 = new Time(LocalDateTime.of(2023, 6, 19, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t27.setGame(game3);
        Time t26 = new Time(LocalDateTime.of(2023, 9, 18, 10, 30), LocalDateTime.of(2023, 12, 2, 12, 30));
        t26.setGame(game3);

        timeRepository.save(t1);
        timeRepository.save(t2);
        timeRepository.save(t3);
        timeRepository.save(t4);
        timeRepository.save(t5);
        timeRepository.save(t6);
        timeRepository.save(t7);
        timeRepository.save(t8);
        timeRepository.save(t9);
        timeRepository.save(t10);
        timeRepository.save(t11);
        timeRepository.save(t12);
        timeRepository.save(t13);
        timeRepository.save(t14);
        timeRepository.save(t15);
        timeRepository.save(t16);
        timeRepository.save(t17);
        timeRepository.save(t18);
        timeRepository.save(t19);
        timeRepository.save(t20);

        timeRepository.save(t21);
        timeRepository.save(t22);
        timeRepository.save(t23);

        timeRepository.save(t24);
        timeRepository.save(t25);

        timeRepository.save(t26);
        timeRepository.save(t27);

        Sector sector = new Sector("G10", 10, stamfordBridge);
        sector.setTime(t1);
        sector.setTime(t7);
        Sector sector1 = new Sector("G11", 10, stamfordBridge);
        sector1.setTime(t2);
        sector.setTime(t8);
        Sector sector2 = new Sector("M16", 25, stamfordBridge);
        sector2.setTime(t3);
        sector2.setTime(t9);
        Sector sector3 = new Sector("Sector Norte", 15, maracana);
        sector3.setTime(t21);
        sector3.setTime(t22);
        Sector sector4 = new Sector("Sector Sul", 25, maracana);
        sector4.setTime(t23);
        sector4.setTime(t24);
        Sector sector5 = new Sector("Sector Leste", 25, maracana);
        sector5.setTime(t26);
        sector5.setTime(t27);


        Seat s11 = new Seat(sector, 10, 150.0);
        Seat s12 = new Seat(sector, 12, 105.0);
        Seat s13 = new Seat(sector, 13, 150.0);
        Seat s14 = new Seat(sector, 16, 150.0);
        Seat s15 = new Seat(sector, 17, 150.0);
        Seat s16 = new Seat(sector, 18, 150.0);
        Seat s17 = new Seat(sector, 19, 150.0);
        Seat s18 = new Seat(sector, 20, 150.0);
        Seat s19 = new Seat(sector, 21, 15.0);
        Seat s110 = new Seat(sector, 22, 150.0);
        Seat s21 = new Seat(sector1, 10, 15.0);
        Seat s22 = new Seat(sector1, 12, 15.0);
        Seat s23 = new Seat(sector1, 13, 15.0);
        Seat s24 = new Seat(sector1, 16, 15.0);
        Seat s25 = new Seat(sector1, 17, 15.0);
        Seat s26 = new Seat(sector1, 18, 15.0);
        Seat s27 = new Seat(sector1, 19, 15.0);
        Seat s28 = new Seat(sector1, 20, 15.0);
        Seat s29 = new Seat(sector1, 21, 15.0);
        Seat s210 = new Seat(sector1, 22, 15.0);
        Seat s31 = new Seat(sector2, 44, 23.0);
        Seat s32 = new Seat(sector2, 45, 23.0);
        Seat s33 = new Seat(sector2, 46, 23.0);
        Seat s34 = new Seat(sector2, 47, 23.0);
        Seat s35 = new Seat(sector2, 48, 23.0);
        Seat s36 = new Seat(sector2, 49, 23.0);
        Seat s37 = new Seat(sector2, 50, 23.0);
        Seat s38 = new Seat(sector2, 43, 23.0);
        Seat s39 = new Seat(sector2, 42, 23.0);
        Seat s310 = new Seat(sector2, 41, 23.0);
        Seat s41 = new Seat(sector3, 50, 18.0);
        Seat s42 = new Seat(sector3, 51, 18.0);
        Seat s43 = new Seat(sector3, 52, 18.0);
        Seat s44 = new Seat(sector3, 53, 18.0);
        Seat s45 = new Seat(sector3, 54, 18.0);
        Seat s46 = new Seat(sector3, 55, 18.0);
        Seat s47 = new Seat(sector3, 56, 18.0);
        Seat s48 = new Seat(sector3, 57, 18.0);
        Seat s49 = new Seat(sector3, 58, 18.0);
        Seat s410 = new Seat(sector3, 90, 18.0);
        Seat s411 = new Seat(sector3, 59, 18.0);
        Seat s51 = new Seat(sector4, 60, 31.0);
        Seat s52 = new Seat(sector4, 61, 31.0);
        Seat s53 = new Seat(sector4, 62, 31.0);
        Seat s54 = new Seat(sector4, 63, 31.0);
        Seat s55 = new Seat(sector4, 64, 31.0);
        Seat s56 = new Seat(sector4, 65, 31.0);
        Seat s57 = new Seat(sector4, 66, 31.0);
        Seat s58 = new Seat(sector4, 67, 31.0);
        Seat s59 = new Seat(sector4, 68, 31.0);
        Seat s61 = new Seat(sector5, 70, 12.5);
        Seat s62 = new Seat(sector5, 71, 12.5);
        Seat s63 = new Seat(sector5, 72, 12.5);
        Seat s64 = new Seat(sector5, 73, 12.5);
        Seat s65 = new Seat(sector5, 74, 12.5);
        Seat s66 = new Seat(sector5, 75, 12.5);
        Seat s67 = new Seat(sector5, 76, 12.5);
        Seat s68 = new Seat(sector5, 77, 12.5);
        Seat s69 = new Seat(sector5, 78, 12.5);
        Seat s610 = new Seat(sector5, 79, 12.5);


        stadiumRepository.save(stamfordBridge);
        stadiumRepository.save(maracana);
        sectorRepository.save(sector);
        sectorRepository.save(sector1);
        sectorRepository.save(sector2);
        sectorRepository.save(sector3);
        sectorRepository.save(sector4);
        sectorRepository.save(sector5);

        Status status = new Status("student", 10);
        Status status2 = new Status("pensioner", 15);
        Status status4 = new Status("regular", 0);


        CustomerSupport c = new CustomerSupport("123457", "foootballcustomersupport@gmail.com");
        List<String> lang = new ArrayList<>();
        lang.add("English");
        lang.add("Polish");

        csRepresentative r = new csRepresentative("Some person", "5279875", "theemail@gmail.com", lang, true);
        r.setCustomerSupport(c);
        csrepository.save(c);
        representative.save(r);

    }
}