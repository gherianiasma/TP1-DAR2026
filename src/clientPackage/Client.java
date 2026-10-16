
package clientPackage;

import java.io.IOException;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {

        try {
            // Étape 1 : afficher l'état du client
            System.out.println(
                    "Je suis un client pas encore connecté..."
            );

            // Étape 2 : se connecter au serveur
            Socket socket = new Socket("127.0.0.1", 1234);

            System.out.println("Je suis un client connecté");

            // Étape 3 : fermer la socket
            socket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
