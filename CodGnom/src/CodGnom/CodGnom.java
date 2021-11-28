package CodGnom;

import java.io.FileNotFoundException;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Array;
import java.text.Format;
import java.util.*;

public class CodGnom {

    private Date currentDate = new Date();
    private String codDateTime = "";
    private String[] str;

    private int year = 0;
    private int month = 0;
    private int day = 0;
    private int hour = 0;
    private int min = 0;
    private int sec = 0;

    private int hourMoscow = 0;
    private int hourBell = 0;

    long grinTimeUnix = 0;

    ArrayList<InterpWord> listWordDo = new ArrayList<>();
    int [] massTime = new int [20];

    public String[] getStr() {
        return str;
    }

    private Interpreter myInterpretator = new Interpreter();

    public CodGnom(String codDateTime) {
        this.codDateTime = codDateTime;
        str = codDateTime.split("\\s");
      //  System.out.println(Arrays.toString(str));

    }

    int[] getMassTime(String [] str,ArrayList<InterpWord> listWordDo){


        return massTime;
    }


    public Date grinDateTime() {


        myInterpretator.setStr(str[0]);
        OneWord oneWord = new OneWord();
        myInterpretator.setCurrentWord(oneWord);
        myInterpretator.takeCodWord();
        year = oneWord.getYearCenturiesTen() * 10 + oneWord.getYearCenturiesОne();
        month = oneWord.getMothYearTen() * 10 + oneWord.getMothYearOne();
      //  System.out.println(year);

        myInterpretator.setStr(str[1]);
        TwoWord twoWord = new TwoWord();
        myInterpretator.setCurrentWord(twoWord);
        myInterpretator.takeCodWord();

        day = twoWord.numberMothGrinTen() * 10 + twoWord.numberMothGrinOne();
        hour = twoWord.hourGrinTimeTen() * 10 + twoWord.hourGrinTimeOne();

        myInterpretator.setStr(str[2]);
        TreeWord treeWord = new TreeWord();
        myInterpretator.setCurrentWord(treeWord);
        myInterpretator.takeCodWord();

        hourBell = treeWord.hourBelTimeTen() * 10 + treeWord.hourBelTimeOne();
        hourMoscow = treeWord.hourMoscowTimeTwo()* 10 + treeWord.hourMoscowTimeOne();


        myInterpretator.setStr(str[3]);
        FourWord fourWord = new FourWord();
        myInterpretator.setCurrentWord(fourWord);
        myInterpretator.takeCodWord();

        min = fourWord.minGrinTimeTen() * 10 + fourWord.minGrinTimeOne();
        sec = fourWord.secGrinTimeTen() * 10 + fourWord.secGrinTimeOne();


        currentDate.setYear(year + 100);
        currentDate.setMonth(month - 1);
        currentDate.setDate(day);
        currentDate.setHours(hour);
        currentDate.setMinutes(min);
        currentDate.setSeconds(sec);

        grinTimeUnix = currentDate.getTime();

        return currentDate;
    }


    public Date bilDateTime() {
        grinDateTime();
        long bilTimeUnix = 0;

        bilTimeUnix = timeAndDateBell(hourBell);
        currentDate.setTime(bilTimeUnix);

        return currentDate;
    }

    public Date MoscowTime() {
        grinDateTime();
        long bilTimeUnix = 0;

        bilTimeUnix = timeAndDateBell(hourMoscow);
        currentDate.setTime(bilTimeUnix);

        return currentDate;


    }

    public int partySecond() {
        int doly = 0;
        FiveWord fiveWord = new FiveWord();
        setFiveWord(fiveWord);
        doly = fiveWord.secGrinTimetTen()*100   + fiveWord.secGrinTimetHundredth()*10 + fiveWord.secGrinTimetHousand() ;
        return doly;

    }
   //------------нутрение функции вспомогательныe
    private void setFiveWord(FiveWord fiveWord) {
        myInterpretator.setStr(str[4]);
        myInterpretator.setCurrentWord(fiveWord);
        myInterpretator.takeCodWord();
    }

