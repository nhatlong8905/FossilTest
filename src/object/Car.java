package object;

public class Car extends Vehicle implements Runnable{
	private int maxSpeed;
	Car(int maxSpeed){
		this.maxSpeed= maxSpeed;
	}
	
	@Override
	public void runVehicle() {
		outputMaxSpeed();
	}
	@Override
	public void info() {
		System.out.println("Wheels= "+ this.wheels);
		System.out.println("doors= "+ this.doors);
		System.out.println("seats= "+ this.seats);
		System.out.println("Wheels= "+ this.maxSpeed);
	}
	@Override
	public void run() {
		outputMaxSpeed();
	}
	private void outputMaxSpeed()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println("maxSpeed= "+ this.maxSpeed);
		}
	}
}