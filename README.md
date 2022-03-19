# Dépot de l'application eStoryMap


**eStoryMap** est une application web développée par des étudiants de L3 MIAGE de l'université de Lille dans le cadre de l'UE PROJET.

C'est une application d'analyse de fichiers liés à l'analyse fonctionnelle. Elle est destinée à tout type d'utilisateur qui souhaite vérifier la cohérance de leur analyse.

**eStoryMap** peut lire et comparer :
* *Diagramme BPMN générés sur [BPMN.io](https://bpmn.io/)*
* *Diagramme MCD*
* *Diagramme MCF générés sur [draw.io](https://draw.io)*

> Attention les flux des Mfc doivent respecter la convention de nommage suivant : F[numéro du flux] : [libellé du flux]  
> Pensez également a decocher la case compressed quand vous exportés le mfc en xml

## Accéder au serveur en local

### Dans Eclipse :

Importer le code source, `Run as` `Java Application` puis `localhost:8081` sur un navigateur.

### Dans un terminale :

Dans le dossier du projet, `./mvnw run` puis `localhost:8081` sur un navigateur.
