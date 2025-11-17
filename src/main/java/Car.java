public class Car implements Comparable<Car> {
    private static final int MINIMAL_SPEED = 0;
    private static final int MAXIMAL_SPEED = 250;

    private String name;
    private int speed;

    @Override
    public int compareTo(Car otherCar) {
        return Integer.compare(this.speed, otherCar.speed);
    }

    public void setName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Имя не может быть пустым");
        }
        this.name = name;
    }

    public void setSpeed(int speed) {
        if (speed > MAXIMAL_SPEED || speed < MINIMAL_SPEED) {
            String msg = String.format("Скорость должна быть от %d до %d", MINIMAL_SPEED, MAXIMAL_SPEED);
            throw new IllegalArgumentException(msg);
        }
        this.speed = speed;
    }

    public String getName() {
        return this.name;
    }

}