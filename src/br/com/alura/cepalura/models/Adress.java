package br.com.alura.cepalura.models;

public class Adress implements Comparable<Adress> {
    private String cep;
    private String logradouro;
    private String localidade;
    private String bairro;
    private String uf;
    private String ibge;
    private String gia;
    private double ddd;
    private String siafi;
   
    public Adress (OmdAdress myOmdAdress){
        this.cep = myOmdAdress.cep();
        this.ddd = myOmdAdress.ddd();
        this.uf = myOmdAdress.uf();
        this.localidade = myOmdAdress.localidade();
        this.bairro = myOmdAdress.bairro();
    }
    
    
    
    
    public String getCep() {
        return cep;
    }




    public String getLogradouro() {
        return logradouro;
    }




    public String getLocalidade() {
        return localidade;
    }




    public String getBairro() {
        return bairro;
    }




    public String getUf() {
        return uf;
    }




    public String getIbge() {
        return ibge;
    }




    public String getGia() {
        return gia;
    }




    public double getDdd() {
        return ddd;
    }




    public String getSiafi() {
        return siafi;
    }




    @Override
    public int compareTo(Adress o) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'compareTo'");
    }

    @Override
    public String toString() {

        return "(O Cep " + cep + "fica no bairro " + bairro + ", no estado " + uf + ", cujo o ddd é " + ddd + ".";
    }
    
}