package com.javarush.test.level19.lesson10.home02;

/* Самый богатый
В метод main первым параметром приходит имя файла.
В этом файле каждая строка имеет следующий вид:
имя значение
где [имя] - String, [значение] - double. [имя] и [значение] разделены пробелом

Для каждого имени посчитать сумму всех его значений
Вывести в консоль имена, у которых максимальная сумма
Имена разделять пробелом либо выводить с новой строки
Закрыть потоки. Не использовать try-with-resources

Пример входного файла:
Петров 0.501
Иванов 1.35
Петров 0.85

Пример вывода:
Петров
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException
    {
        String s;
        FileReader fileReader = new FileReader(args[0]);
        Map<String, Double> map = new TreeMap<String, Double>();


        BufferedReader reader = new BufferedReader(fileReader);

        while (!((s = reader.readLine()) == null))
        {
            String[] line = s.split(" ");
            double num = Double.parseDouble(line[1]);

            if(!(map.containsKey(line[0]))){
                map.put(line[0], num);}

            else
            {
                double n =map.get(line[0]);

                map.put(line[0], num+n);

            }

        }
        reader.close();
        fileReader.close();

       Double value;
        Double max = Double.MIN_VALUE;
        for (String sd : map.keySet()) {
            value = map.get(sd);
            if (value > max) {
                max = value;
            }
        }
            for (String s1 : map.keySet()) {
                value = map.get(s1);

                if (value == max) {
                    System.out.println(s1);
                }
            }
        }


    }

