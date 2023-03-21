package Ch02;
//구성 요소의 자료형이 int형인 배열(구성 요소수는 5, new에 의해 배열의 본체를 생성)

public class ch02_01_IntArray {
    public static void main(String[] args) {
        int[] a = new int[5]; // new에 의해 배열의 본체를 생성

        a[1] = 37;
        a[2] = 51;
        a[4] = a[1]*2;

        for(int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = " + a[i]);
        }
    }
}
