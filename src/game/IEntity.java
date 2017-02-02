package game;

public interface IEntity {

	public abstract int getId();

	public abstract int getX();

	public abstract int getY();

	public abstract IMap getCurrentMap();

}