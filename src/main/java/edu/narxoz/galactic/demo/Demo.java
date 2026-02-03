package edu.narxoz.galactic.demo;
import edu.narxoz.galactic.bodies.Planet;
import edu.narxoz.galactic.cargo.Cargo;
import edu.narxoz.galactic.drones.HeavyDrone;
import edu.narxoz.galactic.drones.LightDrone;
import edu.narxoz.galactic.task.DeliveryTask;
import edu.narxoz.galactic.task.Dispatcher;
import edu.narxoz.galactic.task.Result;
public class Demo {
    public static void main(String[] args) {
        Planet venera = new Planet("Venera", 10,0,"H20");
        Planet mercuri = new Planet("Mercuri", 100, 0, "HCL");
        Cargo cargo = new Cargo(60, "Heavy object");
        LightDrone lD = new LightDrone("LD-2", 15);
        HeavyDrone hD = new HeavyDrone("HD-3", 65);
        DeliveryTask task = new DeliveryTask(venera, mercuri, cargo);
        Dispatcher dispatcher = new Dispatcher();

        System.out.println("1. Task to LightDrone: ");
        Result res1 = dispatcher.assignTask(task, lD);
        System.out.println("Result: " + res1.ok()+ " reason: " + res1.reason());
    
        System.out.println("\n 2. Task to HeavyDrone: ");
        Result res2 = dispatcher.assignTask(task, hD);
        System.err.println("Result: " + res2.ok() + " reason: " + res2.reason());

        System.err.println("\n 3.Estimate delivery time: ");
        double time = task.estimateTime();
        System.out.println(" Estimate time: " + time);

        System.out.println("\n 4. Complete task: ");
        Result res3 = dispatcher.completeTask(task);
        System.out.println("Result: " + res3.ok() + " reason: " + res3.reason());

        System.out.println("\n Finals: ");
        System.out.println("Drone " + hD.getStatus());
        System.out.println(" Task " + task.getState());
    }
    
}
