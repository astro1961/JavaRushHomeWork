package com.javarush.test.level19.lesson10.home05;

/* Слова с цифрами
В метод main первым параметром приходит имя файла1, вторым - файла2.
Файл1 содержит строки со слов, разделенные пробелом.
Записать через пробел в Файл2 все слова, которые содержат цифры, например, а1 или abc3d
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;
import java.util.ArrayList;
import java.util.regex.*;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        ArrayList<String>numStrings = new ArrayList<>();

        String fileName_1 = args[0];
        String fileName_2 = args[1];
        FileReader fr = new FileReader(fileName_1);
        BufferedReader reader = new BufferedReader(fr);
        FileWriter fileWriter = new FileWriter(fileName_2);
        String s;
        while(reader.ready()){
            String[] str=reader.readLine().split(" ");
            for(String word:str){

                if(word.matches(".+[0-9].+")){
                    numStrings.add(word);
                }

            }
        }
        reader.close();
        fr.close();
        for(String word:numStrings){
            fileWriter.write(word + " ");
        }
        fileWriter.close();

    }
}
