package konto;

import static konto.wlas_konta.kontoArray;

public class konto 
{
    static public double kontoStan = 0;
    public String kontoNumber;
    
    konto (String kontoNumber){
        this.kontoNumber = kontoNumber;
    }
    
    public final void setBalance(double kontoStan) {
        this.kontoStan = kontoStan;
    }
    public konto getKonto(int pozycja){
        return kontoArray.get(pozycja);
    }
    public String getKontoNumber(){
        return kontoNumber;
    }
    public double getKontoStan(){
        return kontoStan;
    }
    
    static public void wplata(double amount){   
        konto.kontoStan += amount;
    }
          
    static public void wyplata(double amount){
        konto.kontoStan -= amount;
    }
    
    static public void przelew(String to, double amount){
        for (konto toKonto : wlas_konta.kontoArray) {
            if (toKonto.kontoNumber.equals(to)) {
                toKonto.kontoStan += amount;
            }
        }
    }    
        
}
