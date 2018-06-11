package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by lzaboklicki on 06.12.2017.
 */
public class Ork extends Humanoid {

    public Ork() {
        super(TworzeniePostaciService.losuj(2, 4), TworzeniePostaciService.losuj(1, 4), TworzeniePostaciService.losuj(3, 5), TworzeniePostaciService.losuj(1, 4), TworzeniePostaciService.losuj(1, 4),
                TypPostaciEnum.ORK, 1, 1, TworzeniePostaciService.losuj(3, 6), ImmutableList.of(new Bron(2, 5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE)
                ), ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.HUM_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(2, 4), losuj(1, 4), losuj(3, 5), losuj(1, 4), losuj(1, 4), losuj(3, 6),