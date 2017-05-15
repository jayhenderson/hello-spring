package org.launchcode.models;

import java.util.HashMap;

/**
 * Created by J on 3/6/2017.
 */
public class HelloMessage {
    public static String createMessage(String name, String language) {
        String greeting;
        HashMap<String, String> languageGreetings = getLanguages();
        greeting = "<b>" + languageGreetings.get(language) + name + "!</b>";
        return greeting;

    }
    public static HashMap<String, String> getLanguages(){
        HashMap<String, String> languageGreetings = new HashMap<>();
        languageGreetings.put("English", "Hello ");
        languageGreetings.put("French", "Bonjour ");
        languageGreetings.put("Chinese", "Ni hao ");
        languageGreetings.put("Spanish", "Hola ");
        languageGreetings.put("Minnesotan", "Oh hey dere ");

        return languageGreetings;
    }
}
