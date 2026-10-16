
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        String ip = "192.168.1.240"; // Même IP que le serveur
        int port = 1234;

        try {
            Socket socket = new Socket(ip, port);

            DataInputStream in =
                    new DataInputStream(socket.getInputStream());

            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());

            Scanner clavier = new Scanner(System.in);

            int choix;

            do {
                System.out.println("\n--- CALCULATRICE ---");
                System.out.println("1. Addition : x + 5");
                System.out.println("2. Soustraction : x - 5");
                System.out.println("3. Multiplication : x * 5");
                System.out.println("4. Division : x / 5");
                System.out.println("0. Quitter");
                System.out.print("Votre choix : ");

                choix = clavier.nextInt();

                out.writeInt(choix);
                out.flush();

                if (choix == 0) {
                    break;
                }

                if (choix < 1 || choix > 4) {
                    System.out.println("Choix invalide !");
                    continue;
                }

                System.out.print("Donner la valeur de x : ");
                int x = clavier.nextInt();

                out.writeInt(x);
                out.flush();

                String resultat = in.readUTF();

                System.out.println("Résultat reçu : " + resultat);

            } while (true);

            in.close();
            out.close();
            socket.close();
            clavier.close();

            System.out.println("Client déconnecté.");

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
