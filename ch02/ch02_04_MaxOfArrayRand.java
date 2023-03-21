package Ch02;
//배열 요소의 최대값을 출력(값을 난수로 생성)

import java.util.Random;
import java.util.Scanner;

public class ch02_04_MaxOfArrayRand {
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
        Random rand = new Random(); //난수 생성
        Scanner stdin = new Scanner(System.in);

        System.out.println("키의 최대값을 구합니다.");

        System.out.print("사람 수: ");
        int num = stdin.nextInt(); //배열의 요소수를 입력받음

        int[] height = new int[num]; //요소수가 num인 배열을 생성

        System.out.println("키 값은 아래와 같습니다.");
        //사람 수만큼 키를 입력받음
        for(int i = 0; i < num; i++) {
            height[i] = 100 + rand.nextInt(90); //요소값을 난수(0~89)로 결정함
            System.out.println("height[" + i + "]: " + height[i]);
        }

        //최대값을 구하여 출력함
        System.out.print("최대값은 " + maxOf(height) + "입니다.");

    }
}
