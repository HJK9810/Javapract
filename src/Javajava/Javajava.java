package Javajava;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Javajava {

    public static void main(String[] args) {

        Javajava javaPj = new Javajava();
        ArrayList<String> arrCsv = javaPj.ReadCsv();
        JavaData[] javaData = new JavaData[arrCsv.size()];

        for (int i = 0; i < javaData.length; i++) {
            javaData[i] = new JavaData();
        }

        cutCsv(arrCsv, javaData);
        printN(javaData, 100);

    }

    public ArrayList<String> ReadCsv() {

        String path = "C:\\Users\\sihyn\\Desktop\\filefilefile.csv";
        ArrayList<String> arrLine = new ArrayList<String>();

        try {
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "UTF-8"));
            String line;

            while ((line = br.readLine()) != null) {
                arrLine.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return (arrLine);
    }

    public static void cutCsv(ArrayList<String> arrList, JavaData[] javadata) {

        for (int i = 0; i < arrList.size(); i++) {
            String[] temp = arrList.get(i).split("\",\"");

            for (int j = 0; j < temp.length; j++) {
                if (temp[j].contains("\"")) {
                    temp[j] = temp[j].replaceAll("\"", "");
                }
                if (temp[j].contains(",")) {
                    temp[j] = temp[j].replaceAll(",", "");
                }
            }

            int k = 0;

            javadata[i].data1 = temp[k];
            javadata[i].data2 = temp[k + 1];
            javadata[i].data3 = temp[k + 2];
            javadata[i].data4 = Integer.parseInt(temp[k + 3]);
            javadata[i].data5 = temp[k + 4];
            javadata[i].data6 = Float.parseFloat(temp[k + 5]);
            javadata[i].data7 = Integer.parseInt(temp[k + 6]);
            javadata[i].data8 = Integer.parseInt(temp[k + 7]);
            javadata[i].data9 = Integer.parseInt(temp[k + 8]);
            javadata[i].data10 = Integer.parseInt(temp[k + 9]);
            javadata[i].data11 = Integer.parseInt(temp[k + 10]);
            javadata[i].data12 = temp[k + 11];
            javadata[i].data13 = temp[k + 12];
            javadata[i].data14 = temp[k + 13];
            javadata[i].data15 = temp[k + 14];

        }
    }

    public static void printN(JavaData[] javadata, int N) {

        int cutN = javadata.length / N;

        for (int i = 0; i < javadata.length + 1; i += cutN) {
            System.out.println("-------------------------------------------");

            int count = 0;

            String cutData1 = "";
            String cutData2 = "";
            String cutData3 = "";
            int cutData4 = 0;
            String cutData5 = "";
            float cutData6 = 0;
            int cutData7 = 0;
            int cutData8 = 0;
            int cutData9 = 0;
            int cutData10 = 0;
            int cutData11 = 0;
            String cutData12 = "";
            String cutData13 = "";
            String cutData14 = "";
            String cutData15 = "";

            for (int j = i; j < cutN + i; j++) {
                if (j == javadata.length) {
                    break;
                }
                count++; // �� ����
            }
            for (int k = i; k < i + count; k++) {

                cutData1 += javadata[k].data1;
                cutData2 += javadata[k].data2;
                cutData3 += javadata[k].data3;
                cutData4 += javadata[k].data4;
                cutData5 += javadata[k].data5;
                cutData6 += javadata[k].data6;
                cutData7 += javadata[k].data7;
                cutData8 += javadata[k].data8;
                cutData9 += javadata[k].data9;
                cutData10 += javadata[k].data10;
                cutData11 += javadata[k].data11;
                cutData12 += javadata[k].data12;
                cutData13 += javadata[k].data13;
                cutData14 += javadata[k].data14;
                cutData15 += javadata[k].data15;

                if (k == javadata.length - 1) {
                    break;
                }
            }

            String stri = "";
            if (isNumbericStr(cutData1)) {
                int ii = (Integer.parseInt(cutData1)) / cutN;
                stri = String.valueOf(ii);
                cutData1 = stri;
            }
            if (isNumbericStr(cutData2)) {
                int ii = (Integer.parseInt(cutData2)) / cutN;
                stri = String.valueOf(ii);
                cutData2 = stri;
            }
//			if (isNumbericStr(cutData3)) {
//				int ii = (Integer.parseInt(cutData3)) / cutN;
//				String stri = String.valueOf(ii);
//				cutData3 = stri;
//			}
            stri = String.valueOf(cutData4);
            if (isNumbericStr(stri)) {
                cutData4 = cutData4 / cutN;
            }
            stri = String.valueOf(cutData6);
            if (isNumbericStr(stri)) {
                cutData6 = cutData6 / (float) cutN;
            }
            stri = String.valueOf(cutData7);
            if (isNumbericStr(stri)) {
                cutData7 = cutData7 / cutN;
            }
            stri = String.valueOf(cutData8);
            if (isNumbericStr(stri)) {
                cutData8 = cutData8 / cutN;
            }
            stri = String.valueOf(cutData9);
            if (isNumbericStr(stri)) {
                cutData9 = cutData9 / cutN;
            }
            stri = String.valueOf(cutData10);
            if (isNumbericStr(stri)) {
                cutData10 = cutData10 / cutN;
            }
            stri = String.valueOf(cutData11);
            if (isNumbericStr(stri)) {
                cutData11 = cutData11 / cutN;
            }
            if (isNumbericStr(cutData12)) {
                int ii = (Integer.parseInt(cutData12)) / cutN;
                stri = String.valueOf(ii);
                cutData12 = stri;
            }
//			if (isNumbericStr(cutData13)) {
//				int ii = (Integer.parseInt(cutData13)) / cutN;
//				String stri = String.valueOf(ii);
//				cutData13 = stri;
//			}
            if (isNumbericStr(cutData14)) {
                int ii = (Integer.parseInt(cutData14)) / cutN;
                stri = String.valueOf(ii);
                cutData14 = stri;
            }
            if (isNumbericStr(cutData15)) {
                int ii = (Integer.parseInt(cutData15)) / cutN;
                stri = String.valueOf(ii);
                cutData15 = stri;
            }

            writeCsv(cutData1, cutData2, cutData3, cutData4, cutData5, cutData6, cutData7, cutData8, cutData9,
                    cutData10, cutData11, cutData12, cutData13, cutData14, cutData15);
        }
    }


    public static boolean isNumbericStr(String str) { // ���� �Ǻ��ռ�
        boolean result = true;

        try {
            for (int i = 0; i < str.length(); i++) { // ����
                if (Character.isDigit(str.charAt(i)) == true) {
                } else { // ����
                    result = false;
                }
            }
        } catch (Exception e) {
            result = false;
        }
        return result;
    }

    public static void writeCsv(String d1, String d2, String d3, int d4, String d5, float d6, int d7, int d8, int d9,
                                int d10, int d11, String d12, String d13, String d14, String d15) {

        File file = new File("C:\\Users\\sihyn\\Desktop\\resultCsvFile.csv");

        String strd4 = String.valueOf(d4);
        String strd6 = String.valueOf(d6);
        String strd7 = String.valueOf(d7);
        String strd8 = String.valueOf(d8);
        String strd9 = String.valueOf(d9);
        String strd10 = String.valueOf(d10);
        String strd11 = String.valueOf(d11);
        String dv = "\",\"";
        String dqm = "\"";
        String etr = "\n";

        try {

            if (!file.exists()) {
                file.createNewFile();
            }

            FileWriter fw = new FileWriter(file, true);
            BufferedWriter bw = new BufferedWriter(fw);

            bw.write(dqm + d1 + dv + d2 + dv + d3 + dv + strd4 + dv + d5 + dv + strd6 + dv + strd7 + dv + strd8 + dv
                    + strd9 + dv + strd10 + dv + strd11 + dv + d12 + dv + d13 + dv + d14 + dv + d15 + dqm + etr);

            bw.close();

        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
    }
}
