package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Troll extends Humanoid {

    public Troll() {
        super(TworzeniePostaciService.losuj(3, 6), TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(3, 7), TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(1, 3),
                TypPostaciEnum.TROLL, 1, 1, TworzeniePostaciService.losuj(4, 8), ImmutableList.of(new Bron(2, 5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE)
                ), ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.HUM_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }

}

//losuj(3, 6), losuj(1, 3), losuj(3, 7), losuj(1, 3), losuj(1, 3), losuj(4, 8),