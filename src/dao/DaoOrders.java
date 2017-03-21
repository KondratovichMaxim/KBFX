package dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import db.DB;
import entity.Orders;

public class DaoOrders implements DaoInterface<Orders> {

	private DB db;

	public DaoOrders(DB db) {
		this.db = db;
	}

	@Override
	public void insert(Orders ob) {

		try {
			PreparedStatement ps = db.getCn()
					.prepareStatement("INSERT INTO " + ob.getClass().getSimpleName() + " VALUES (?,?,?,?,?,?,?)");
			ps.setInt(1, ob.getId());
			ps.setInt(2, ob.getId_client());
			ps.setInt(3, ob.getId_performer());
			ps.setInt(4, ob.getSquare());
			ps.setInt(5, ob.getFloor());
			ps.setDouble(6, ob.getK());
			ps.setInt(7, ob.getStatus());
			ps.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void update(Orders ob) {

		try {
			PreparedStatement ps = db.getCn()
					.prepareStatement("UPDATE " + ob.getClass().getSimpleName()
							+ "SET id=?, id_client=?, id_performer=?, square=?, floor=?, k=?, status=? WHERE id="
							+ ob.getId_performer());
			ps.setInt(1, ob.getId_client());
			ps.setInt(2, ob.getId_performer());
			ps.setInt(3, ob.getSquare());
			ps.setInt(4, ob.getFloor());
			ps.setDouble(5, ob.getK());
			ps.setInt(6, ob.getStatus());
			ps.execute();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	@Override
	public void delete(Orders ob) {

	}

}