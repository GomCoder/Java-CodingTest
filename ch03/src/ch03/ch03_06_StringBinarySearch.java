package ch03;
//문자열의 배열(자바의 키워드)에서 검색
//자연 정렬이 된 배열에서 검색하기
import java.util.Arrays;
import java.util.Scanner;

public class ch03_06_StringBinarySearch {
    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        //자바에서 사용하는 메서드
        String[] x = {
                "abstract", "assert", "boolean", "break", "byte",
                "case", "catch", "char", "class", "const",
                "continue", "default", "do", "double", "else",
                "enum", "extends", "final", "finally", "float",
                "for", "goto", "if", "implements", "import",
                "instanceof", "int", "interface", "long", "native",
                "new", "pakage", "private", "protected", "public",
                "return", "short", "static", "strictfp", "super",
                "switch", "syncronized", "this", "throw", "throws",
                "transient", "try", "void", "volatile", "while"
        };

        System.out.print("원하는 키워드를 입력하세요: "); //키 값을 입력
        String key = stdIn.next();

        int idx = Arrays.binarySearch(x, key); //배열 x에서 값이 key인 요소를 검색

        if(idx < 0) {
            System.out.println("해당 키워드가 없습니다.");
        } else {
            System.out.println("해당 키워드는 x[" + idx + "]에 입습니다.");
        }
    }
}
