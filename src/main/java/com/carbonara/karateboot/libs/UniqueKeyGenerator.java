
package com.carbonara.karateboot.libs;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class UniqueKeyGenerator {
    private static final Date date = new Date();
    private static final String alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyyMMddHHmmss");
    
    //sample = LRZ20180124182405
    public static String getUniqueKey(){
        Random random = new Random();
        String newDateObject = formatter.format(date);
        String randomCharacters="";
        for (int i=0;i<3;i++)
        {
            randomCharacters += Character.toString(alphabet.charAt(random.nextInt(alphabet.length())));
        }
        return randomCharacters+newDateObject;
    }
}
