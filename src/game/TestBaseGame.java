package game;

public class TestBaseGame {

	public static void main(String[] args) {
		BaseGame baseGame = new BaseGame();
		System.out.println("baseGame has been create");
		BaseEntity entity1 = new BaseEntity(new BaseAbilityScore(), 1, "Link", 0, null);
		System.out.println("entity1 has been create");
		BaseEntity entity2 = new BaseEntity(new BaseAbilityScore(), 2, "Ganon", 1, new BaseArtificialIntelligence());
		System.out.println("entity2 has been create");
		baseGame.addCharactersOnMap(entity1, 0, 0);
		System.out.println("entity1 has been add on map");
		baseGame.addCharactersOnMap(entity2, 1, 0);
		System.out.println("entity2 has been add on map");
		baseGame.play();
	}

}
