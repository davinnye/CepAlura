package br.com.alura.cepalura.main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        var search = "";
        System.out.print("Digite o cep que quer pesquisar: ");
        Scanner reader = new Scanner(System.in);
        search = reader.nextLine();
        
        Searcher adressSearcher = new Searcher();
        try{
            Adress newAdress = adressSearcher.searchAdress("40800470");
            System.out.println(newAdress);
            JsonMaker maker = new JsonMaker();
            maker.saveJson(newAdress);

        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        
    }

}
