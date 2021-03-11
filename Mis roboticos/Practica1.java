package uma;
import robocode.*;
import java.awt.Color;

// API help : https://robocode.sourceforge.io/docs/robocode/robocode/Robot.html

/**
 * Practica1 - a robot by Marta Maleno Escudero
 */
public class Practica1 extends Robot
{
	double energia = 0.0;
	double tiempo = 0.0;
	
	/**
	 * run: Practica1's default behavior
	 */

	public void run() {
		// Initialization of the robot should be put here

		// After trying out your robot, try uncommenting the import at the top,
		// and the next line:

		setColors(Color.yellow,Color.blue,Color.green); // body,gun,radar

		// Robot main loop
		while(true) {
			energia = getEnergy(); 
			tiempo = getTime();
			
			if (energia > 50.0){
			//Estrategia 1 
				if (tiempo < 60){
					turnRight(20);
					ahead(50);
		
				} else{
					turnLeft(20);
					ahead (20);
					fire(1);
				}
			} else{
				turnRight(60);
				back(20);
				fire(1);
			}
			// Replace the next 4 lines with any behavior you would like
			
			turnRight(45);
			
		}
	}
	
	/**
	 * onScannedRobot: What to do when you see another robot
	 */


	public void onScannedRobot(ScannedRobotEvent e) {
		// Replace the next line with any behavior you would like
		String name = e.getName();
		double velocity = e.getVelocity();
		fire(3); System.out.println("Evento scanned-ejecución fire");
	}

	/**
	 * onHitByBullet: What to do when you're hit by a bullet
	 */
	public void onHitByBullet(HitByBulletEvent e) {
		// Replace the next line with any behavior you would like
		
		turnRight(60);
		back(20); System.out.println("Evento hitbybullet-ejecución backk");
		
		String name = e.getName();
		double velocidad = e.getVelocity();

		Bullet bala = e.getBullet();
		double potencia = bala.getPower();
		System.out.println("Me disparó: "+name+" v:"+velocidad+" p:"+potencia);
	
	//Lista de enemigos -> 1.Me dispara lo pongo primero en la lista y voy a por él
	//                     2.Busco el que dispara la posición y heading y huyo de él
	}
	
	/**
	 * onHitWall: What to do when you hit a wall
	 */
	public void onHitWall(HitWallEvent e) {
		// Replace the next line with any behavior you would like
		back(20); System.out.println("Evento hitbywall-ejecución back");
		turnRight(45);
		ahead(10);
	}	
}
