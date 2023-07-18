package org.example;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;


public class Main {
    static String Name = "Имя";      // example input
    static String MiddleName = "Отчество";  // example input
    static HashMap<URL, String> yesterday = new HashMap<>();
    static HashMap<URL, String> today = new HashMap<>();


    public static void main(String[] args) throws MalformedURLException {
        //There were no requirements to make user input or read hashmap from file.
        //So I just manually filled both hashmaps.
        today.put(new URL("https://yandex.ru/search"), "nightmare dies");
        today.put(new URL("https://go.microsoft.com/fwlink"), "turfier");
        today.put(new URL("https://github.com/MFrolov3"), "styled");             //example input
        yesterday.put(new URL("https://intuit.ru/studies/courses"), "ring");
        yesterday.put(new URL("https://yandex.ru/search"), "nightmare dice");
        yesterday.put(new URL("https://go.microsoft.com/fwlink"), "turfier");

        HashMap<URL, String> disappeared = new HashMap<>(yesterday);
        HashMap<URL, String> appeared = new HashMap<>(today);
        HashMap<URL, String> temp = new HashMap<>(yesterday);
        HashMap<URL, String> changed = new HashMap<>(today);
        
        disappeared.keySet().removeIf(n -> (today.containsKey(n)));
        appeared.keySet().removeIf(n -> (yesterday.containsKey(n)));
        temp.keySet().removeIf(disappeared::containsKey);
        changed.keySet().removeIf(appeared::containsKey);
        changed.values().removeIf(temp::containsValue);

        //prints out the message to console. It could be done better if I sent it via email
        System.out.println("Здравствуйте, дорогая " + Name + " " + MiddleName
                + ". За последние сутки на ввереных вебсайтах произошли" +
                " следующие изменения. Исчезли следущие страницы URL=" + disappeared.keySet() +
                ". Появились следущие новые страницы URL=" + appeared.keySet() +
                ". Изменились следущие новые страницы URL=" + changed.keySet());
    }
}