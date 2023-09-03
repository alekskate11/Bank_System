package Bank_System;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class User {

    private String name;
    private String password;
    private String surname;
    private Check_Account check_account;
    private String email;
    private int num_id_card;
    private String login;
    private File file;

    public int getNum_id_card() {
        return num_id_card;
    }

    public Check_Account getCheck_account() {
        return check_account;
    }
    public static void Serializatiom(File file, User user){
        try(FileOutputStream fos =new FileOutputStream(file);
            ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(user);
        }catch( FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        }
    }

    public static void Deserialization(File file,User user){

        try(FileInputStream fis =new FileInputStream("Transactions.txt");
            ObjectInputStream ois = new ObjectInputStream(fis)){
            User new_user = (User) ois.readObject();
            System.out.println(new_user.toString());
        }catch( FileNotFoundException e){
            System.out.println(e);
        }catch(IOException e){
            System.out.println(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    public void setCheck_account(Check_Account check_account) {
        this.check_account = check_account;
    }

    public void setNum_id_card(int num_id_card) {
        this.num_id_card = num_id_card;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public User() {
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User(String name, String surname,String login,  String email,String password) {
        this.name = name;
        this.surname = surname;
this.login=login;
        this.email = email;
        this.password=password;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(getName(), user.getName()) && Objects.equals(getPassword(), user.getPassword()) && Objects.equals(getSurname(), user.getSurname()) && Objects.equals(getEmail(), user.getEmail());
    }

    @Override
    public int hashCode() {
        int res=31;
        res=31* Objects.hash(getName()) * Objects.hash(getPassword())* Objects.hash(getSurname())* Objects.hash( getEmail());
        return res;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}
