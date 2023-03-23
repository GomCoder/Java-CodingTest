package ch05;
//재귀 함수 이해

import java.util.Scanner;




public class ch05_05_RecurX2 {

   static class IntStack {
        private int[] stk; //스택용 배열: 푸시된 데이터를 저장하는 스택용 배열
        private int capacity; //스택 용량: 스택에 쌓을 수 있는 최대 데이터의 수
        private int ptr; //스택 포인터: 스택에 쌓여 있는 데이터 수를 나타내는 필드(주소)

        //실행 시 예외: 스택이 비어있음
        public class EmptyIntStackException extends RuntimeException {
            public EmptyIntStackException() {}
        }

        //실행 시 예외: 스택이 가득 참
        public class OverflowIntStackException extends RuntimeException {
            public OverflowIntStackException() {}
        }

        //생성자: 스택용 배열 본체를 생성하는 등 준비작업
        public IntStack(int maxlen) {
            ptr = 0;
            capacity = maxlen;
            try {
                stk = new int[capacity]; //스택 본체용 배열을 생성
            } catch (OutOfMemoryError e) { //생성할 수 없음
                capacity = 0;
            }
        }

        //스택에 x를 푸시: 스택에 데이터를 푸시하는 메서드
        public int push(int x) throws IntStack.OverflowIntStackException {
            if(ptr >= capacity) { //스택이 가득 참
                throw new IntStack.OverflowIntStackException();
            }
            return stk[ptr++] = x;
        }

        //스택에서 데이터를 팝(꼭대기에 있는 데이터를 꺼냄)
        public int pop() throws IntStack.EmptyIntStackException {
            if(ptr <= 0) { //스택이 비어 있음
                throw new IntStack.EmptyIntStackException();
            }
            return stk[--ptr];
        }

        //스택에서 데이터를 피크(꼭대이게 있는 데이터를 들여다 봄)
        public int peek() throws IntStack.EmptyIntStackException {
            if(ptr <= 0) {
                throw new IntStack.EmptyIntStackException();
            }
            return stk[ptr - 1];
        }

        //스택을 비움
        public void clear() {
            ptr = 0;
        }

        //스택에서 x를 찾아 인덱스(없으면 -1)를 반환
        public int indexOf(int x) {
            for(int i = ptr -1; i >= 0; i--) { //꼭대기 쪽부터 선형 검색
                if(stk[i] == x) {
                    return i; //검색 성공
                }
            }
            return -1; //검색 실패
        }

        //스택의 용량을 반환
        public int getCapacity() {
            return capacity;
        }

        //스택에 쌇여 있는 데이터 개수를 반환
        public int size() {
            return ptr;
        }

        //스택이 비어 있는가?
        public boolean isEmpty() {
            return ptr <= 0;
        }

        //스택이 가득 찼는가?
        public boolean isFull() {
            return ptr >= capacity;
        }

        //스택 안의 모든 데이터를 [바닥 ~> 꼭대기 순서로] 출력: 스택에 쌓여 있는
        public void dump() {
            if (ptr <= 0){
                System.out.println("스택이 비어 있습니다.");
            } else {
                for(int i = 0; i < ptr;i++) {
                    System.out.print(stk[i]+ " ");
                }
                System.out.println();
            }

        }
    }

    //재귀를 제거
   static void recur(int n) {
       IntStack s = new IntStack(n);

       while(true) {
           if(n > 0) {
               s.push(n); //n 값을 푸시
               n = n - 1;
               continue;
           }

           if(s.isEmpty() != true) { //스택이 비어 있지 않으면
               n = s.pop(); //저장하고 있던 스택값을 팝
               System.out.println(n);
               n = n - 2;
               continue;
           }
           break;
       }
   }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        System.out.print("정수를 입력하세요: ");
        int x = stdIn.nextInt();

        recur(x);
    }
}
