package Ch01;
//3개의 정수값을 입력하고 최대값을 구하여 출력1

import java.util.Scanner;

public class ch01_01_Max3 {
    public static void main(String[] args) {
        int a, b, c;

        Scanner stdIn = new Scanner(System.in);

        System.out.println("세 정수의 최대값을 구합니다.");

        System.out.print("a의 값: ");
        a = stdIn.nextInt();
        System.out.print("b의 값: ");
        b = stdIn.nextInt();
        System.out.print("c의 값: ");
        c = stdIn.nextInt();

        int max = a;

        if(b > max) {
            max = b;
        }

        if(c > max) {
            max = c;
        }

        System.out.println("최대값은 " + max + "입니다.");
    }
}
