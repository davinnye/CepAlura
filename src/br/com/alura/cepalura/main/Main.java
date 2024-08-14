package br.com.alura.cepalura.main;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import br.com.alura.cepalura.models.Adress;
import br.com.alura.cepalura.models.OmdAdress;

public class Main {
    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();
        
        var search = "";
        List<Adress> adresses = new ArrayList<>();

        while (!search.equalsIgnoreCase("sair")) {
            System.out.print("Digite o nome do cep que quer pesquisar: ");
            Scanner reader = new Scanner(System.in);
            search = reader.nextLine();
            if (search.equalsIgnoreCase("sair")) {
                break;
            }

            String encodedSearch = URLEncoder.encode(search, StandardCharsets.UTF_8).replaceAll("\\+", "%20");
            String url = "https://viacep.com.br/ws/" + encodedSearch + "/json/";

            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json = response.body();
            OmdAdress myOmdAdress = gson.fromJson(json, OmdAdress.class);
            Adress myAdress = new Adress(myOmdAdress);
            adresses.add(myAdress);

        }
        FileWriter savedAdresses = new FileWriter("adresses.json");
        savedAdresses.write(gson.toJson(adresses));
        savedAdresses.close();
    }
}
