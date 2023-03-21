package Ch01;
//2자리의 양수(10~99)를 입력

import java.util.Scanner;

public class ch01C_02_TwoDigits {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        int no;

        System.out.println("2자리의 양수를 입력하세요.");

        /*do {
            System.out.print("no값: ");
            no = stdIn.nextInt();
        } while(no < 10 || no > 99);*/

        do {
            System.out.print("no값: ");
            no = stdIn.nextInt();
        } while(!(no >= 10 && no <= 100));

        System.out.println("변수 no값은 " + no + "이 되었습니다.");
    }
}
