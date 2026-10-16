# TP1-DAR2026 — Première connexion Client/Serveur



## 1. Objectif
L'objectif de ce TP est d'établir une communication entre un client et un serveur en Java à l'aide des sockets TCP.

## 2. Vérification de l'environnement
- Git : vérification avec la commande `git --version`.
- Java : vérification avec la commande `java --version`.

  ![ver.png](captures/ver.png)

## 3. Création du serveur
J'ai créé le package `serverPackage` et la classe `Server`.
Le serveur utilise `ServerSocket` sur le port 1234 et attend la connexion d'un client grâce à la méthode `accept()`.

![serveur.png](captures/serveur.png)

## 4. Création du client
J'ai créé le package `clientPackage` et la classe `Client`.
Le client utilise `Socket` pour se connecter au serveur sur `localhost`, port 1234.

![client.png](captures/client.png)

## 5. Interprétation des résultats
Le serveur attend la connexion du client. Lorsque le client se connecte, le serveur affiche le message « Un client est connecté ». Le client affiche également un message confirmant sa connexion.

## 6. Test avec une adresse IP
J'ai remplacé `localhost` par `127.0.0.1` et vérifié que la connexion fonctionne toujours sur le même ordinateur.

![client ip.png](captures/client%20ip.png)

## 7. modification de serveur

Le serveur attend la connexion du client, reçoit un entier envoyé par celui-ci, calcule le produit de cet entier par 5 et renvoie le résultat.

Les classes DataInputStream et DataOutputStream permettent de recevoir et d’envoyer des entiers, y compris les valeurs négatives.

Capture d’écran : Ajouter une capture du code de la classe Server.java. 
![serveur 1-2.png](captures/serveur%201-2.png)

## 7. modification de client

Le client se connecte au serveur et demande à l’utilisateur de saisir un entier au clavier. Il envoie cette valeur au serveur, reçoit le résultat du calcul et l’affiche dans la console.

Capture d’écran : Ajouter une capture du code de la classe Client.java.
![client 1-2.png](captures/client%201-2.png)

## 8. execution et tests

Le serveur est lancé en premier, puis le client.

Plusieurs valeurs sont testées afin de vérifier le fonctionnement du service.
![test serveur 1-2.png](captures/test%20serveur%201-2.png)

![test client 1-2.png](captures/test%20client%201-2.png)
## 9. Configuration du serveur
La classe Server utilise les classes InetAddress et InetSocketAddress pour configurer l'adresse IP et le port de communication.

Le serveur utilise un objet ServerSocket pour écouter les demandes de connexion sur l'adresse configurée et le port 1234.
## 10. Configuration du client
La classe Client utilise l'adresse IP de la machine serveur au lieu de localhost. Le client établit ensuite une connexion TCP avec le serveur.
## 11.  Fonctionnement de l'application
Le client affiche un menu permettant à l'utilisateur de sélectionner l'opération souhaitée.

Ensuite :

Le client envoie le choix de l'opération au serveur.

Le client transmet la valeur entière x.

Le serveur reçoit les données et effectue le calcul correspondant.

Le serveur renvoie le résultat au client.

Le client affiche le résultat reçu.

Les classes DataInputStream et DataOutputStream sont utilisées pour échanger les données entre le client et le serveur.
![serveur 1-3.png](captures/serveur%201-3.png)


![clien 1-3.png](captures/clien%201-3.png)
## 12.  Tests et résultats
![test serveur 1-3.png](captures/test%20serveur%201-3.png)


![test client 1-3.png](captures/test%20client%201-3.png)
