import java.util.Random;

/*
Создать двумерный квадртный массив размера n. Заполнить его случайными числами, таким образом
- числа по диагонали равный нулю;
- сверху и снизу от пересечения диагоналей находятся только положительные числа;
- слева и справа от пересечения диагоналей находятся только отрицательные числа;

Вывести массив на экран:
- найти сумму всех элементов;
- найти среднее арифметическое всех элементов, которые больше суммы всех элементов;

 */
public class Main {
    public static void main(String[] args) {
        Random rand = new Random();
        final int n = 7;
        int sum = 0, arithmMean = 0, num = 0;
        int[][] array = new int[n][n];
        System.out.println();
        generateArray(rand, array);
        sum = getSum(sum, array);
        System.out.printf("Сумма всех элементов массива: %d\n", sum);

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > sum) {
                    arithmMean += array[i][j];
                    num++;
                }
            }
        }
        if (num == 0) {
            System.out.printf("Отсутствуют элементы больше %d\n", sum);
        } else {
            System.out.printf("Среднее арифметическое всех элементов больше %d: %f\n", sum, (double) arithmMean / num);
        }
    }

    private static int getSum(int sum, int[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                sum += array[i][j];
            }
        }
        return sum;
    }

    private static void generateArray(Random rand, int[][] mas) {
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[i].length; j++) {
                if (i == j || j == mas[i].length - i - 1) {
                    mas[i][j] = 0;
                } else if (i == 0 || i == mas.length - 1 || j > i && j < mas[i].length - i ||
                        i > mas.length / 2 && (j == mas[i].length / 2 || j > 1 && j < mas[i].length - 2)) {
                    mas[i][j] = rand.nextInt(2, 10);
                } else {
                    mas[i][j] = rand.nextInt(-10, -2);
                }
                System.out.printf("%4d", mas[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }
}