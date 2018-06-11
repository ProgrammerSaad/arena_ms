package com.example.arena.model.postaci;

import com.example.arena.model.wyposazenie.Bron;
import com.example.arena.model.wyposazenie.BronEnum;
import com.example.arena.model.wyposazenie.TypyBroniEnum;
import com.example.arena.service.TworzeniePostaciService;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Saad on 2018-03-17.
 */
public class IstotaTest {

    @Test
    public void funkcjaSprawdzaPoprawnoscFunkcjiAtakPrzeciwnika() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WynikUderzenia wu = new WynikUderzenia(0, CzesciCialaEnum.NOGA_LEWA);
        Istota atakujacy = new Czlowiek();
        Istota ofiara = tps.generujListeNowychPostaci(1).get(0);
        //when
        atakujacy.atakPrzeciwnika(ofiara, new Bron(0, 2, BronEnum.PIESC, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE));
        //then
        Assert.assertTrue(wu.getSumaObrazen() == 0);
    }

    @Test
    public void funkcjaSprawdzaPoprawnoscResetuAtakowIUnikow() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        Istota postac = tps.generujListeNowychPostaci(1).get(0);
        //when
        postac.resetAtakowUnikow();
        //then
        Assert.assertNotNull(postac.getIloscAtakow());
        Assert.assertNotNull(postac.getIloscUnikow());
        Assert.assertTrue(postac.getIloscUnikow() > 0);
        Assert.assertTrue(postac.getIloscAtakow() > 0);
    }

    @Test
    public void funkcjaSprawdzaPoprawnoscFunkcjiUnik() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WynikUderzenia wu = new WynikUderzenia(4, CzesciCialaEnum.GLOWA);
        Istota atakujaca = tps.generujListeNowychPostaci(1).get(0);
        Istota ofiara = tps.generujListeNowychPostaci(1).get(0);
        //when
        ofiara.unik(atakujaca, wu);
        //then
        Assert.assertFalse(ofiara.getId() == atakujaca.getId());
        Assert.assertTrue(ofiara.getIloscUnikow() == 0);
        Assert.assertTrue(ofiara.getInicjatywa() > 0);
    }

    @Test
    public void funkcjaSprawdzaPoprawnoscFunkcjiJakiLevel() {
        //given
        Istota atakujacy = new Czlowiek();
        LevelEnum oczekiwanyLevel = LevelEnum.LEVEL5;
        //when
        atakujacy.ustawDoswiadczenie(3000);
        //then
        Assert.assertTrue(atakujacy.getLevelPostaci() == oczekiwanyLevel);
    }
}