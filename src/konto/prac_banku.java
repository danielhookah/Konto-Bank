package konto;

import java.util.Random;
import java.util.Scanner;
import static konto.bank.usersArray;
import static konto.wlas_konta.kontoArray;

public class prac_banku {
    
    public String username;
    public String password;
    
    prac_banku (String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    /*public void login(String username, String password){
        if(this.username == username && this.password == password){
        System.out.print("Zalogowany\n");
            } else {
                    System.out.print("Nie zalogowany\n");
        }
    }
    
    public void logout() {
        System.out.print("Wylogowany\n");
    } 
    
        public void changePassword(String oldPassword, String newPassword) {
        if (oldPassword.equals(this.password)) {
            if (!this.password.equals(newPassword)) {
                this.password = newPassword;
                System.out.print("Haslo zmienione\n");
            }
        } else {
            System.out.print("Haslo nie zmienione\n");
        }
    }*/
    
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
            for (wlas_konta wlas : bank.usersArray) {
                for (konto kont : wlas_konta.kontoArray) {
                    if (!kont.kontoNumber.equals(numerKonta)) {
                        kont.kontoNumber = numerKonta;
                        break;
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
    
    public void getlist(){
        for (int i = 0; i < usersArray.size(); i++){
            System.out.println("Your " + i + " object in array: " + bank.usersArray.get(i) + "\n");
        }
    }
    
}
