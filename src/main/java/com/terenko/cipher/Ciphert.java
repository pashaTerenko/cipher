package com.terenko.cipher;


import org.springframework.stereotype.Component;

import java.util.ArrayList;
@Component
public class Ciphert {
    public static String encryption(String plain, int a, int b) {

        String sh="abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> shA=new ArrayList<>();
        for (int i=0;i<sh.length();i++){
            shA.add(sh.substring(i,i+1));
        }
        ArrayList<String> plainA=new ArrayList<>();
        for (int i=0;i<plain.length();i++){

            plainA.add(plain.substring(i,i+1));
        }
        ArrayList<Integer> kod=new ArrayList<>();
        for (String s:plainA){
            kod.add(((a*shA.indexOf(s))+b)%26);
        }
        ArrayList<String> cryptedText=new ArrayList<>();
        for (int i:kod){
            cryptedText.add(shA.get(i));
        }
        String res="";
        for(String s:cryptedText){
            res=res+s;
        }
        return res;
    }
    public static String dencryption(String plain, int a, int b) {
        if (a >= 0 && a <= 26) {
        } else return null;
        String sh="abcdefghijklmnopqrstuvwxyz";
        ArrayList<String> shA=new ArrayList<>();
        for (int i=0;i<sh.length();i++){
            shA.add(sh.substring(i,i+1));
        }
        ArrayList<String> plainA=new ArrayList<>();
        for (int i=0;i<plain.length();i++){
            plainA.add(plain.substring(i,i+1));
        }
        int n=1;
        int count=1;
        while (true){
            if(a*n>26*count){
                if(a*n==(26*count)+1)
                    break;
                count++;

            }
            n++;
        }
        ArrayList<Integer> kod=new ArrayList<>();
        for (String s:plainA){
            kod.add(n*(shA.indexOf(s)-b)%26<0?n*(shA.indexOf(s)-b)%26+26:n*(shA.indexOf(s)-b)%26);
        }
        ArrayList<String> cryptedText=new ArrayList<>();
        for (int i:kod){
            cryptedText.add(shA.get(i));
        }
        String res="";
        for(String s:cryptedText){
            res+=s;
        }
        return res;
    }
}
