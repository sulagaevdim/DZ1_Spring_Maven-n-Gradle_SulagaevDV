package ru.geekbrains;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class Main {

    public static void main(String[] args) {
        Person dima = new Person("Dima", "Sulagaev", 32);
        Person anuar = new Person("Anuar", "Kameshev", 35);
        //демонстрация методов equals, hashcode, toString
        testLang3(dima, anuar);
        System.out.println("_________________________");
        //сериализация/десериализация в/из Gson
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        System.out.println(serializationForJson(dima, gson));
        System.out.println(deserializationForJson(serializationForJson(dima, gson), gson));
    }

    public static void testLang3(Person one, Person two) {
        System.out.println(one.equals(two));
        System.out.println(one.hashCode());
        System.out.println(two.hashCode());
        System.out.println(one.toString());
    }
    public static String serializationForJson(Person person, Gson gson){
        return gson.toJson(person);
    }
    public static Object deserializationForJson(String string, Gson gson){
        return gson.fromJson(string,Person.class);
    }



}