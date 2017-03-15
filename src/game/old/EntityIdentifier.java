package game.old;

public class EntityIdentifier implements IEntityIdentifier {

	private long id;
	
	public EntityIdentifier() {
		super();
		this.id = 0;
	}
	
	public EntityIdentifier(long id) {
		super();
		this.id = id;
	}

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
}
