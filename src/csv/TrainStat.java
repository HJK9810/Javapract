package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class TrainStat {
    public static void main(String[] args) {
        ArrayList<String> dates = new ArrayList<>();

        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\saiiy\\Documents\\csv\\한국철도공사_정차역별 역무열차종별 승하차인원수_20201231.csv"));
            Charset.forName("euc-kr");
            String line;
            while ((line = br.readLine()) != null) {
                String[] ary = line.split(",");

                if(ary[4].equals("승차인원수")) continue;
                if(!dates.contains(ary[0])) {
                    dates.add(ary[0]);
                    in.add(Integer.parseInt(ary[4]));
                    out.add(Integer.parseInt(ary[5]));
                } else {
                    int idx = dates.indexOf(ary[0]);
                    in.set(idx, in.get(idx) + Integer.parseInt(ary[4]));
                    out.set(idx, out.get(idx) + Integer.parseInt(ary[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for(int i=0;i<dates.size();i++) {
            System.out.println(dates.get(i)+" - 승차 : " + in.get(i)+", 하차 : "+out.get(i));
        }
    }
}