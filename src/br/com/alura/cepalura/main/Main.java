package br.com.alura.cepalura.main;

public class Main {
    public static void main(String[] args) {

        Searcher adressSearcher = new Searcher();
        Adress newAdress = adressSearcher.searchAdress("40800470");
        System.out.println(newAdress);

    }

}
