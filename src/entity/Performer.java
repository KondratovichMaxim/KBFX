package entity;

public class Performer {

	private int id_performer;
	private String name;
	private String password;
	private double k;

	public Performer(int id_performer, String name, String password, double k) {
		this.id_performer = id_performer;
		this.name = name;
		this.password = password;
		this.k = k;
	}

	public Performer() {
	}

	public Performer(String name, String password, double k) {
		this.name = name;
		this.password = password;
		this.k = k;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_performer;
		long temp;
		temp = Double.doubleToLongBits(k);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
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
		Performer other = (Performer) obj;
		if (id_performer != other.id_performer)
			return false;
		if (Double.doubleToLongBits(k) != Double.doubleToLongBits(other.k))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Performer [id_performer=" + id_performer + ", name=" + name + ", password=" + password + ", k=" + k
				+ "]";
	}

	public int getId_performer() {
		return id_performer;
	}

	public void setId_performer(int id_performer) {
		this.id_performer = id_performer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getK() {
		return k;
	}

	public void setK(double k) {
		this.k = k;
	}

}
