package CodGnom;

import java.awt.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

public class Analiz {
    public static void main(String[] args)  {
        String str = "";
        String fileName = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = null;
        BufferedWriter writerAnswer = null;
        BufferedReader bufferedReader =  null;
        try {
            writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\1\\CodGnom.txt"), "windows-1251"));
            writerAnswer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("c:\\1\\CodGnomAnswer.txt"), "windows-1251"));
        }
        catch (Exception e){
            System.out.println("Что то не так с выходным файлом");
        }
       while (true) {
           while (true) {
               try {
                   System.out.println("Введите путь к файлу  с логами в формате txt");
                   fileName = reader.readLine();
                   break;
               } catch (Exception e) {
                   System.out.println("Введите имя снова");
               }
           }
           try {
                bufferedReader = new BufferedReader(new FileReader(fileName));


               while (bufferedReader.ready()) {
                   str = bufferedReader.readLine();
                   if(str.matches("\\s*CMD:\\s(?!FAA6).*")){
                       for (int i = 0; i < 3; i++) {
                           writerAnswer.write(str);
                           writerAnswer.newLine();
                           str = bufferedReader.readLine();
                       }
                           writerAnswer.write("----------------------------");
                           writerAnswer.newLine();

                                   }

                   if (str.matches("\\s*DAT: \\w{4}\\s\\w{4}\\s\\w{4}\\s\\w{4}\\s\\w{4}\\s\\w{4}"))
                   {


                   str = str.replaceAll("     DAT: ", "");
                   //

                   CodGnom gnom = new CodGnom(str);
                   for (String element: gnom.printTimeGnom()
                   ) {
                       writer.write(element);
                       writer.newLine();
                   }

                   if (gnom.bitValidy() == 1) {

                       for (String element: gnom.printTimeGnom()
                            ) {
                           System.out.println(element);
                       }


                   }
                   }
                  // ByteArrayOutputStream buffer = new ByteArrayOutputStream();

                   // После этой строки любой вывод будет сохраняться в buffer

                   //System.setOut(new PrintStream(System.out));




                   //  System.out.println(gnom.bilDateTime() + "  пояс  " + gnom.partySecond());
                   //  System.out.println(gnom.MoscowTime() + "  москва " + gnom.partySecond());
                   //  System.out.println(gnom.bitValidy());

               }
               bufferedReader.close();
               writer.close();
               writerAnswer.close();
               System.out.println("Файл создан");
               break;
           }
           catch (Exception e) {
               System.out.println("Что то пошло не так попробуйте заного");

           }
//           try{
//           bufferedReader.close();
//           writer.close();
//           }
//           catch (Exception e){
//               System.out.println("Файл не закрылся");
//           }

       }


        //   System.out.println(" "+ gnom.bitOnesec() + " " +gnom.bitOneminute() + " "+gnom.bitFiveMinuts() +" "+ gnom.bitValidy());
//        Interpreter test = new Interpreter();
//        test.setStr("2102");
//        test.setCurrentWord(new OneWord());
//        System.out.println(test.takeCodWord());
//        test.setStr("1705");
//        test.setCurrentWord(new TwoWord());
//        System.out.println(test.takeCodWord());
//        test.setStr("0815");
//        test.setCurrentWord(new TreeWord());
//        System.out.println(test.takeCodWord());
//        test.setStr("1924");
//        test.setCurrentWord(new FourWord());
//        System.out.println(test.takeCodWord());
//        test.setStr("9331");
//        test.setCurrentWord(new FiveWord());
//        System.out.println(test.takeCodWord());
//
//
//
        //   System.out.println(gnom.allMApDate());
        System.out.printf("my cange");

    }
}
