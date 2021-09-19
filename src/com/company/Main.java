package com.s;
import java.io.*;
import java.net.*;
public class Main {
    static ServerSocket server;
    static Socket ss;
    static DataInputStream dne;
    static FileWriter fw;
    static void connect() throws Exception{
        server = new ServerSocket(8008);
        ss = server.accept();
        System.out.println("Connected");
    }
    static void receiveFile() throws Exception{
        File file = new File("Post.java");
        file.createNewFile();
        dne = new DataInputStream(ss.getInputStream());
//        fw = new FileWriter(file);
//        String post = dne.readUTF();
//        System.out.println(post);
//        fw.write(post);
//        fw.flush();
        fw = new FileWriter(file);
        BufferedReader br = new BufferedReader(new InputStreamReader(ss.getInputStream()));
        String post;
        try{
            while ((post=dne.readUTF())!=null){
                fw.write(post);
                fw.flush();
            }
        }
        catch (Exception e){
            System.out.println("done");
        }



    }
    public static void main(String[] args) {
        try{
            connect();
            receiveFile();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
