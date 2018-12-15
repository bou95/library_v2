Library - WEBAPP
==================

### Decription

Système d'information de bibliothèque basé sur une architecture microservice SOAP. Dans cette première versions l'application permet de creer des livres, de consulter ces livres, leurs disponibilités, de creer des usagers, de crer des prets, de suivre ces prets et de les prolonger une fois

Le système se décompose en deux applications, l'application web pour les usagers de la bibliothèques qui consomme les services veant du web-service pour qu'ils puissent consulter, rechercher les livres disponibles, se connecter sur un espace personnel et gérer leurs prets en cours.
### Prérequis:
Assurez vous d'avoir installer sur votre ordinateur les versions du 1.8 JDK, Maven et le serveur Apache Tomcat 9.0.<br/>
L'utilisation d'un IDE, IntelliJ ou Eclipse est recommandée.
### Installation:
Téléchargez le fichier et décompressez le dans le dossier de votre choix.
### Run:
Depuis un IDE creez une nouvelle configuration Tomcat Server avec le WAR du module web-service. N'oubliez pas de modifier le HTTP port qui est par défault configurer sur 8080 qui est celui sur lequel s'exécute le web-service pour éviter un conflit.
### Build with:
Spring 5.0<br/> Struts 2<br/> Maven - Dependency Management