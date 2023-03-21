package ch03;
//신체검사 데이터 배열에서 이진 검색

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ch03_08_PhysExamSerach {
    //신체검사 데이터를 정의
    static class PhysData {
        private String name; //이름
        private int height; //키
        private double vision; //시력

        //생성자
        public PhysData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision = vision;
        }

        //문자열로 만들어 반환하는 메서드
        public String toString() {
            return name + " " + height + " " + vision;
        }

        //키의 오름차순으로 정렬하기 위한 conparator
        public static final Comparator<PhysData> HEIGHT_ORDER =
                new HeightOrderComparator();

        private static class HeightOrderComparator implements Comparator<PhysData> {
            public int compare(PhysData d1, PhysData d2) {
                return (d1.height > d2.height) ? 1:
                        (d1.height < d2.height) ? -1 : 0;
            }
        }
    }

    public static void main(String[] args) {
        Scanner stdIn = new Scanner(System.in);

        PhysData[] x = {
                new PhysData("강민하",162,0.3),
                new PhysData("이수연",168,0.4),
                new PhysData("황지안",169,0.8),
                new PhysData("유서범",171,1.5),
                new PhysData("김찬우",173,0.7),
                new PhysData("장경오",174,1.2),
                new PhysData("박준서",175,2.0),
        };

        System.out.print("키가 몇 cm인 사람을 찾고 있나요?: ");
        int height = stdIn.nextInt(); //키 값 입력받음
        int idx = Arrays.binarySearch(
                x, //배열 x에서
                new PhysData("", height, 0.0), //키가 height인 요소를
                PhysData.HEIGHT_ORDER //HEIGHT_ORDER에 의해 검색
        );

        if(idx < 0) {
            System.out.println("그 값의 요소가 없습니다.");
        } else {
            System.out.println("그 값은 x[" + idx + "]에 있습니다.");
            System.out.println("찾은 데이터: " + x[idx]);
        }
    }
}
