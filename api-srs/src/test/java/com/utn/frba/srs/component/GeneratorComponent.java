package com.utn.frba.srs.component;

import org.apache.commons.lang3.RandomUtils;

public class GeneratorComponent {

    public static String createDocument() {
        return String.valueOf(RandomUtils.nextLong(20394058746L, 29394058746L));
    }

    public static String createNameCompanySecurity() {
        return "CompanySecurity" + RandomUtils.nextLong(0L, 65455L);
    }

    public static String createNameCustoemr() {
        return "Customer" + RandomUtils.nextLong(0L, 65455L);
    }

    public static String createNameSubsidiary() {
        return "Subsidiary" + RandomUtils.nextLong(0L, 65455L);
    }

    public static String createNFCCheckpoint() {
        return String.valueOf(RandomUtils.nextLong(11111111L, 99999999L));
    }

    public static String createNameRound() {
        return "Round" + RandomUtils.nextLong(0L, 65455L);

    }

    public static String latitud() {
       return String.valueOf(RandomUtils.nextLong(11111111L, 99999999L));
    }

    public static String longitud() {
        return String.valueOf(RandomUtils.nextLong(11111111L, 99999999L));
    }
}
