package threads.parking;

public abstract class Place {
    private volatile boolean occupied;

    public boolean isOccupied() {
        return occupied;
    }

    public void takePlace(boolean occupied) {
        this.occupied = occupied;
    }

    public abstract void standing();
}
