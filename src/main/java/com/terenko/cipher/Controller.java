package com.terenko.cipher;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {
    final String sh="abcdefghijklmnopqrstuvwxyz";
    @RequestMapping(value = "/encrypt", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public file encrypt(@RequestParam String plain,int a,int b){
        try {
            if(!(gcd(a,26)==1))throw new illegalKeyException();
            if (!(a >= 0 && a <= 25))throw new illegalKeyException();
            if (!(b >= 0 && b <= 25)) throw new illegalKeyException();
            for(int i=0;i<plain.length();i++){
                if(!sh.contains(plain.substring(i,i+1)))throw new illegalCharException();
            }
            return new file(Ciphert.encryption(plain,a,b));

        } catch (Exception e) {
            return  new file(e.getMessage());
        }
    }
    @RequestMapping(value = "/decrypt", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public file decrypt(@RequestParam String plain,int a,int b){
        try {

            if(!(gcd(a,26)==1))throw new illegalKeyException();
            if (!(a >= 0 && a <= 25))throw new illegalKeyException();
            if (!(b >= 0 && b <= 25)) throw new illegalKeyException();
            for(int i=0;i<plain.length();i++){
                if(!sh.contains(plain.substring(i,i+1)))throw new illegalCharException();
            }
            return  new file(Ciphert.dencryption(plain,a,b));

        } catch (Exception e) {
            return  new file( e.getMessage());
        }
    }
    private static int gcd(int a, int b) {
        int t;
        while(b != 0){
            t = a;
            a = b;
            b = t%b;
        }
        return a;
    }
}
