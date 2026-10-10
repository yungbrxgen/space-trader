public class Ship {
    private final String shipName;
    private final CargoHold cargoHold;
    private int fuel;
    private final int maxFuel;

    public Ship(String shipName, CargoHold cargoHold, int fuel, int maxFuel) {
        this.shipName = shipName;
        this.cargoHold = cargoHold;
        this.fuel = fuel;
        this.maxFuel = maxFuel;
    }

    public String getShipName() {
        return shipName;
    }

    public CargoHold getCargoHold() {
        return cargoHold;
    }

    public int getFuel() {
        return fuel;
    }

    public int getMaxFuel() {
        return maxFuel;
    }
}
