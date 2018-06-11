package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.BronEnum;
import com.example.arena.model.wyposazenie.PancerzEnum;

import java.util.List;

public interface FunkcjeIstoty {

    void unik(Istota atakujacaIstota, WynikUderzenia wynikUderzenia);

    void ustawBron(BronEnum aktywowanaBron);

    void zalozPancerz(List<PancerzEnum> aktywowanePancerze);

    WynikUderzenia atak(Istota ofiara);

}
