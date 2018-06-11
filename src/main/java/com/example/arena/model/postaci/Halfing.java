package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Halfing extends Humanoid {

    public Halfing() {
        super(TworzeniePostaciService.losuj(1, 2), TworzeniePostaciService.losuj(2, 6), TworzeniePostaciService.losuj(1, 4), TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(2, 5),
                TypPostaciEnum.HALFING, 1, 1, TworzeniePostaciService.losuj(1, 3), ImmutableList.of(new Bron(2, 5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE)
                ), ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.HUM_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(1, 2), losuj(2, 6), losuj(1, 4), losuj(1, 3), losuj(2, 5), losuj(1, 3),