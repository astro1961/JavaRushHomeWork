package com.javarush.test.level18.lesson03.task04;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

/* Самые редкие байты
Ввести с консоли имя файла
Найти байт или байты с минимальным количеством повторов
Вывести их на экран через пробел
Закрыть поток ввода-вывода
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        FileInputStream fileInputStream = new FileInputStream(reader.readLine());

        while (fileInputStream.available() > 0){
            int data = fileInputStream.read();
            if (map.containsKey(data)){
                map.put(data, (map.get(data)) + 1);
            } else {
                map.put(data, 1);
            }
        }
        fileInputStream.close();

        int min = Integer.MAX_VALUE;
        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            Integer value = pair.getValue();
            if (value < min) min = value;
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()){
            if (pair.getValue() == min){
                System.out.print(pair.getKey() + " ");
            }
        }
    }
}

