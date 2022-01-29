public class Car {
    private String model;
    private double fuelAmount;
    private double fuelCostForOneKilometer;
    private double distanceTravelled;

    public Car(String model, double fuelAmount, double fuelCostForOneKilometer) {
        this.model = model;
        this.fuelAmount = fuelAmount;
        this.fuelCostForOneKilometer = fuelCostForOneKilometer;
        this.distanceTravelled = 0;
    }

    public String getModel() {
        return model;
    }

    public double getFuelAmount() {
        return fuelAmount;
    }

    public double getFuelCostForOneKilometer() {
        return fuelCostForOneKilometer;
    }

    public double getDistanceTravelled() {
        return distanceTravelled;
    }


    public void setFuelAmount(double fuelAmount) {
        this.fuelAmount = fuelAmount;
    }

    public void setDistanceTravelled(double distanceTravelled) {
        this.distanceTravelled = distanceTravelled;
    }

    public boolean isPossibleToMove(double amountOfKm) {
        double fuelNeeded = amountOfKm * fuelCostForOneKilometer;
        if(fuelNeeded > fuelAmount) {
            return false;
        }
        this.setFuelAmount(fuelAmount - fuelNeeded);
        this.setDistanceTravelled(distanceTravelled + amountOfKm);
        return true;
    }

    @Override
    public String toString() {
        return model + " " + String.format("%.2f", fuelAmount) + " " + String.format("%.0f", distanceTravelled);
    }
}
