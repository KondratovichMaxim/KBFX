package dao;

public interface DaoInterface<T> {

	public abstract void insert(T ob);
	public abstract void update(T ob);
	public abstract void delete(T ob);
}
