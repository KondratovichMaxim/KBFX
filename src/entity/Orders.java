package entity;

public class Orders {

	private int id;
	private int id_client;
	private int id_performer;
	private int square;
	private int floor;
	private double k;
	private int status;
	
	public Orders(int id, int id_client, int id_performer, int square, int floor, double k, int status) {
		super();
		this.id = id;
		this.id_client = id_client;
		this.id_performer = id_performer;
		this.square = square;
		this.floor = floor;
		this.k = k;
		this.status = status;
	}

	public Orders(int id_client, int id_performer, int square, int floor, double k, int status) {
		super();
		this.id_client = id_client;
		this.id_performer = id_performer;
		this.square = square;
		this.floor = floor;
		this.k = k;
		this.status = status;
	}

	public Orders(int id_client, int square, int floor, double k, int status) {
		super();
		this.id_client = id_client;
		this.square = square;
		this.floor = floor;
		this.k = k;
		this.status = status;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + floor;
		result = prime * result + id;
		result = prime * result + id_client;
		result = prime * result + id_performer;
		long temp;
		temp = Double.doubleToLongBits(k);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + square;
		result = prime * result + status;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Orders other = (Orders) obj;
		if (floor != other.floor)
			return false;
		if (id != other.id)
			return false;
		if (id_client != other.id_client)
			return false;
		if (id_performer != other.id_performer)
			return false;
		if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
			return false;
		if (square != other.square)
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Orders [id=" + id + ", id_client=" + id_client + ", id_performer=" + id_performer + ", square=" + square
				+ ", floor=" + floor + ", k=" + k + ", status=" + status + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_client() {
		return id_client;
	}

	public void setId_client(int id_client) {
		this.id_client = id_client;
	}

	public int getId_performer() {
		return id_performer;
	}

	public void setId_performer(int id_performer) {
		this.id_performer = id_performer;
	}

	public int getSquare() {
		return square;
	}

	public void setSquare(int square) {
		this.square = square;
	}

	public int getFloor() {
		return floor;
	}

	public void setFloor(int floor) {
		this.floor = floor;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
