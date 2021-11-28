package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class TwoWord implements InterpWord{
    private int hourGrinTimeOne = 0;
    private int hourGrinTimeTen = 0;
    private int numberMothGrinOne = 0;
    private int numberMothGrinTen = 0;

    String resultNumber = "";

    public int hourGrinTimeOne() {
        return hourGrinTimeOne;
    }

    public int hourGrinTimeTen() {
        return hourGrinTimeTen;
    }

    public int numberMothGrinOne() {
        return numberMothGrinOne;
    }

    public int numberMothGrinTen() {
        return numberMothGrinTen;
    }

    public String getResultNumber() {
        return resultNumber;
    }

    @Override
    public LinkedHashMap<String, String> wordAsMap(String str) {

        LinkedHashMap<String, String> result = new LinkedHashMap<>();

        Integer[] temp = forty(str);
        resultNumber = Integer.toBinaryString(temp[0]);

        hourGrinTimeOne = temp[1];
        hourGrinTimeTen = temp[2] ;
        numberMothGrinOne = temp[3];
        numberMothGrinTen = temp[4];

        result.put("Десятки  числа  гринвича", String.valueOf(numberMothGrinTen));
        result.put("Единицы числа  гринвича", String.valueOf(numberMothGrinOne));
        result.put("Десятки часа гринвича", String.valueOf(hourGrinTimeTen));
        result.put("Единицы часа гринвича", String.valueOf(hourGrinTimeOne));







        return result;
    }
}
