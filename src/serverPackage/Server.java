
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

    public static void main(String[] args) {

        int port = 1234;
        String ip = "192.168.1.240"; // Remplacer par l'IP réelle du serveur

        try {
            InetAddress adresse = InetAddress.getByName(ip);
            InetSocketAddress socketAdresse =
                    new InetSocketAddress(adresse, port);

            ServerSocket serveur = new ServerSocket();
            serveur.bind(socketAdresse);

            System.out.println("Serveur en attente d'un client...");

            Socket socket = serveur.accept();
            System.out.println("Client connecté !");

            DataInputStream in =
                    new DataInputStream(socket.getInputStream());

            DataOutputStream out =
                    new DataOutputStream(socket.getOutputStream());

            while (true) {

                int choix = in.readInt();

                // Le choix 0 permet de quitter
                if (choix == 0) {
                    System.out.println("Fin de la connexion.");
                    break;
                }

                int x = in.readInt();
                double resultat;

                switch (choix) {

                    case 1:
                        resultat = x + 5;
                        break;

                    case 2:
                        resultat = x - 5;
                        break;

                    case 3:
                        resultat = x * 5;
                        break;

                    case 4:
                        resultat = (double) x / 5;
                        break;

                    default:
                        out.writeUTF("Choix invalide !");
                        out.flush();
                        continue;
                }

                System.out.println("Valeur reçue : " + x);
                System.out.println("Résultat : " + resultat);

                out.writeUTF(String.valueOf(resultat));
                out.flush();
            }

            in.close();
            out.close();
            socket.close();
            serveur.close();

        } catch (IOException e) {
            System.out.println("Erreur : " + e.getMessage());
        }
    }
}
