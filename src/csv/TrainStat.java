package csv;

public class TrainStat {
    public static void main(String[] args) {
        ReadCsv rc = new ReadCsv();
        PrintUI pui = new PrintUI();
        String path = "C:\\Users\\saiiy\\Documents\\csv\\한국철도공사_정차역별 역무열차종별 승하차인원수_20201231.csv";

        pui.printcheck();
        rc.Qurterly(path);
    }
}