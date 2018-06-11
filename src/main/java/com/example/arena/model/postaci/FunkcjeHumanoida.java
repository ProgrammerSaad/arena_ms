package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.Bron;

/**
 * Created by Saad on 2018-03-04.
 */
public interface FunkcjeHumanoida extends FunkcjeIstoty {

    WynikUderzenia uderz(Istota targetInnaIstota);

    WynikUderzenia strzel(Istota targetInnaIstota, Bron bronStrzelecka);
}