public class Race {
    private Car winnerCar = new Car();

    public final void findWinner(Car raceCar) {
        if (this.winnerCar.compareTo(raceCar) < 0) {
            this.winnerCar = raceCar;
        }
    }

    public final void showWinner() {
        System.out.printf("Самая быстрая машина: %s%n", this.winnerCar.getName());
    }
}