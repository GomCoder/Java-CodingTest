package Ch02;
//신체검사 데이터를 클래스 배열에서 평균 키와 시력의 분포를 구함

public class ch02_10_PhysicalExamination {

    static final int VMAX = 21; //시력 분포(0.0~0.1 단위로 21개)

    static class PhysicalData {
        String name; //이름
        int height; //키
        double vision; //시력

        //생성자
        PhysicalData(String name, int height, double vision) {
            this.name = name;
            this.height = height;
            this.vision= vision;
        }
    }

    //키의 평균을 구함
    static double averageHeight(PhysicalData[] data) {
        double sum = 0;

        for(int i = 0;i < data.length; i++) {
            sum += data[i].height;
        }
        return sum / data.length;
    }

    //시력 분포를 구함
    static void distVision(PhysicalData[] data, int[] dist) {
        int i = 0;
        dist[i] = 0;

        for(i = 0; i < data.length; i++) {
            if(data[i].vision >= 0.0 && data[i].vision <= VMAX / 10.0) {
                dist[(int)(data[i].vision*10)]++;
            }
        }
    }

    public static void main(String[] args) {
        //키와 시력 입력
        PhysicalData[] x = {
                new PhysicalData("강민하", 162, 0.3),
                new PhysicalData("김찬우", 173, 0.7),
                new PhysicalData("박준서", 175, 2.0),
                new PhysicalData("유서범", 171, 1.5),
                new PhysicalData("이수연", 168, 0.4),
                new PhysicalData("장경호", 174, 1.2),
                new PhysicalData("황지안", 169, 0.8),
        };

        int[] vdist = new int[VMAX]; //시력 분포

        System.out.println("※  신체 검사 리스트  ※");
        System.out.println("이  름     키   시력");
        System.out.println("------------------");

        for(int i = 0; i < x.length; i++) {
            System.out.printf("%-8s%3d%5.1f\n", x[i].name, x[i].height, x[i].vision);
        }

        System.out.printf("\n평균 키: %5.1fcm\n", averageHeight(x));

        distVision(x, vdist);

        System.out.println("\n시력 분포");
        for(int i = 0; i < VMAX; i++) {
            System.out.printf("%3.1f~: %2d명\n", i / 10.0, vdist[i]);
        }
    }
}
