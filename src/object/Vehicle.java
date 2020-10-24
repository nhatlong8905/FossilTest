package object;

public abstract class Vehicle {
	public int wheels;
	public int doors;
	public int seats;
	
	Vehicle(){
		wheels= 4;
		doors = 4;
		seats = 5;
	}
	public abstract void runVehicle();
	public abstract void info();
}

