Guide d'Utilisation en Local
Prérequis

Avant de commencer, assurez-vous d'avoir les éléments suivants installés sur votre système:

    - Python (pour exécuter le serveur)
    - Un navigateur web moderne qui prend en charge les technologies web récentes (JavaScript, WebGL)

Installation et Utilisation

    Accédez au répertoire du projet via le terminal ou l'invite de commandes:
    cd chemin_vers_le_projet

    Lancez le serveur Python en exécutant la commande suivante:
    start serveur.py

Assurez-vous que le serveur fonctionne sans afficher d'erreur.

Ouvrez votre navigateur web et entrez l'URL suivante dans la barre d'adresse:

    http://localhost:8000/

    Vous devriez maintenant voir l'application en action.
(dupliquer ou entrée ce lien plusieurs fois)

Description de l'Application

Cette application utilise HTML, JavaScript (Three.js) pour créer une scène 3D dynamique qui représente des cubes colorés en fonction des fenêtres ouvertes sur votre bureau. L'application utilise également un gestionnaire de fenêtres personnalisé pour suivre et mettre à jour la disposition des fenêtres.
Fonctionnalités

    Les cubes représentent les fenêtres actuellement ouvertes sur votre bureau.
    La couleur des cubes est déterminée en fonction de l'ordre des fenêtres.
    La position et la rotation des cubes évoluent en fonction du temps.

Remarques

    Si vous souhaitez effacer les données persistantes stockées localement, vous pouvez ajouter le paramètre clear à l'URL de l'application:

    ruby

    http://localhost:8000/?clear

    Cela effacera le stockage local lors du chargement de la page.

Avertissement

Cette application utilise WebGL, assurez-vous d'avoir une connexion Internet stable et un navigateur qui prend en charge ces technologies. Si l'application ne fonctionne pas correctement, essayez avec un navigateur différent.