package com.example.arena.service;

import com.example.arena.model.postaci.*;
import com.example.arena.model.wyposazenie.Bron;
import com.example.arena.model.wyposazenie.BronEnum;
import com.example.arena.model.wyposazenie.TypyBroniEnum;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TworzeniePostaciService {

    public List<Istota> generujListeNowychPostaci(Integer iloscNowychPostaci) {
        List<Istota> generujListeNowychPostaci = new ArrayList<>();
        for (int i = 0; i < iloscNowychPostaci; i++) {
            int wylosowanyIndexPostaci = losuj(0, TypPostaciEnum.values().length - 1);
            List<TypPostaciEnum> listaTypowPostaci = Arrays.asList(TypPostaciEnum.values());
            TypPostaciEnum wylosowanyTypPostaci = listaTypowPostaci.get(wylosowanyIndexPostaci);
            TworzeniePostaciService tps = new TworzeniePostaciService();
            generujListeNowychPostaci.add(tps.stworzIstote(wylosowanyTypPostaci));
        }
        return generujListeNowychPostaci;
    }

    public static int losuj(int minimum, int maximum) {
        Random rn = new Random();
        return rn.nextInt(maximum - minimum + 1) + minimum;
    }

    Istota stworzIstote(TypPostaciEnum typPostaci) {
        Bron bron = new Bron(2, 5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE);


        Istota nowaPostac;

        if (typPostaci.equals(TypPostaciEnum.CZLOWIEK)) {
            nowaPostac = new Czlowiek();
        } else if (typPostaci.equals(TypPostaciEnum.ORK)) {
            nowaPostac = new Ork();
        } else if (typPostaci.equals(TypPostaciEnum.KRASNOLUD)) {
            nowaPostac = new Krasnolud();
        } else if (typPostaci.equals(TypPostaciEnum.ELF)) {
            nowaPostac = new Elf();
        } else if (typPostaci.equals(TypPostaciEnum.HALFING)) {
            nowaPostac = new Halfing();
        } else if (typPostaci.equals(TypPostaciEnum.TROLL)) {
            nowaPostac = new Troll();
        } else if (typPostaci.equals(TypPostaciEnum.PIES)) {
            nowaPostac = new Pies();
        } else if (typPostaci.equals(TypPostaciEnum.TYGRYS)) {
            nowaPostac = new Tygrys();
        } else if (typPostaci.equals(TypPostaciEnum.NIEDŹWIEDŹ)) {
            nowaPostac = new Niedźwiedź();
        } else {
            nowaPostac = null;
        }
        if (Objects.nonNull(nowaPostac)) {
            nowaPostac.setName(typPostaci.name());
            System.out.println("Nowa postać to: " + nowaPostac.toString());
        }
        return nowaPostac;
    }
}
