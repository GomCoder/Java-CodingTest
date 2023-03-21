package Ch01;
//For 문으로 1, 2, 3, ..., n의 합을 구함

import java.util.Scanner;

public class ch01_08_SumFor {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.println("1부터 n까지의 합을 구합니다.");
        System.out.println("n의 값: ");
        int n = stdIn.nextInt();

        int sum = 0;

        for(int i = 1; i <= n; i++){
            sum += i;
        }

        System.out.println("1부터 " + n + "까지의 합은 " + sum + "입니다.");
    }
}
