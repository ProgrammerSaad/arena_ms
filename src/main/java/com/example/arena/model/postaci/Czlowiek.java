package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

public class Czlowiek extends Humanoid {

    public Czlowiek() {
        super(TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(1, 5), TworzeniePostaciService.losuj(2, 5), TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(2, 5),
                TypPostaciEnum.CZLOWIEK, 1, 1, TworzeniePostaciService.losuj(2, 5), ImmutableList.of(new Bron(2, 5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE)
                ), ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.HUM_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(1, 3), losuj(1, 5), losuj(2, 5), losuj(1, 3), losuj(2, 5), losuj(2, 5),