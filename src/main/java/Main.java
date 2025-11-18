import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    private static final Scanner scanner = new Scanner(System.in);
    private static final int PARTICIPANTS_AMOUNT = 3;

    public static void main(String[] args) {
        Race currentRace = new Race();
        Car participantCar;

        for (int carNumber = 1; carNumber <= PARTICIPANTS_AMOUNT; carNumber++) {
            participantCar = inputData(carNumber);
            currentRace.findWinner(participantCar);
        }

        currentRace.showWinner();
        scanner.close();
    }

    private static Car inputData(int carNumber) {
        String speedValue, participantName = null;
        int participantSpeed;
        Car participantCar = new Car();
        boolean isValid = false;

        while (!isValid) {
            try {
                if (participantName == null || participantName.isBlank()) {
                    System.out.printf("— Введите название машины №%d:\n", carNumber);
                    participantName = scanner.nextLine();
                    participantCar.setName(participantName);
                }
                System.out.printf("— Введите скорость машины №%d:\n", carNumber);
                speedValue = scanner.nextLine();
                participantSpeed = Integer.parseInt(speedValue);
                participantCar.setSpeed(participantSpeed);
                isValid = true;
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Ошибка: введено нецелое число. Попробуйте снова!\n");
            } catch (IllegalArgumentException e) {
                System.out.printf("Ошибка : %s. Попробуйте снова!\n", e.getMessage());
            }
        }

        return participantCar;
    }
}