    private long timeAndDateBell (int bilHour ){
       // Date grinDateTime =  grinDateTime();
       // long grinTimeUnix = grinDateTime.getTime();
       // int  bilCurrent = bilHour - grinDateTime.getHours();
        int  bilCurrent = bilHour - hour;
        //  System.out.println(bilCurrent);
        if(bilCurrent <= -12){
            bilCurrent = bilCurrent + 24;}
        else if(bilCurrent >12)
        { bilCurrent = bilCurrent - 24;}

        //   System.out.println(bilCurrent);
        return  grinTimeUnix + (bilCurrent * 60 * 60*1000);
    }
//-------------------------------------------------------
    public int bitOnesec() {

        FiveWord fiveWord = new FiveWord();
        setFiveWord(fiveWord);
        return fiveWord.bitSec();
    }

    public int bitOneminute() {
        FiveWord fiveWord = new FiveWord();
        setFiveWord(fiveWord);
        return fiveWord.bitOneMinute();
    }

    public int bitFiveMinuts() {
        FiveWord fiveWord = new FiveWord();
        setFiveWord(fiveWord);
        return fiveWord.bitFiveMinute();
    }

    public int bitValidy() {
        FiveWord fiveWord = new FiveWord();
        setFiveWord(fiveWord);
        return fiveWord.bitValidity();
    }
    public LinkedHashMap<String, String>  allMApDate(){
        LinkedHashMap<String, String> allMap = new LinkedHashMap<>();
        Interpreter test = new Interpreter();
        test.setStr(str[0]);
        test.setCurrentWord(new OneWord());
        allMap = test.takeCodWord();
        test.setStr(str[1]);
        test.setCurrentWord(new TwoWord());
        allMap.putAll(test.takeCodWord());
        test.setStr(str[2]);
        test.setCurrentWord(new TreeWord());
        allMap.putAll(test.takeCodWord());
        test.setStr(str[3]);
        test.setCurrentWord(new FourWord());
        allMap.putAll(test.takeCodWord());
        test.setStr(str[4]);
        test.setCurrentWord(new FiveWord());
        allMap.putAll(test.takeCodWord());

       return allMap;

    }


    public  String[] printTimeGnom()  {
        String [] str = new String[7];
           str[0] = " строка данных кода \n" + codDateTime ;
       // StringBuilder stringBuilder =  new StringBuilder();
       // Formatter formatter =  new Formatter(" строка данных кода \n%s\n",codDateTime);
       // System.out.println(formatter);
      //  System.out.printf(" строка данных кода \n%s\n",codDateTime);
       // str = new StringBuilder (" строка данных кода \n%s\n",codDateTime);

       // System.out.println(grinDateTime().toString().replaceAll("GMT.{7}", "") + "  гринвич " +" доли секунды " + partySecond());
        str [1]= grinDateTime().toLocaleString() /* grinDateTime().toString().replaceAll("VLAT", "")*/ + "  гринвич " +" доли секунды " + partySecond();
       // System.out.println(bilDateTime().toString().replaceAll("GMT.{7}", "") + "  пояс  " +"   доли секунды " + partySecond());
        str [2]= bilDateTime().toLocaleString()/*bilDateTime().toString().replaceAll("GMT.{7}", "")*/ + "  пояс  " +"   доли секунды " + partySecond();
        //System.out.println(MoscowTime().toString().replaceAll("GMT.{7}", "") + "  москва " +"  доли секунды " + partySecond());
        str[3] = MoscowTime().toLocaleString() /*MoscowTime().toString().replaceAll("GMT.{7}", "")*/ + "  москва " +"  доли секунды " + partySecond();
        //System.out.println("бит секунды " + bitOnesec() + " \tбит минуты " + bitOneminute() + " \tбит 5 минут "+ bitFiveMinuts());
        str[4] =  "бит секунды " + bitOnesec() + " \tбит минуты " + bitOneminute() + " \tбит 5 минут "+ bitFiveMinuts();
       // System.out.println("бит достоверности " + bitValidy());
        str[5] = "бит достоверности " + bitValidy();
       // System.out.println("----------------");
        str[6] =  "\n"+  "----------------";
        return str;

    }
    //2102 1705 0815 1924 9331 0003
    //2102 1705 0815 1924 9361 0003

}
