package csv;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.ArrayList;

public class ReadCsv {
    public void Qurterly(String path) { // for quterly
        ArrayList<String> days = new ArrayList<>(); // seperate by date

        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Charset.forName("euc-kr"); // change language type
            String line;
            while ((line = br.readLine()) != null) {
                String[] ary = line.split(",");

                if (ary[4].equals("승차인원수")) continue;
                if (!days.contains(ary[0])) { // not same
                    days.add(ary[0]); // yyyy-MM-dd
                    in.add(Integer.parseInt(ary[4]));
                    out.add(Integer.parseInt(ary[5]));
                } else { // add
                    int idx = days.indexOf(ary[0]);
                    in.set(idx, in.get(idx) + Integer.parseInt(ary[4]));
                    out.set(idx, out.get(idx) + Integer.parseInt(ary[5]));
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 0; i < days.size(); i++) {
            System.out.println(days.get(i) + " - 승차 : " + in.get(i) + ", 하차 : " + out.get(i));
        }
    }

    public void culm(String path) { // for accumulate
        ArrayList<String> days = new ArrayList<>(); // seperate by date
        ArrayList<String> Year = new ArrayList<>();

        ArrayList<Integer> dates = new ArrayList<>();
        ArrayList<Integer> years = new ArrayList<>();
        ArrayList<Integer> in = new ArrayList<>();
        ArrayList<Integer> out = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            Charset.forName("euc-kr"); // change language type
            String line;
            int count = 0, ycount = 0, mcount = 0;
            String year = "";
            String month = "";
            while ((line = br.readLine()) != null) {
                String[] ary = line.split(",");

                if (ary[4].equals("승차인원수")) continue;
                if (!days.contains(ary[0])) { // not same
                    days.add(ary[0]); // yyyy-MM-dd
                    in.add(Integer.parseInt(ary[4]));
                    out.add(Integer.parseInt(ary[5]));
                } else { // add
                    int idx = days.indexOf(ary[0]);
                    in.set(idx, in.get(idx) + Integer.parseInt(ary[4]));
                    out.set(idx, out.get(idx) + Integer.parseInt(ary[5]));
                }

                String[] today = ary[0].split("-");

                if (today[2].equals("01")) { // dates is 01
                    dates.add(count);
                    mcount += count;
                    count = 1;
                } else count++;

                if (!today[0].equals(year)) { // year change
                    years.add(mcount);
                    Year.add(year);
                    mcount = 0;
                    year = today[0];
                }
            }
            // for last year
            years.add(mcount);
            Year.add(year);
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (int i = 1; i < years.size(); i++) { // i = 0 -> fist line
            System.out.println(Year.get(i) + " - " + years.get(i));
        }
    }
}
