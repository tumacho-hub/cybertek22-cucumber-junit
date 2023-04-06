package com.cybertek.utilities;

public class OfficeHoursUtils {

    public static double priceConverter(String price){

        String temp = "";
        for (int i = 0; i < price.length(); i++){
            if (Character.isDigit(price.charAt(i))){
                temp += "" + price.charAt(i);
                }
            if (price.charAt(i) == '.'){
                temp += price.charAt(i);
            }
        }
        return Double.parseDouble(temp);

    }
}
