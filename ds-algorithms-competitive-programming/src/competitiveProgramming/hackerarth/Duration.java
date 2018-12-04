package competitiveProgramming.hackerarth;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Duration {
	public static void main(String args[] ) throws Exception {
        String time1 = "2:42:00";
		String time2 = "8:23:00";
 
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
		Date date1 = format.parse(time1);
		Date date2 = format.parse(time2);
		Double difference = (double) (date2.getTime() - date1.getTime());
		difference = difference/1000;
		Double hour = (Double) Math.floor(difference/3600);
		System.out.println(hour.intValue());
		Double val = difference/3600;
		Double minute = (Double) ((val - Math.floor(val))*60);
		System.out.println(minute.intValue());
    }
}
