package konto;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import static konto.wlas_konta.kontoArray;

public class bank {
    
    static public ArrayList<wlas_konta> usersArray = new ArrayList();
    
    public wlas_konta getUser(int pozycja){
        return usersArray.get(pozycja);
    }
    
    public int wyszukaj(String username){
        for (int i = 0; i < usersArray.size(); i++){
            if (usersArray.get(i).getUsername() == username){
                return i;
            }
        }
        throw new RuntimeException("Nie ma takiej pozycji");
    }
    
    public void getlist(){
        for (int i = 0; i < usersArray.size(); i++){
            System.out.println("Your " + i + " object in array: " + bank.usersArray.get(i) + "\n");
        }
    }
    
//ADD DROP   
    
    public void addClient(String username, String password){
        wlas_konta user = new wlas_konta(username, password);
        user.username = username;
        user.password = password;
        System.out.println("Yor username is: " + user.username + "\nYour password is: " + user.password);
        
        bank.usersArray.add(user);
    }
    
    public void addKonto(wlas_konta user){
        String numerKonta = "";
        for (int i = 0; i < 17; i++) {
            Random rand = new Random();
            int num = rand.nextInt(10);
            numerKonta += String.valueOf(num);
        }
        for (wlas_konta wlas : bank.usersArray){
            for (konto kont : wlas_konta.kontoArray){
                if (!kont.kontoNumber.equals(numerKonta)){
                    kont.kontoNumber = numerKonta;
                }
            }
        }
        konto kon = new konto(numerKonta);
        user.kontoArray.add(kon);
        System.out.println("Dodane konto, numer konta: " + numerKonta + "\n");
    }
    
    public void dropClient(String username){
        for (int i = 0; i < usersArray.size(); i++){
            if(bank.usersArray.get(i).getUsername().equals(username)){
                usersArray.remove(i);
            }
        }
        System.out.println("Klient usuniony\n");
    }
    
    public void dropKonto(String nomer){
        for (int i = 0; i < kontoArray.size(); i++){
            if(wlas_konta.kontoArray.get(i).getKontoNumber().equals(nomer)){
                kontoArray.remove(i);
            }            
        }
        System.out.println("Konto usunione\n");
    }
    
//LOG CHANGEPASS GET    
    
    public void login(String username, String password){
        for (wlas_konta wlas : bank.usersArray){ 
            if(wlas.username.equals(username) && wlas.password.equals(password)){
                System.out.print("Zalogowany\n");
                wlas.stan=Status.zalogowany;
            } else {
                System.out.print("Nie zalogowany\n");
            }
        }
    }
    
    public void logout(String username){
        for (wlas_konta wlas : bank.usersArray){
            if(wlas.username.equals(username)){
                System.out.print("Wylogowany\n");
                wlas.stan=Status.niezalogowany;
            }
        }
    }
    
    public void changePassword(String username, String oldPassword, String newPassword){
        for (wlas_konta wlas : bank.usersArray){ 
            if (wlas.username.equals(username) && oldPassword.equals(wlas.password)){
                if (!wlas.password.equals(newPassword)){
                    wlas.password = newPassword;
                    System.out.print("Haslo zmienione\n");
                }
            } else {
                System.out.print("Haslo nie zmienione\n");
            }
        }
    }
    
    public void getNumber(int i, int j){
        System.out.print("Numer konta: " + bank.usersArray.get(i).getKonto(j).getKontoNumber() + "\n");
    }
    
    public void getKontoStan(int i, int j){
        System.out.print("Stan konta: " + bank.usersArray.get(i).getKonto(j).getKontoStan() + "\n");
    }
    
    public void getName(int i){
        System.out.print("Name: " + bank.usersArray.get(i).getUsername() + "\n");
    }
    
//TRANZACTION    
    
    public void wyplata(double amount, String kontoNumber){
        for (int i = 0; i < usersArray.size(); i++){
            for (konto kont : kontoArray) {
                if (usersArray.get(i).getKonto(i).kontoNumber.equals(kontoNumber)){
                    kont.wyplata(amount);
                }
            }   
        }    
    }
    
    public void wplata(double amount, String kontoNumber){
        for (int i = 0; i < usersArray.size(); i++){
            for (konto kont : kontoArray){
                if (usersArray.get(i).getKonto(i).kontoNumber.equals(kontoNumber)){
                    kont.wplata(amount);
                }
            }       
        }    
    }
    
    public void przelew (String to, double amount, String kontoNumber){
        for (konto kont : kontoArray){
            if (kont.kontoNumber.equals(kontoNumber)){
                konto.przelew(to, amount);
                konto.kontoStan -= amount;
            }
        }   
    }       

}
