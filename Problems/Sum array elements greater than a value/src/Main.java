import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int len = scanner.nextInt();
        int[] arr = new int[len];

        for (int i = 0; i < len; i++) {
            arr[i] = scanner.nextInt();
        }

        int n = scanner.nextInt();
        int sum = 0;

        for (int a : arr) {
            if (a > n) {
                sum += a;
            }
        }

        System.out.println(sum);
    }
}