package base;

public class Variable {
    public static double Lightdistance() {
        double distance = 40e12;
        final double lightfast = 3e5; // 빛의 속도는 변하지 않음 = 상수

        double lightyear = lightfast * (60 * 60 * 24 * 365);

        return distance / lightyear;
    }

    public static double QudraticFormular(double a, double b, double c) {
//        근의공식 : (-b +- 루트(b^2 - 4ac)) / 2a
        double x1 = (-b + Math.sqrt(b * b - 4 * a * c)) / 2 * a;
        double x2 = (-b - Math.sqrt(b * b - 4 * a * c)) / 2 * a;

        System.out.printf("근은 %.1f\n", x1);
        System.out.printf("근은 %.1f\n", x2);
        return 0;
    }

    public static void main(String[] args) {
//        System.out.println("걸리는 시간은"+ Lightdistance() +"광년입니다.");
        QudraticFormular(1, -3.0, 2.0);
    }

}