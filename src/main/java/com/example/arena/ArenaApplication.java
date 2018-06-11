package com.example.arena;

import com.example.arena.model.postaci.Istota;
import com.example.arena.service.TworzeniePostaciService;
import com.example.arena.service.WalkaService;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@EnableAutoConfiguration
@SpringBootConfiguration
@SpringBootApplication
public class ArenaApplication {

    private static final String DRIVER_CLASS_NAME = "org.postgresql.Driver";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/arena";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "admin";
    private static final int CONN_POOL_SIZE = 5;

    public static void main(String[] args) {
        /*BasicDataSource dataSource = new BasicDataSource();
        dataSource.setDriverClassName(DRIVER_CLASS_NAME);
        //Set database url
        dataSource.setUrl(DB_URL);
        //Set database user
        dataSource.setUsername(DB_USER);
        //Set database password
        dataSource.setPassword(DB_PASSWORD);
        //Set the connection pool size
        dataSource.setInitialSize(CONN_POOL_SIZE);
        String sql = "INSERT INTO AKTOR " +
        "( first_name, last_name) VALUES (?, ?)";


        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
        jdbcTemplate.update(sql, "edek", "ciapaty");*/

        WalkaService ws = new WalkaService();
        TworzeniePostaciService tps = new TworzeniePostaciService();
        ArenaApplication ap = new ArenaApplication();
        ap.ligaMistrzow(tps, ws);

        /*List<Istota> listaIstotNazwaMozeBycInna = tps.generujListeNowychPostaci(8);
        Istota zw1 = walkaService.zwyciezca(listaIstotNazwaMozeBycInna);
        System.out.println("1 turniej wygral "zw1.getName());*/
    }

    void ligaMistrzow(TworzeniePostaciService tps, WalkaService ws) {
        List<Istota> listaZwyciezcow = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            List<Istota> listaPostaci = tps.generujListeNowychPostaci(8);
            Istota wygrany = ws.zwyciezca(listaPostaci);
            listaZwyciezcow.add(wygrany);
        }
        for (Istota zwyciezca : listaZwyciezcow) {

            System.out.println("Uczestnikiem Ligi Mistrzów jest " + zwyciezca.getName());
        }
        ws.zwyciezca(listaZwyciezcow);
    }
}