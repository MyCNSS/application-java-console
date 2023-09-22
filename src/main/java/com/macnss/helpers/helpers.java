package com.macnss.helpers;

import java.util.Random;

import static java.lang.String.format;

public class helpers {
    public static int generateCode(){
        Random rand = new Random();

        int code = rand.nextInt(999999);

        String codeString = format("%06d", code);

        return Integer.parseInt(codeString);
    }
}
