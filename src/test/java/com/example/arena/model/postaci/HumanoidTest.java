package com.example.arena.model.postaci;

import com.example.arena.service.TworzeniePostaciService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Saad on 2018-03-17.
 */
public class HumanoidTest {

    /*@Test
    public void funkcjaSprawdzaUstawienieBroniHumanoida() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        Istota postac = tps.generujListeNowychPostaci(1).get(0);
        TypyBroniEnum[] tablicaTypowBroni = TypyBroniEnum.values();
        List<TypyBroniEnum> typyBroni = Arrays.asList(tablicaTypowBroni);
        //when
        postac.ustawBron(TypyBroniEnum.LUK);
        //then
        Assert.assertNotNull(postac.getTypBroniEnum());
        Assert.assertTrue(typyBroni.contains(postac.getTypBroniEnum()));
    }
*/
    /*@Test
    public void funkcjaSprawdzaUstawienieBroniHumanoida() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        Istota postac = tps.generujListeNowychPostaci(1).get(0);
        Bron bron = new Bron(2,5, BronEnum.MIECZ, TypyBroniEnum.HUM_BIALA_JEDNORECZNA, RodzajAtakuEnum.UDERZENIE);
        List typyBroni = Arrays.asList(BronEnum.values());
        //when
        postac.ustawBron(bron.getBronEnum());
        //then
        Assert.assertNotNull(postac.getBron());
        Assert.assertTrue(typyBroni.contains(postac.getBron().getBronEnum()));
    }*/

    @Test
    @Ignore
    public void funkcjaSprawdzaPoprawnoscFunkcjiUderz() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        Istota ofiara = tps.generujListeNowychPostaci(1).get(0);
        Czlowiek atakujacy = (Czlowiek) tps.generujListeNowychPostaci(1).get(0);
        CzesciCialaEnum[] tablicaCiala = CzesciCialaEnum.values();
        List<CzesciCialaEnum> listaCzesciCiala = Arrays.asList(tablicaCiala);
        //when
        WynikUderzenia wu = atakujacy.uderz(ofiara);
        //then
        Assert.assertTrue(wu.getSumaObrazen() > 0);
        Assert.assertTrue(listaCzesciCiala.contains(wu.getMiejsceTrafienia()));
        //Mockito - zwinność
    }

    @Test
    public void funkcjaSprawdzaPoprawnoscFunkcjiAtak() {
        //given
        TworzeniePostaciService tps = new TworzeniePostaciService();
        WynikUderzenia wu = new WynikUderzenia(0, null);
        CzesciCialaEnum[] tablicaCzesciCiala = CzesciCialaEnum.values();
        List<CzesciCialaEnum> czesciCiala = Arrays.asList(tablicaCzesciCiala);
        Istota atakujacy = tps.generujListeNowychPostaci(1).get(0);
        Istota ofiara = tps.generujListeNowychPostaci(1).get(0);
        //when
        atakujacy.atak(ofiara);
        //then
        Assert.assertFalse(ofiara.getId() == atakujacy.getId());
        Assert.assertTrue(czesciCiala.contains(ofiara.trafioneMiejsce()));
        Assert.assertFalse(wu.getSumaObrazen() > 0);
    }

}
