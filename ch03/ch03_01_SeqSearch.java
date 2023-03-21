package ch03;
//선형 검색

import java.util.Scanner;

public class ch03_01_SeqSearch {
    //요소수가 n인 배열 a에서 key와 값이 같은 요소를 선형 검색

    static int seqSearch(int[] a, int n, int key) {
        int i = 0;

        while(true) {
            if( i == n) {
                return -1;
            }

            if( a[i] == key) {
                return i;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("요소 수: ");
        int num = stdIn.nextInt();
        int[] x = new int[num]; //요소수가 num인 배열

        for(int i = 0; i < num; i++) {
            System.out.print("x[" + i + "]: ");
            x[i] = stdIn.nextInt();
        }

        System.out.print("겸색할 값: "); //key 값을 입력 받음
        int key = stdIn.nextInt();

        int idx = seqSearch(x, num, key); //배열 x에서 값이 key인 요소를 검색

        if(idx == -1) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
        }
    }
}
