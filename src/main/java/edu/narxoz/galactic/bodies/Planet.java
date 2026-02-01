package edu.narxoz.galactic.bodies;
import edu.narxoz.galactic.bodies.CelestialBody;
public class Planet extends CelestialBody {
    private String atmosphereType;
    public Planet(String name, double x, double y, String atmosphereType) {
        super(name,x,y);
        this.atmosphereType=atmosphereType;
    }
    public String getAtmosphereType(){
        return atmosphereType;
    }
}