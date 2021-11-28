package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class FiveWord implements InterpWord{
    private int bitValidity = 0;
    private int bitFiveMinute = 0;
    private int bitOneMinute = 0;
    private int bitSec = 0;
    private int secGrinTimetHousand = 0;
    private int secGrinTimetHundredth = 0;
    private int secGrinTimetTen = 0;


    String resultNumber = "";

    public int bitValidity() {
        return bitValidity;
    }

    public int bitFiveMinute() {
        return bitFiveMinute;
    }

    public int bitOneMinute() {
        return bitOneMinute;
    }

    public int bitSec() {
        return bitSec;
    }

    public int secGrinTimetHousand() {
        return secGrinTimetHousand;
    }

    public int secGrinTimetHundredth() {
        return secGrinTimetHundredth;
    }

    public int secGrinTimetTen() {
        return secGrinTimetTen;
    }


    public String getResultNumber() {
        return resultNumber;
    }

    @Override
    public LinkedHashMap<String, String> wordAsMap(String str) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();
        Integer[] temp = forty(str);
        resultNumber = Integer.toBinaryString(temp[0]);


        secGrinTimetHousand = temp[2] ;
        secGrinTimetHundredth = temp[3];
        secGrinTimetTen = temp[4];


        bitValidity = temp[1]&1;
        bitFiveMinute = (temp[1]>>1)&1;
        bitOneMinute = (temp[1]>>2)&1;
        bitSec = (temp[1]>>3)&1;

        result.put("Десятые  доли секунды  гринвича", String.valueOf(secGrinTimetTen));
        result.put("Сотые доли секунды  гринвича", String.valueOf(secGrinTimetHundredth));
        result.put("Тысячные доли секунды  гринвича", String.valueOf(secGrinTimetHousand));
        result.put("Бит прихода секунды", String.valueOf(bitSec));
        result.put("Бит прихода минуты", String.valueOf(bitOneMinute));
        result.put("Бит прихода пяти минут", String.valueOf(bitFiveMinute));
        result.put("Бит достоверности", String.valueOf(bitValidity));

        return result;
    }
}
