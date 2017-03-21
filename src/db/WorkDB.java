package db;

import dao.DaoClient;
import dao.DaoOrders;
import dao.DaoPerformer;
import entity.Client;
import entity.Orders;
import entity.Performer;

public class WorkDB {

	public static void create(String url, String nameDB, String login, String password) {

		DB db = new DB(url, "", login, password);
		db.update("CREATE DATABASE " + nameDB);
		db.update("USE " + nameDB);
		db.update("CREATE TABLE client ( id_client INT AUTO_INCREMENT, name VARCHAR(50) NOT NULL UNIQUE,"
				+ "password VARCHAR(50) NOT NULL, PRIMARY KEY(id_client))");

		DaoClient dc = new DaoClient(db);
		dc.insert(new Client("DomNormStroy", "pass"));
		dc.insert(new Client("DomDestroy", "pass"));
		dc.insert(new Client("Zemlyanka", "pass"));

		db.update("CREATE TABLE performer ( id_performer INT AUTO_INCREMENT, name VARCHAR(50) NOT NULL UNIQUE,"
				+ "password VARCHAR(50) NOT NULL, k FLOAT(3,3) NOT NULL, PRIMARY KEY(id_performer))");

		DaoPerformer dp = new DaoPerformer(db);
		dp.insert(new Performer("Ravshan & Dzamshut", "pass", 0.500));
		dp.insert(new Performer("Ahmed & Magomed", "pass", 0.100));
		dp.insert(new Performer("Mustafa & Sadula", "pass", 0.500));

		db.update("CREATE TABLE orders ( id_order INT AUTO_INCREMENT, id_client INT NOT NULL,"
				+ "id_performer INT, square INT NOT NULL, floor INT NOT NULL, k FLOAT(3,3) NOT NULL,"
				+ "status INT NOT NULL DEFAULT 0, PRIMARY KEY(id_order),"
				+ "FOREIGN KEY(id_client) REFERENCES client(id_client)"
				+ ")");
				//+ "FOREIGN KEY(id_performer) REFERENCES performer(id_performer))");

		DaoOrders dr = new DaoOrders(db);
		dr.insert(new Orders(1, 3, 1690, 9, 0.900, 1));
		dr.insert(new Orders(2, 1, 1500, 5, 0.274, 1));
		dr.insert(new Orders(3, 550, 1, 0.004, 0)); //without performer

	}
	
	public static void deleteDB(String url, String nameDB, String login, String password){
		DB db = new DB(url, nameDB, login, password);
		db.update("DROP DATABASE " + nameDB);
	}
}
