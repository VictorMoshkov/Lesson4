import java.util.Random;
import java.util.Scanner;

public class Main {

// X O

    static String[][] field;

    public static void main(String[] args) {
        initField();
        showField();

        while (!isFinishedGame()) {

            movePlayer();
            showField();
            movePC();
            showField();
        }


    }


    public static void initField() {
        field = new String[3][3];
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field[0].length; j++)
                field[i][j] = ".";
    }

    public static void showField() {
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[0].length; j++) {
                System.out.print(field[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void movePlayer() {
        Scanner sc = new Scanner(System.in);

        boolean isNotFinishedMove = true;

        while (isNotFinishedMove) {
            System.out.println("Выберите строку и столбец куда нужно ходить: ");
            try {
                int x = sc.nextInt() - 1;
                int y = sc.nextInt() - 1;
                if (x >= 0 && x < field.length && y >= 0 && y < field.length) {
                    if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                        field[x][y] = "X";
                        isNotFinishedMove = false;
                    } else {
                        System.out.println("Тут уже сделан ход");
                    }
                } else {
                    System.out.println("Вы ушли за пределеы поля");
                }
            } catch (Exception e) {
                System.out.println("Вы ввели неправильные данные");
            }
        }

    }


            public static void movePC () {
                Random random = new Random();

                boolean isNotFinishedMove = true;

                while (isNotFinishedMove) {
                    int x = random.nextInt(field.length);
                    int y = random.nextInt(field.length);
                    if (!field[x][y].equals("X") && !field[x][y].equals("O")) {
                        field[x][y] = "O";
                        isNotFinishedMove = false;
                    }
                }
                System.out.println("Компьютер сделал ход");
            }

    public static boolean isFinishedGame() {

        int countFreeSpace = 0;

        for (String[] arr : field)
            for (String elem : arr)
                if (elem.equals("."))
                    countFreeSpace += 1;
// Не получается добавить System.out.println("Победил игрок");System.out.println("Победил компьютер");
// Постоянно выделяется красным строка,всю голову сломал.
        for (int i = 0; i < 3; i++) {
            if (field[i][0] == ("X") && field[i][1] == ("X") && field[i][2] == ("X") || (field[0][i] == ("X")
                    && field[1][i] == ("X") && field[2][i] == ("X")))


                return true;
            if (field[0][0] == ("X") && field[1][1] == ("X") && field[2][2] == ("X") || (field[2][0] == ("X")
                    && field[1][1] == ("X") && field[0][2] == ("X")))

                return true;
            return false;
        }
        if (countFreeSpace == 0) {
            System.out.println("Ничья");
            return true;

        } else {
            return false;

        }
    }
}

