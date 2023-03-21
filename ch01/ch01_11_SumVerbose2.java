package Ch01;
//1, 2, 3,...,n의 합과 그 값을 구하는 과정을 출력(2)

import java.util.Scanner;

public class ch01_11_SumVerbose2 {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int n;

        System.out.println("1부터 n까지의 합을 구합니다.");

        do {
            System.out.print("n값: ");
            n = stdIn.nextInt();
        } while(n <= 0);

        int sum = 0;

        for(int i = 1; i < n ; i++){
            System.out.print(i + " + ");
            sum += i;
        }

        /*System.out.print(n + " = ");
        sum += n;
        System.out.println(sum);*/

        System.out.println(n + " = " + (sum += n)); //복합 대입 연산자 사용
    }
}
