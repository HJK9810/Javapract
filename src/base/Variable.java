package base;

public class Variable {
    public static double Lightdistance() {
        double distance = 40e12;
        final double lightfast = 3e5; // 빛의 속도는 변하지 않음 = 상수

        double lightyear = lightfast * (60 * 60 * 24 * 365);

        return distance / lightyear;
    }
    public static void main(String[] args) {
        System.out.println("걸리는 시간은"+ Lightdistance() +"광년입니다.");
    }
}
