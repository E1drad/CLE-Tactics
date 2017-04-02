## API de la plateforme

La plateforme est constituée d'un lanceur d'extension et d'un descripteur d'extension

Le lanceur d'extension parcourt le fichier de configuration (formaté en JSON) afin de remplir un descripteur d'extension par extension reconnue dans le fichier, en ajoutant un parametre pour savoir si l'extension est en marche.

La methode setExtensionDescr parcourt le fichier de configuration et pour chaque extension trouvee, initialise un ExtensionDescr decrivant l'extension et la mettant dans une liste (extensions_ar si l'extension se lance au demarrage, extensions sinon)

La méthode loadExt charge toutes les extensions devant se lancer au démarrage

La methode loadDefaultExtension prend en parametre une classe, cherche les extensions correspondantes et lance celles devant etre lancees par defaut

La methode loadExtensionbyDescr permet de creer une instance de l'extension dont l'ExtensionDescr est en parametre

## Choix de conception et conventions de declaration de plugins 

Le fichier de configuration est un fichier JSON presentant un tableau d'extensions de la forme suivante : 

	{
      name : // nom usuel de l'extension
      class_name : // nom de la classe principale de l'extension
      interface : // nom de l'interface implementee par l'extension
      path : // le chemin vers la classe compilée (.class)
      description : // description du fonctionnement de l'extension
      autorun : // booleen indiquant si l'extension se lance au demarrage
    }

## Etat d'avancement

