## API de la plateforme

La plateforme est constituée d'un lanceur d'extension et d'un descripteur d'extension

Le lanceur d'extension parcourt le fichier de configuration (formaté en JSON) afin de remplir un descripteur d'extension par extension reconnue dans le fichier, en ajoutant un paramètre pour savoir si l'extension est en marche.

La méthode setExtensionDescr parcourt le fichier de configuration et pour chaque extension trouvée, initialise un ExtensionDescr décrivant l'extension et la mettant dans une liste (extensions_ar si l'extension se lance au démarrage, extensions sinon)

## Choix de conception et conventions de déclaration de plugins 

Le fichier de configuration est un fichier JSON présentant un tableau d'extensions de la forme suivante : 

	{
      name : // nom usuel de l'extension
      class_name : // nom de la classe principale de l'extension
      interface : // nom de l'interface implémentée par l'extension
      description : // description du fonctionnement de l'extension
      autorun : // booléen indiquant si l'extension se lance au démarrage
    }

## Etat d'avancement

