#include "../include/task.h"

#define MAX_COMMAND_LENGTH 100

int main() {
    char input[MAX_COMMAND_LENGTH];

    printf("Bienvenue dans la nouvelle commande !\n");
    printf("Tapez 'exit' pour quitter.\n");

    while (1) {
        printf("> ");
        fgets(input, MAX_COMMAND_LENGTH, stdin);

        // Supprimer le saut de ligne
        input[strcspn(input, "\n")] = '\0';

        // Vérifier si l'utilisateur a saisi 'exit'
        if (strcmp(input, "exit") == 0) {
            printf("Au revoir !\n");
            break;
        }

        // Ajouter le code pour traiter d'autres commandes ici

        // Si aucune commande spécifique n'est reconnue
        printf("Commande non reconnue. Tapez 'exit' pour quitter.\n");
    }

    return 0;
}