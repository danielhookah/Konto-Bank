package konto;

import java.util.ArrayList;
import static konto.bank.usersArray;

enum Status{zalogowany, niezalogowany};

public class wlas_konta {
    
    public String username;
    public String password;
    public int ID;
    Status stan=Status.niezalogowany;
    
    static public ArrayList<konto> kontoArray = new ArrayList();
    
    wlas_konta(String username, String password){
        this.username = username;
        this.password = password;
    }
    
    public int getID(){
        return ID;
    }
    public Status getStan(){
        return stan;
    }
    public konto getKonto(int pozycja){
        return kontoArray.get(pozycja);
    }
    public String getUsername() {
        return username;
    }
    public void getLiczbeKont() {
        System.out.print("Masz: " + kontoArray.size() + " kont\n");
    }
    
    public void login(String username, String password) {
        if(this.username == username && this.password == password){
            System.out.print("Zalogowany\n");
            stan=Status.zalogowany;
        } else {
            System.out.print("Nie zalogowany\n");
        }
    }
    
    public void logout(){
        stan=Status.niezalogowany;
        System.out.print("Wylogowany\n");
    }
    
    public void changePassword(String oldPassword, String newPassword){
        if (stan==Status.zalogowany){
            if (oldPassword.equals(this.password)){
                if (!this.password.equals(newPassword)){
                    this.password = newPassword;
                    System.out.print("Haslo zmienione\n");
                }
            } else {
                System.out.print("Haslo nie zmienione\n");
            }
        }
    }
    
    public int wyszukajKonto(String kontoNumber){
        for (int i = 0; i < kontoArray.size(); i++){
            if (kontoArray.get(i).getKontoNumber().equals(kontoNumber)){
                return i;
            }
        }
        throw new RuntimeException("Nie ma takiej pozycji");
    }
    
    public void wyplata (double amount, String kontoNumber){
        if (stan==Status.zalogowany){
            for (konto kont : kontoArray){
                if (kont.kontoNumber.equals(kontoNumber)){
                   konto.wyplata(amount);
                }
            }       
        }
    }
    
    public void wplata (double amount, String kontoNumber){
        if (stan==Status.zalogowany){
            for (konto kont : kontoArray) {
                if (kont.kontoNumber.equals(kontoNumber)){
                   konto.wplata(amount);
                }
            }       
        }
    }  
    
    public void przelew (String to, double amount, String kontoNumber){
        if (stan==Status.zalogowany){
            for (konto kont : kontoArray){
                if (kont.kontoNumber.equals(kontoNumber)){
                   konto.przelew(to, amount);
                   konto.kontoStan -= amount;
                }
            }       
        }
    }
        
}
