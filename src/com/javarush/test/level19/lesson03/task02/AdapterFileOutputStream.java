package com.javarush.test.level19.lesson03.task02;

/* Адаптер
Используйте класс AdapterFileOutputStream, чтобы адаптировать FileOutputStream к новому интерфейсу AmigoStringWriter
*/

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AdapterFileOutputStream implements AmigoStringWriter {

        private FileOutputStream stream;
    public AdapterFileOutputStream(FileOutputStream fileName) throws FileNotFoundException
    {
        this.stream = new FileOutputStream(String.valueOf(fileName));
    }

    @Override
    public void flush() throws IOException
    {
       this.stream.flush();
    }

    @Override
    public void writeString(String s) throws IOException
    {
        byte[] arr = s.getBytes("ASCII");
        this.stream.write(arr);
    }

    @Override
    public void close() throws IOException
    {
            this.stream.close();
    }
}


