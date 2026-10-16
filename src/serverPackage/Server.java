
package serverPackage;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        try {
            // Étape 1 : créer le serveur
            ServerSocket serverSocket = new ServerSocket(1234);

            System.out.println(
                    "Je suis un serveur en attente de la connexion d'un client"
            );

            // Étape 2 : attendre la connexion du client
            Socket socket = serverSocket.accept();

            System.out.println("Un client est connecté");

            // Étape 3 : fermer les sockets
            socket.close();
            serverSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

