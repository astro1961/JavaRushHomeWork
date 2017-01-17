package com.javarush.test.level20.lesson02.task02;

import java.io.*;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* Читаем и пишем в файл: JavaRush
Реализуйте логику записи в файл и чтения из файла для класса JavaRush
В файле your_file_name.tmp может быть несколько объектов JavaRush
Метод main реализован только для вас и не участвует в тестировании
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or fix outputStream/inputStream according to your real file location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File your_file_name = File.createTempFile("tmp", ".txt", new File("D:/"));
            OutputStream outputStream = new FileOutputStream(your_file_name);
            InputStream inputStream = new FileInputStream(your_file_name);

            JavaRush javaRush = new JavaRush();
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.users.get(0).setFirstName("Ivan");

            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //check here that javaRush object equals to loadedObject object - проверьте тут, что javaRush и loadedObject равны

            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something wrong with save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            //implement this method - реализуйте этот метод
            PrintWriter printWriter = new PrintWriter(outputStream);
            SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH);
            if (this.users != null) {
                for (User userTmp : users) {
                    printWriter.println(userTmp.getFirstName());
                    printWriter.println(userTmp.getLastName());
                    printWriter.println(formatter.format(userTmp.getBirthDate()));
                    printWriter.println(userTmp.isMale());
                    printWriter.println(userTmp.getCountry().getDisplayedName());
                }
            }
            printWriter.close();
        }

        public void load(InputStream inputStream) throws Exception {
            //implement this method - реализуйте этот метод
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = reader.readLine()) != null) {
                User newUser = new User();
                newUser.setFirstName(line);
                newUser.setLastName(reader.readLine());
                Date formattedDate = new SimpleDateFormat("dd.MM.yyyy", Locale.ENGLISH).parse(reader.readLine());
                newUser.setBirthDate(formattedDate);
                newUser.setMale(Boolean.parseBoolean(reader.readLine()));
                String country = reader.readLine();
                switch (country) {
                    case "Ukraine":
                        newUser.setCountry(User.Country.UKRAINE);
                        break;
                    case "Russia":
                        newUser.setCountry(User.Country.RUSSIA);
                        break;
                    default:
                        newUser.setCountry(User.Country.OTHER);
                        break;
                }
                this.users.add(newUser);
            }
            reader.close();
        }
    }
}