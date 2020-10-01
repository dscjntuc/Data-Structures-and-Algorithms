import java.util.Scanner;

public class BubbleSort {
    public void bubbleSort(int[] data) {
        for (int i = 0; i < (data.length - 1); i++) {
            for (int j = 0; j < (data.length - i - 1); j++) {
                if (data[j] > data[j + 1]) {
                    int temp = data[j];
                    data[j] = data[j + 1];
                    data[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bs = new BubbleSort();

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the amount of numbers you want to sort : ");
        int sum = sc.nextInt();

        int[] data = new int[sum];
        for(int i=0; i<sum; i++) {
            System.out.print("Enter number " + (i+1) + " : ");
            data[i] = sc.nextInt();
        }

        bs.bubbleSort(data);

        System.out.println("\nResult :");
        for(int i=0; i<sum; i++) {
            System.out.print(data[i] + " ");
        }
    }
}