package com.example.arena.model.wyposazenie;

import com.example.arena.model.postaci.RodzajAtakuEnum;

public class Bron {

    private int obrazeniaMin;

    private int obrazeniaMax;

    private BronEnum nazwaBroni;

    private TypyBroniEnum typBroni;

    private RodzajAtakuEnum rodzajAtaku;

    public Bron(int obrazeniaMin, int obrazeniaMax, BronEnum nazwaBroni, TypyBroniEnum typBroni, RodzajAtakuEnum rodzajAtaku) {
        this.obrazeniaMin = obrazeniaMin;
        this.obrazeniaMax = obrazeniaMax;
        this.nazwaBroni = nazwaBroni;
        this.typBroni = typBroni;
        this.rodzajAtaku = rodzajAtaku;
    }

    public int getObrazeniaMin() {
        return obrazeniaMin;
    }

    public int getObrazeniaMax() {
        return obrazeniaMax;
    }

    public BronEnum getBronEnum() {
        return nazwaBroni;
    }

    public TypyBroniEnum getTypBroni() {
        return typBroni;
    }

    public RodzajAtakuEnum getRodzajAtaku() {
        return rodzajAtaku;
    }

    /*PIESC(0, 2), //KAŻDY HUMANOID
    MIECZ(2, 5), //CZŁOWIEK
    LUK(2, 5), //ELF
    KUSZA(3, 6), //HALFING
    TOPOR(2, 5), //KRASNOLUD
    MACZUGA(2, 5), //ORK
    MŁOT(3, 5), //TROLL
    ZĘBY(0, 3), //KAŻDE ZWIERZĘ
    TYTANOWASZCZĘKA(2, 4), //NIEDŹWIEDŹ
    PAZURY(1, 3), //PIES
    SZABLOZĘBY(3, 6), //TYGRYS
    ŁUK_LONG_BATTLE_BOW(4, 7), //SPECJALNE
    MACZUGA_WAR_HAMMER(3, 6),
    MIECZ_BLADE(3, 6),
    TOPÓR_AXE(3, 6),
    OGNISTA_KULA(4, 9),
    PAZUUR_MAMUTA(4, 7);
*/

}
