/*
Test this online with: https://www.jdoodle.com/online-java-compiler/
*/
class Vehicle {
    public int velocity; 
    
    public Vehicle(int velocity) { 
        this.velocity = velocity; 
    }
    
    public void accelerate(int acceleration) { 
        velocity += acceleration; 
    }
    
    public void decelerate(int deceleration) { 
        velocity -= deceleration; 
    }
    
    public String toString() { 
        return("Velocity: " + velocity + "\n"); 
    }
}

class ElectricCar extends Vehicle {
    public int batteryPower; 
    
    public ElectricCar(int startingVelocity, int batteryPower) { 
        super(startingVelocity);
        this.batteryPower = batteryPower; 
    }
    
    public void charge(int chargeAmount) {
        batteryPower += chargeAmount;
    }
    
    public void discharge(int dischargeAmount) {
        batteryPower -= dischargeAmount;
    }
    
    @Override
    public String toString() { 
        return (super.toString() + "Battery Power: " + batteryPower + "\n");
    }
}

public class test {
    public static void main(String args[]) {
        ElectricCar tesla = new ElectricCar(0, 100); 
        tesla.accelerate(60);
        tesla.discharge(40);
        System.out.println(tesla.toString()); 
    }
}
