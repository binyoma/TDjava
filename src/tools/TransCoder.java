package tools;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;


public class TransCoder {
    private  String key;


    public TransCoder(String key) {

        this.key = key;
    }
    public ArrayList generateKey(){
        String alphabet="ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String key="CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
        String code="";
        if(key == null){
            String characters="CFfrkowl.aDzyS:eHjsGPZgMApWvRYVmtnK!BuU IQiEXTxbqhLdNJO,'c";
            List<Character> keyTab = new ArrayList<Character>();
            for(char c:characters.toCharArray()){
                keyTab.add(c);
            }
            StringBuilder output = new StringBuilder(characters.length());
            while(keyTab.size()!=0){
                int randPicker = (int)(Math.random()*keyTab.size());
                output.append(keyTab.remove(randPicker));
            }
            key =output.toString();
        }

        //loop to find two letter to encode each letter of the key
        for (int i = 0; i < key.length(); i++){
            //first letter
            code+=alphabet.charAt(i/26);
            //second
            code+=alphabet.charAt(((26*(i/26))-i)*(-1));
        }
        ArrayList keyAndKeyEncoded=new ArrayList<String>();
        keyAndKeyEncoded.add(key);
        keyAndKeyEncoded.add(code);
        return keyAndKeyEncoded;
    }

    public HashMap getEncode(){
        // get key decoded and key encoded
        ArrayList list=generateKey();
        String key =list.get(0).toString();
        String code =list.get(1).toString();

        //Hashmap key/value
        HashMap<Character,String> encode =new HashMap<Character, String>();
        for (int keyChar = 0; keyChar < key.length(); keyChar++){
            encode.put(key.charAt(keyChar),code.substring(keyChar*2, (keyChar*2)+2));
        }

         return encode;
    }

    public HashMap getDecode(){

        // get key decoded et key encoded
        ArrayList list=generateKey();
        String key =list.get(0).toString();
        String code =list.get(1).toString();

        HashMap<String,Character> decode =new HashMap<String,Character>();
        for (int keyChar = 0; keyChar < (code.length()-1); keyChar++){

            if ((keyChar % 2) ==0 ){
                decode.put(code.substring(keyChar, keyChar+2),key.charAt(keyChar/2));
            }

        }

        return decode;
    }



    public String encode(String msg){
        HashMap encode= getEncode();
        String msgCode ="";

        for(int i =0; i < msg.length(); i++) {

            char ch = msg.charAt(i);

            msgCode += encode.get(ch);

        }
        return msgCode;
    }

    public String decode(String msg){

        HashMap decode = getDecode();
        String msgDecode ="";


        for(int i =0; i < (msg.length()-1); i+=2) {
            if ((i %2) ==0){
                String ch = msg.substring(i,i+2);
                msgDecode += decode.get(ch);
            }
        }
        return  msgDecode;
    }

}
