package object;

import java.util.concurrent.Semaphore;

public class Car4 extends Vehicle implements Runnable{
	private int maxSpeed;
	final Semaphore myTurn ;
	final Semaphore theirTurn ;
	
	public Car4(Semaphore myTurn, Semaphore theirTurn,int maxSpeed){
		this.maxSpeed= maxSpeed;
		this.myTurn= myTurn;
		this.theirTurn= theirTurn;
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
		int turn = 0;
        while (turn < 10) {
            try {
                myTurn.acquire();
                turn += 1;
                System.out.println("maxSpeed= "+ this.maxSpeed);
                theirTurn.release();
            } catch (Exception e) {
                System.out.println("Oops: " + e);
            }
        }
    }
	private void outputMaxSpeed()
	{
		for(int i=0; i<10; i++)
		{
			System.out.println("maxSpeed= "+ this.maxSpeed);
		}
	}
}