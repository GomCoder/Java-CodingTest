package Ch01;
//1, 2, 3,...,n의 합과 그 값을 구하는 과정을 출력(2)

import java.util.Scanner;

public class ch01_12_Alternarive1a {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("+와 -를 번갈아 n개 출력합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while(n <= 0);

        int sum = 0;

        for(int i = 1; i <= n ; i++){
           if( i % 2 == 0) {
               System.out.print("-"); //짝수
           } else {
               System.out.print("+"); //홀수
           }
        }
    }
}
