package main;

import java.util.concurrent.Semaphore;

import object.BMWCar;
import object.Car4;
import object.ToyotaCar;

public class Program {
	public static void main(String []args) throws InterruptedException {
		//Question 1
		System.out.println("-----Question 1-----");
		ToyotaCar tCar= new ToyotaCar(100);
		BMWCar bCar= new BMWCar(200);
		
		System.out.println("-----Toyota Car-----");
		tCar.runVehicle();
		tCar.info();
		
		System.out.println("-----BMW Car-----");
		bCar.runVehicle();
		bCar.info();
		
		//Question 2
		System.out.println("-----Question 2-----");
		Thread threadToyota = new Thread(new ToyotaCar(100)) ;
		Thread threadBMW = new Thread(new BMWCar(200)) ;
		System.out.println("-----Toyota Car Runable-----");
		threadToyota.start();
		
		System.out.println("-----BMW Car Runable-----");
		threadBMW.start();
		threadBMW.join();
		
		
		//Question 3
		//Why is the order of outputs in 2 and 1 different?
		//Answer: Because Program created 2 threads, they can be asynchronous running.
		//How can we make sure that the question 2 will produce the order just like question 1
		//Answer:using join() method for waitting thread Toy done.
		
		System.out.println("-----Question 3-----");
		Thread threadT = new Thread(new ToyotaCar(100)) ;
		Thread threadB = new Thread(new BMWCar(200)) ;
		System.out.println("-----Toyota Car-----");
		threadT.start();
		threadT.join();
		System.out.println("-----BMW Car-----");
		threadB.start();
		threadB.join();
		
		//Question 4
		System.out.println("-----Question 4-----");
		Semaphore first = new Semaphore(1);
        Semaphore second = new Semaphore(0);
        
		Thread threadToy = new Thread(new Car4(first,second,100)) ;
		Thread threadBMW4 = new Thread(new Car4(second,first,200)) ;
		threadToy.start();
		threadBMW4.start();

    }
}

