package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class FourWord implements  InterpWord {
    private int secGrinTimeOne = 0;
    private int secGrinTimeTen = 0;
    private int minGrinTimeOne = 0;
    private int minGrinTimeTen = 0;

    String resultNumber = "";

    public int secGrinTimeOne() {
        return secGrinTimeOne;
    }

    public int secGrinTimeTen() {
        return secGrinTimeTen;
    }

    public int minGrinTimeOne() {
        return minGrinTimeOne;
    }

    public int minGrinTimeTen() {
        return minGrinTimeTen;
    }

    public String getResultNumber() {
        return resultNumber;
    }

    @Override
    public LinkedHashMap<String, String> wordAsMap(String str) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        Integer[] temp = forty(str);
        resultNumber = Integer.toBinaryString(temp[0]);

        secGrinTimeOne = temp[1];
        secGrinTimeTen = temp[2] ;
        minGrinTimeOne = temp[3];
        minGrinTimeTen = temp[4];

        result.put("Десятки  митнут  гринвича", String.valueOf(minGrinTimeTen));
        result.put("Единицы минту  гринвича", String.valueOf(minGrinTimeOne));
        result.put("Десятки секунд гринвича", String.valueOf(secGrinTimeTen));
        result.put("Единицы секунд гринвича", String.valueOf(secGrinTimeOne));

        return result;
    }
}