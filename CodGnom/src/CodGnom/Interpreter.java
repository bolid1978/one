package CodGnom;

import java.util.LinkedHashMap;
import java.util.TreeMap;

public class Interpreter {
    private String str ="";
    private InterpWord currentWord;
    private LinkedHashMap<String,String> resultMap = new LinkedHashMap<>();

    public Interpreter() {
    }

    Interpreter(String str) {
        this.str = str;
    }

    public String getStr() {
        return str;
    }

    public void setStr(String str) {
        this.str = str;
    }


    public void setCurrentWord(InterpWord currentWord){
        this.currentWord = currentWord;
    }

    public LinkedHashMap<String,String> takeCodWord(){
         resultMap = currentWord.wordAsMap(str);
         return resultMap;
    }


}
