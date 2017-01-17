package com.javarush.test.level19.lesson05.task03;

/* Выделяем числа
Считать с консоли 2 имени файла.
Вывести во второй файл все числа, которые есть в первом файле.
Числа выводить через пробел.
Закрыть потоки. Не использовать try-with-resources

Пример тела файла:
12 text var2 14 8v 1

Результат:
12 14 1
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    static char currentChar = ' ';
    public static boolean test(String testString){
        if (testString == null) return false;
        Pattern p = Pattern.compile("^-?\\d+$");
        Matcher m = p.matcher(testString);
        return m.matches();
    }
    public static void main(String[] args) throws IOException
    {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fReader = new FileReader(reader.readLine());
        FileWriter fWriter = new FileWriter(reader.readLine());


        System.out.println("работает");
        String text = "";
while(fReader.ready()){
    currentChar = (char)fReader.read();
    System.out.println(currentChar);
    text = text+currentChar;
}
        String replacedString = text.replaceAll("\\p{P}"," ").toLowerCase();
        replacedString=replacedString.replaceAll("\\s"," ");

        String splitString[] = replacedString.split(" ");
        for (String x : splitString) {
            System.out.println(x);
            System.out.println(test(x));
if(test(x)){
    System.out.println("write");
    fWriter.write(x + " ");
}
        }




        fReader.close();
        fWriter.close();
        reader.close();

    }
}
