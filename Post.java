//After formating document.
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.*;
import java.util.Scanner;

public class rawClient {
    private static Scanner s = new Scanner(System.in);
    public static Socket ss;

    static void connect() throws Exception {
        ss = new Socket("Gamer", 8008);
        System.out.println("User connected");
    }

    static void chat() throws Exception {
        DataOutputStream dout = new DataOutputStream(ss.getOutputStream());
        System.out.printf("$ ");
        String post = s.nextLine();
        if (post.equalsIgnoreCase("exit();")) {
            ss.close();
        }
        dout.writeUTF(post);
        dout.flush();
    }

    public static DataInputStream dne;

    public static void main(String[] args) throws Exception {
        rawClient th = new rawClient();
        connect();
        while (true) {
            try {
                dne = new DataInputStream(ss.getInputStream());
                chat();
                Thread.sleep(3000);
                System.out.println("$ " + dne.readUTF());
            } catch (Exception e) {
                System.out.println("Exited");
                break;
            }
        }
    }
}
