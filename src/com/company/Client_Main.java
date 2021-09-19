package com.company;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main {
    static Socket server;
    static DataInputStream dne;
    static DataOutputStream dout;
    static Scanner s;
    static void connect(String hostname,int port) throws Exception{
        server = new Socket(hostname,port);
        System.out.println("Connected");
    }
    static void sendFile(File file) throws Exception{
        s = new Scanner(file);
        dout = new DataOutputStream(server.getOutputStream());
//        String post = s.nextLine();
//        System.out.println(post);
//        dout.writeUTF(post);
//        dout.flush();
        BufferedReader br = new BufferedReader(new FileReader(file));
        String post;
        while((post=br.readLine())!=null){
            dout.writeUTF(post);
            dout.flush();
        }

    }
    public static void main(String[] args) {
        try{
            connect("Gamer",8008);
            File fi = new File("C:\\Users\\callr\\Downloads\\gitproj\\idk\\IDK\\src\\rawClient.java");
            sendFile(fi);
            System.out.println("done");
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }
}
