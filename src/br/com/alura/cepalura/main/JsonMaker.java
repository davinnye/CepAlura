package br.com.alura.cepalura.main;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.FileWriter;
import java.io.IOException;

public class JsonMaker {
    public void saveJson(Adress adress){
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        try {
            FileWriter writer = new FileWriter(adress.cep()+".json");
            writer.write(gson.toJson(adress));
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }

    }
}