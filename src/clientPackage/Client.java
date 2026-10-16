
package clientPackage;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             DataInputStream in = new DataInputStream(
                     socket.getInputStream());
             DataOutputStream out = new DataOutputStream(
                     socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Connecté au serveur !");

            while (true) {
                System.out.print("Donner un entier (0 pour quitter) : ");
                int x = scanner.nextInt();

                out.writeInt(x);
                out.flush();

                if (x == 0) {
                    System.out.println("Déconnexion...");
                    break;
                }

                int resultat = in.readInt();

                System.out.println("Résultat = " + resultat);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
