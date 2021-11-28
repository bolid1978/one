package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TreeWord implements InterpWord{
    private int hourBelTimeOne = 0;
    private int hourBelTimeTen = 0;
    private int hourMoscowTimeOne = 0;
    private int hourMoscowTimeTwo = 0;



    String resultNumber = "";

    public int hourBelTimeOne() {
        return hourBelTimeOne;
    }

    public int hourBelTimeTen() {
        return hourBelTimeTen;
    }

    public int hourMoscowTimeOne() {
        return hourMoscowTimeOne;
    }

    public int hourMoscowTimeTwo() {
        return hourMoscowTimeTwo;
    }

    public String getResultNumber() {
        return resultNumber;
    }

    @Override
    public LinkedHashMap<String, String> wordAsMap(String str) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        Integer[] temp = forty(str);
        resultNumber = Integer.toBinaryString(temp[0]);

        hourBelTimeOne = temp[1];
        hourBelTimeTen = temp[2] ;
        hourMoscowTimeOne = temp[3];
        hourMoscowTimeTwo = temp[4];

        result.put("Десятки  часа  Москвы", String.valueOf(hourMoscowTimeTwo));
        result.put("Единицы часа  Москвы", String.valueOf(hourMoscowTimeOne));
        result.put("Десятки часа  пояса", String.valueOf(hourBelTimeTen));
        result.put("Единицы часа пояса", String.valueOf(hourBelTimeOne));


       return result;
    }
}
