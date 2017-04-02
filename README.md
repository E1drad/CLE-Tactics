# CLE-Tactics
Le but de cette application est de permettre à l'utilisateur de charger des "plugins" via ce qu'on appelle le framework. Ce dernier est composé d'un "ExtensionLoader". Celui-ci se repose sur un fichier de configuration (config.json) détaillant la nature des différents "plugins" pouvant / devant être chargés.
Au démarrage de l'application, le fichier de configuration est parcouru à la recherche des plugins possédant le champ "autorun" à "true". Toutes les extensions concernées seront alors chargées immédiatement via la méthode "loadExt()" présente dans l'"ExtensionLoader".
Une fois les premières extensions chargées, celles-ci peuvent avoir besoin de modules spécifiques pour fonctionner. Les extensions feront appel au framework pour lui demander de charger ces précieux modules.

## Ajout d'une extension
Incomming.

## Dependance

Si un problème de librairie survient, ajoutez en external jar (configure build path > add external jar) la librairie json-simple-1.1.1.jar située à la racine.

## Lancement

Dans Eclipse, lancez Main.java du package framework.
