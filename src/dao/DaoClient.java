package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import entity.Client;

public class DaoClient implements DaoInterface<Client>{
	
	private DB db;
	
	public DaoClient(DB db){
		this.db = db;
	}

	@Override
	public void insert(Client ob) {
		
		try {
			PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO "+ob.getClass().getSimpleName()
					+" VALUES (?,?,?)");
			ps.setInt(1, ob.getId_client());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getPassword());
			ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update(Client ob) {
		
		try {
			PreparedStatement ps = db.getCn().prepareStatement("UPDATE "+ ob.getClass().getSimpleName()
					+ "SET name=?, password=? WHERE id="+ ob.getId_client());
					ps.setString(1, ob.getName());
					ps.setString(2, ob.getPassword());
					ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Client ob) {
		
		
	}
	
	
}