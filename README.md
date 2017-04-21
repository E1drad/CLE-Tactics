# CLE-Tactics
Le but de cette application est de permettre à l'utilisateur de charger des "plugins" via ce qu'on appelle le framework. Constultez le fichier PLATFORM.md pour plus de détails.

## Ajout d'une extension
Vous devez au préalable avoir compilé vos sources et donc disposer de fichiers ".class".
- Modifiez le fichier "config.json" situé à la racine de ce dépôt.
Vous devez renseigner le nom du plugin (à titre informatif), le nom de la classe (package.nomDeLaClasse), l'interface qu'il implémente (package.leNomDeL'interface), le chemin où se trouve la classe compilée, une description (à titre informatif) et autorun (true si doit être lancé au démarrage, false sinon).
- ...
## Dependance

Si un problème de librairie survient, ajoutez en external jar (configure build path > add external jar) la librairie json-simple-1.1.1.jar située à la racine.

## Lancement

Dans Eclipse, lancez Main.java du package framework.

## Contributeurs
BEGAUDEAU Charles-Eric
CANOVAS-VIRLY Baptiste
FONGUE Steven
HALLEREAU François
LORIOT Sacha
MERCIER Florent
