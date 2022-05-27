package backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Basic {
	public static void main(String[] args) throws IOException {
		BufferedWriter output = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuffer str = new StringBuffer();

		str.append("         ,r'\"7\n");
		str.append("r`-_   ,'  ,/\n");
		str.append(" \\. \". L_r'\n");
		str.append("   `~\\/\n");
		str.append("      |\n");
		str.append("      |\n");

		output.write(str.toString());
		output.flush();
		output.close();
	}
}
