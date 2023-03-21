package Ch02;
//배열 요소의 최대값을 출력(값을 입력받음)

import java.util.Scanner;

public class ch02_03_MaxOfArray {
    //배열 a의 최대값을 구하여 반환
    static int maxOf(int[] a) {
        int max = a[0];

        for(int i = 0; i < a.length; i++) {
            if(a[i] > max) {
                max = a[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");

        System.out.print("사람 수: ");
        int num = stdin.nextInt(); //배열의 요소수를 입력받음

        int[] height = new int[num]; //요소수가 num인 배열을 생성

        //사람 수만큼 키를 입력받음
        for(int i = 0; i < num; i++) {
            System.out.print("height[" + i + "]: ");
            height[i] = stdin.nextInt();
        }

        //최대값을 구하여 출력함
        System.out.print("최대값은 " + maxOf(height) + "입니다.");

    }
}
