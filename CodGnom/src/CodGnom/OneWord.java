package CodGnom;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.TreeMap;

public class OneWord implements InterpWord{
    private int mothYearOne = 0;
    private int mothYearTen = 0;
    private int yearCenturiesОne = 0;
    private int yearCenturiesTen = 0;


    String resultNumber = "";

    public int getMothYearOne() {
        return mothYearOne;
    }

    public int getMothYearTen() {
        return mothYearTen;
    }

    public int getYearCenturiesОne() {
        return yearCenturiesОne;
    }

    public int getYearCenturiesTen() {
        return yearCenturiesTen;
    }

    public String getResultNumber() {
        return resultNumber;
    }

    @Override
    public LinkedHashMap<String, String> wordAsMap(String str) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

           Integer[] temp = forty(str);
           resultNumber = Integer.toBinaryString(temp[0]);

           mothYearOne = temp[1];
           mothYearTen = temp[2] ;
           yearCenturiesОne = temp[3];
           yearCenturiesTen = temp[4];

        result.put("Десятки года столетия", String.valueOf(yearCenturiesTen));
        result.put("Единицы года столетия", String.valueOf(yearCenturiesОne));
        result.put("Десятки месяца года", String.valueOf(mothYearTen));
        result.put("Единицы месяца года", String.valueOf(mothYearOne));

        return result;
    }
}
