package competitiveProgramming.hackerarth;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Duration {
	public static void main(String args[]) throws Exception {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		for (int i = 0; i < num; i++) {
			String time1 = sc.nextInt() + ":" + sc.nextInt() + ":00";
			String time2 = sc.nextInt() + ":" + sc.nextInt() + ":00";
			SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
			Date date1 = format.parse(time1);
			Date date2 = format.parse(time2);
			Double difference = (double) (date2.getTime() - date1.getTime());
			difference = difference / 1000;
			Double hour = (Double) Math.floor(difference / 3600);
			Double val = difference / 3600;
			Double minute = (Double) ((val - Math.floor(val)) * 60);
			System.out.println(hour.intValue() + " " + minute.intValue());
		}
	}
}
