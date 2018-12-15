Library - WEBSERVICE
=====================

### Description:
Système d'information de bibliothèque basé sur une architecture microservice SOAP. Dans cette première versions l'application permet de creer des livres, de consulter ces livres, leurs disponibilités, de creer des usagers, de crer des prets, de suivre ces prets et de les prolonger une fois<br/>
Le système se décompose en deux applications, ici le web service qui permet qui permet de gérer la création des entités et de leur persistence en BDD  et remonte les informations vers l'application web.

### Prérequis:
Assurez vous d'avoir installer sur votre ordinateur les versions du 1.8 JDK, de Postgres SQL, Maven et le serveur Apache Tomcat 9.0.<br/>
L'utilisation d'un IDE, IntelliJ ou Eclipse est recommandée.

### Installation:
Téléchargez le fichier et décompressez le dans le dossier de votre choix. 
Créez une base de données Postgres, dans le module Webclient allez à src/main/resources.
Depuis le fichier application.properties pour configurer adresse, le nom d'utilisateur, le mot de passe et le système de gestion donnée PostgreSQl.

### Run:
L'application se lance depuis la ligne de commande avec mvn spring-boot:run en se plaçant a la racine du module web-client.<br/>
Si vous utilisez un IDE configuration de lancement est celle d'un application Springboot la classe principale est celle du module WebClient.<br/>
Une fois votre application démarré les fichiers WSDL sont accessibles sur les liens suivant:<br/>
http://localhost:8080/ws/users.wsdl<br/>
http://localhost:8080/ws/books.wsdl<br/>
http://localhost:8080/ws/borrows.wsdl

### Built With: 
SpringBoot 2.0 - The web framework used Hibernate, JPA2 <br/> Maven - Dependency Management