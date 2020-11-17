package hw;

public class Auto {
	
	private int id;
	private String model;
	private int topSpeed;
	private int coast;
	
	public Auto(String model, int topSpeed, int coast) {
		super();
		this.model = model;
		this.topSpeed = topSpeed;
		this.coast = coast;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getTopSpeed() {
		return topSpeed;
	}

	public void setTopSpeed(int topSpeed) {
		this.topSpeed = topSpeed;
	}

	public int getCoast() {
		return coast;
	}

	public void setCoast(int coast) {
		this.coast = coast;
	}

	@Override
	public String toString() {
		return "Auto [id=" + id + ", model=" + model + ", topSpeed=" + topSpeed + ", coast=" + coast + "]";
	}
	
}
