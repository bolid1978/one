package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public interface InterpWord {

    LinkedHashMap<String,String> wordAsMap  (String str);

    default Integer [] forty(String str){
        int num = 0;
        Integer[] myMass  = new Integer[10];
        try{
            num = Integer.parseInt(str, 16);
        }

        catch (NumberFormatException ex){
            System.out.println("Нельзя преобразовать в хекс");
            return null;
        }

        myMass[0] = num;
        myMass[1] = num&15;
        myMass[2] = (num>>4)&15;
        myMass[3] = (num>>8)&15;
        myMass[4] = (num>>12)&15;

        return myMass;
    }
}
