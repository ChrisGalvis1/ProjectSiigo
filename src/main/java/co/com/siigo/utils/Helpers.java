package co.com.siigo.utils;

import java.util.Random;

public class Helpers {

    public static int generarNumeroAleatorio() {
        Random randomNumber = new Random();
        return randomNumber.nextInt(9000) + 1000;
    }
}
