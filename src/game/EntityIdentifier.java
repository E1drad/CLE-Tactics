package game;

public class EntityIdentifier implements IEntityIdentifier {
	public EntityIdentifier(long id) {
		super();
		this.id = id;
	}

	public long id;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}
	
}
