package com.example.arena.service;

import com.example.arena.model.postaci.Istota;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WalkaService {

    public Istota zwyciezca(List<Istota> listaIstot) {
        Istota zwyciezcaTurnieju = turniej(listaIstot);
        System.out.println("Zwycięzcą turnieju została postać " + zwyciezcaTurnieju);
        return zwyciezcaTurnieju;
    }

    Istota turniej(List<Istota> uczestniczy) {
        WalkaService ws = new WalkaService();
        if (uczestniczy.isEmpty()) {
            System.out.println("Brak wojownikow na placu boju");
            return null;
        } else {
            if (uczestniczy.size() <= 1) {
                return uczestniczy.get(0);
            } else {
                Istota pierwszyWytypowany = wylosujWojownika(uczestniczy);
                Istota drugiWytypowany = wylosujWojownika(uczestniczy);
                uczestniczy.add(ws.walka(pierwszyWytypowany, drugiWytypowany));
                return turniej(uczestniczy);
            }
        }
    }

    Istota wylosujWojownika(List<Istota> uczestniczy) {
        int wylosowanyIndexPostaci = TworzeniePostaciService.losuj(0, uczestniczy.size() - 1);
        Istota pierwszyWytypowany = uczestniczy.get(wylosowanyIndexPostaci);
        uczestniczy.remove(pierwszyWytypowany);
        return pierwszyWytypowany;
    }

    void rundaWalki(Istota atakujacy, Istota ofiara) {
        while (atakujacy.getIloscAtakow() > 0 && ofiara.getIloscAtakow() > 0) {
            if (atakujacy.getPunktyZycia() > 0 && ofiara.getPunktyZycia() > 0) {
                atakujacy.atak(ofiara);
            }
            if (ofiara.getPunktyZycia() > 0) {
                ofiara.atak(atakujacy);
            }
        }
        atakujacy.resetAtakowUnikow();
        ofiara.resetAtakowUnikow();
    }

    //TODO: W tej funkcji powinno się dynamicznie podstawiać czym jest atak

    public Istota walka(Istota atakujacy, Istota ofiara) {
        int rundaWalki = 0;
        while (atakujacy.getPunktyZycia() > 0 && ofiara.getPunktyZycia() > 0) {
            rundaWalki += 1;
            System.out.println("To jest " + rundaWalki + " runda walki");
            rundaWalki(atakujacy, ofiara);
        }

        Istota wygrywajacy = atakujacy.getPunktyZycia() > 0 ? atakujacy : ofiara;
        System.out.println("Zwycięzcą jest " + wygrywajacy.getName() + " zwyciężając po " + rundaWalki + " rundach walki");
        wygrywajacy.ustawDoswiadczenie(TworzeniePostaciService.losuj(100, 1000));
        return wygrywajacy;
    }
}

