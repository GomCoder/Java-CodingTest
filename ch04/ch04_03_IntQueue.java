package ch04;
//int형 고정 길이 큐

public class ch04_03_IntQueue {
    private int[] que; //큐용 배열: 인큐하는 데이터를 저장하기 위한 큐 본체용 배열
    private int capacity; //큐의 용량: 큐의 최대 용량을 지정하는 필드
    private int front; //맨 앞의 요소 커서: 인튜하는 데이터 가운데 맨 앞 요소의 인덱스를 저장하는 필드
    private int rear; //맨 뒤의 요소 커서: 인튜한 데이터 가운데 맨 뒤에 넣은 요소 하나 뒤 인덱스를 저장하는 필드
    private int num; //현재 데이터 개수: 큐에 쌓여 있는 데이터 개수

    //실행 시 예외: 큐가 비어 있음
    public class EmptyIntQueueException extends RuntimeException {
        public EmptyIntQueueException() {}
    }

    //실행 시 예와: 큐가 가득 참
    public class OverflowIntQueueException extends RuntimeException {
        public OverflowIntQueueException(){}
    }

    //생성자: 큐 본체용 배열을 생성하는 등의 준비작업
    public ch04_03_IntQueue(int maxlen) {
        num = front = rear = 0;
        capacity = maxlen;

        try {
            que = new int[capacity]; //큐 본체용 배열을 생성
        } catch(OutOfMemoryError e) { //생설할 수 없음
            capacity = 0;
        }
    }

    //큐에 데이터를 인큐
    public int enque(int x) throws OverflowIntQueueException {
        if(num >= capacity) {
            throw new OverflowIntQueueException(); //큐가 가득 참
        }
        que[rear++] = x;
        num++;

        if(rear == capacity) {
            rear = 0;
        }
        return x;
    }

    //큐에서 데이터를 디큐
    public int deque() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException(); //큐가 비어 있음
        }
        int x = que[front++];
        num--;

        if(front == capacity) {
            front = 0;
        }
        return x;
    }

    //큐에서 데이터를 피크(프런트 데이터를 들여다봄)
    public int peek() throws EmptyIntQueueException {
        if(num <= 0) {
            throw new EmptyIntQueueException();
        }
        return que[front];
    }

    //큐를 비움
    public void clear() {
        num = front = rear = 0;
    }

    //큐에서 x를 검색하여 인덱스(찾지 못하면 -1)를 반환
    public int indexOf(int x) {
        for(int i = 0; i < num; i++) {
            int idx = (i + front) % capacity;

            if(que[idx] == x) {
                return idx; //검색 성공
            }
        }
        return -1; //검색 실패
    }

    //큐의 용량을 반환
    public int getCapacity() {
        return capacity;
    }

    //큐에 쌓여 있는 데이터 개수를 반환
    public int size() {
        return num;
    }

    //큐가 비어 있나요?
    public boolean isEmpty() {
        return num <= 0;
    }

    //큐가 가득 찼나요?
    public boolean isFull() {
        return num >= capacity;
    }

    //큐 안의 모든 데이터를 [프런트 ~> 리어 순서로] 출력
    public void dump() {
        if(num <= 0) {
            System.out.println("큐가 비어 있습니다.");
        } else {
            for(int i = 0; i < num; i++) {
                System.out.print(que[(i + front) % capacity] + " ");
            }
            System.out.println();
        }
    }
}