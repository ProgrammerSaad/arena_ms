package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.*;
import com.example.arena.service.TworzeniePostaciService;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableSet;

/**
 * Created by Saad on 2018-03-02.
 */
public class Niedźwiedź extends Zwierzę {

    public Niedźwiedź() {
        super(TworzeniePostaciService.losuj(3, 5), TworzeniePostaciService.losuj(1, 3), TworzeniePostaciService.losuj(3, 7), TworzeniePostaciService.losuj(2, 3), TworzeniePostaciService.losuj(1, 3),
                TypPostaciEnum.NIEDŹWIEDŹ, 1, 1, TworzeniePostaciService.losuj(4, 8), ImmutableList.of(new Bron(1, 3, BronEnum.PAZURY, TypyBroniEnum.ZWIERZECA, RodzajAtakuEnum.UDERZENIE)),
                ImmutableList.of(new Pancerz(1, PancerzEnum.HELM, TypPancerzaEnum.ZWIERZECY_PANCERZ, ImmutableSet.of(CzesciCialaEnum.GLOWA))));
    }
}

//losuj(3, 5), losuj(1, 3), losuj(3, 7), losuj(2, 3), losuj(1, 3), losuj(4, 8),