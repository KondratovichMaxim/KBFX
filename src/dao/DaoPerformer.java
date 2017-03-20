package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import entity.Performer;

public class DaoPerformer implements DaoInterface<Performer>{
	
	private DB db;
	
	public DaoPerformer(DB db){
		this.db = db;
	}

	@Override
	public void insert(Performer ob) {
		
		try {
			PreparedStatement ps = db.getCn().prepareStatement("INSERT INTO "+ob.getClass().getSimpleName()
					+" VALUES (?,?,?,?)");
			ps.setInt(1, ob.getId_performer());
			ps.setString(2, ob.getName());
			ps.setString(3, ob.getPassword());
			ps.setDouble(4, ob.getK());
			ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void update(Performer ob) {
		
		try {
			PreparedStatement ps = db.getCn().prepareStatement("UPDATE "+ ob.getClass().getSimpleName()
					+ "SET name=?, password=?, k=? WHERE id="+ ob.getId_performer());
					ps.setString(1, ob.getName());
					ps.setString(2, ob.getPassword());
					ps.setDouble(3, ob.getK());
					ps.execute();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Performer ob) {
		
		
	}
	
	
}