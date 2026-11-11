package com.company.maingui;
import java.util.ArrayList;
import java.io.*;

abstract class User {
    public String name;
    public int age;
    public String gender;
    public String email;
    private String password;
    private String phoneNumber;

    User() {
        name = "";
        age = 0;
        gender = "";
        email = "";
        password = "";
        phoneNumber = "";
    }

    User(String n, int a, String g, String e, String p, String pn) {
        name = n;
        age = a;
        gender = g;
        email = e;
        password = p;
        phoneNumber = pn;
    }

    public void saveObjects(ArrayList<Object> list, String location) {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(location));

            // Write the ArrayList to the file
            oos.writeObject(list);

            oos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Object> loadObjects(String location) {
        ArrayList<Object> list = new ArrayList<>();

        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(location));

            // Read the ArrayList from the file
            list = (ArrayList<Object>) ois.readObject();

            ois.close();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    abstract void createUser();
    abstract void updateProfile();
    abstract void deleteProfile();
    abstract void getUserInfo();
    abstract void loadObjects();
    abstract void saveObjects();

    @Override
    public String toString() {
        String s = "name: " + name + "\nage: " + age + "\ngender: " + gender + "\nemail: " + email;
        return s;
    }

}