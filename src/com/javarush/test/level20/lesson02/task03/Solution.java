package com.javarush.test.level20.lesson02.task03;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* Знакомство с properties
В методе fillInPropertiesMap считайте имя файла с консоли и заполните карту properties данными из файла.
Про .properties почитать тут - http://ru.wikipedia.org/wiki/.properties
Реализуйте логику записи в файл и чтения из файла для карты properties.
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();
String fileName;
    public void fillInPropertiesMap() throws Exception
    {
BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        properties.put("agility","low");
        properties.put("strong","big");
        properties.put("perception","high");
        properties.put("speed","high");
        OutputStream outputStream = new OutputStream(fileName);
        InputStream fileProperties = new FileInputStream(reader.readLine());
            save(fileProperties);
            load(fileProperties);
        reader.close();




        //implement this method - реализуйте этот метод
    }

    public void save(OutputStream outputStream) throws Exception {
        PrintWriter printWriter = new PrintWriter(outputStream);
        for( Map.Entry<String, String> entry : properties.entrySet() ){

            printWriter.println(entry.getKey()+" "+ entry.getValue());
        }
        printWriter.close();
        //implement this method - реализуйте этот метод
    }

    public void load(InputStream inputStream) throws Exception {
        BufferedReader fileReader = new BufferedReader(inputStream));
        String[] str = new String[2];
       while(fileReader.ready())
       {
           str = fileReader.readLine().split(" ");
           properties.put(str[0], str[1]);
       }
        fileReader.close();
        //implement this method - реализуйте этот метод
    }

    public static void main(String[] args) throws Exception
    {

        Solution solution = new Solution();
        solution.fillInPropertiesMap();


    }
}
