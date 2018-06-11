package com.example.arena.model.wyposazenie;

import java.util.List;

/**
 * Created by Saad on 2018-01-23.
 */
public class EkwipunekPostaci {

    private List<Bron> listaPosiadanychBroni;
    private List<Pancerz> listaPosiadanychPancerzy;
    private List<InnePrzedmiotyEnum> listaPosiadanychPrzedmiotow;

    public EkwipunekPostaci(List<Bron> listaPosiadanychBroni, List<Pancerz> listaPosiadanychPancerzy, List<InnePrzedmiotyEnum> listaPosiadanychPrzedmiotow) {
        this.listaPosiadanychBroni = listaPosiadanychBroni;
        this.listaPosiadanychPancerzy = listaPosiadanychPancerzy;
        this.listaPosiadanychPrzedmiotow = listaPosiadanychPrzedmiotow;
    }

    public List<InnePrzedmiotyEnum> getlistaPosiadanychPrzedmiotow() {
        return listaPosiadanychPrzedmiotow;
    }

    public Bron wyjmijBroń(BronEnum aktywowanaBron) {
        if (getListaPosiadanychBroni().isEmpty()) {
            return null;
        }
        return getListaPosiadanychBroni().stream().filter(bron -> bron.getBronEnum().equals(aktywowanaBron))
                .findFirst().orElse(null);
    }

    public List<Bron> getListaPosiadanychBroni() {
        return listaPosiadanychBroni;
    }

    public Pancerz wyjmijPancerz(PancerzEnum aktywowanyPancerz) {
        if (getlistaPosiadanychPancerzy().isEmpty()) {
            return null;
        }
        return getlistaPosiadanychPancerzy().stream().filter(pancerz -> aktywowanyPancerz.equals(pancerz.getPancerzEnum()))
                .findFirst().orElse(null);
    }

    public List<Pancerz> getlistaPosiadanychPancerzy() {
        return listaPosiadanychPancerzy;
    }
}
