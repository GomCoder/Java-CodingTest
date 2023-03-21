package ch04;

import java.util.Scanner;

//int형 고정길이 스택의 사용 예
public class ch04_02_IntStackTester {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);
        ch04_01_IntStack s = new ch04_01_IntStack(64); //최대 64개를 푸시 할 수 있는 스택

        while(true) {
            System.out.println();
            //데이터를 구분하는 행 주가
            System.out.printf("현재 데이터의 개수: %d / %d\n", s.size(), s.getCapacity());
            System.out.print("(1) 푸시 (2) 팝  (3) 피크 (4) 덤프 (5) 종료: ");

            int menu = stdIn.nextInt();

            if(menu == 0) {
                break;
            }

            int x;

            switch(menu) {
                case 1: //푸시
                    System.out.print("데이터: ");
                    x = stdIn.nextInt();

                    try {
                        s.push(x);
                    } catch(ch04_01_IntStack.OverflowIntStackException e) {
                        System.out.println("스택이 가득 찼습니다.");
                    }
                    break;

                case 2: //팝
                    try {
                        x = s.pop();
                        System.out.println("팝한 데이터는 " + x + "입니다.");
                    } catch(ch04_01_IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 3:
                    try { //피크
                        x = s.peek();
                        System.out.println("피크한 데이터는 " + x + "입니다.");
                    } catch(ch04_01_IntStack.EmptyIntStackException e) {
                        System.out.println("스택이 비어 있습니다.");
                    }
                    break;

                case 4: //덤프
                    s.dump();
                    break;
            }
        }
    }
}

