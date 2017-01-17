package com.javarush.test.level19.lesson05.task04;

/* Замена знаков
Считать с консоли 2 имени файла.
Первый Файл содержит текст.
Заменить все точки "." на знак "!", вывести во второй файл.
Закрыть потоки. Не использовать try-with-resources
*/

import java.io.*;

public class Solution {
    static char currentChar = ' ';
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        FileReader reader = new FileReader(br.readLine());
        FileWriter writer = new FileWriter(br.readLine());


        String text = "";
        while (reader.ready())
        {
            currentChar = (char) reader.read();

            text = text + currentChar;

        }
                String str = text.replaceAll("\\.", "!");
        writer.write(str);

br.close();
        reader.close();
        writer.close();
    }}
