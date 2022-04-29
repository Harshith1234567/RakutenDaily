package com.rakuten;

public class GravityCalculator {

	public static void main(String[] args) {
		
		//We need to first initialize all the parameters
		final double gravity=-9.81;
		double initialVelocity=0.0;
		double fallingTime=10.0;
		double initialPosition=0.0;
		
		double finalPosition=((.5*(gravity * Math.pow(fallingTime,2)))+initialVelocity*fallingTime+ initialPosition);
		// for calculating the final position after falling for 10 minutes we have used the formula 
		//x(t) = 0.5 × at^2 + vt + x
		
		
		//the Output before Modification is
		//The objects position after 10.0 second is 0.0m
		
		System.out.println("The objects position after "+ fallingTime +" second is "+ finalPosition +'m');
		//The output after the modification is
		//The objects position after 10.0 second is -490.5m
	}

}
