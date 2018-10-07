package competitiveProgramming.hackerarth;
//https://www.hackerearth.com/practice/basic-programming/input-output/basics-of-input-output/practice-problems/algorithm/seating-arrangement-1/

public class SeatingArrangment {
	public static void main(String[] args) {
		int seatNumber = 22;
		int direction = getDirection(seatNumber);
		String result = getResult(seatNumber, direction);
		System.out.println(result);
	}

	private static int getDirection(int seatNumber) {
		int direction = ((seatNumber - 1) / 6) % 2;
		return direction; // 1->reverse
	}

	private static String getResult(int seatNumber, int direction) {
		int offset = (seatNumber - 1) % 6 + 1;
		String seatType = new String();
		int oppositeSeat = 0; 
		if (direction == 0) {// normal
			switch (offset) {
			case 1:
				seatType = "WS";
				oppositeSeat = seatNumber + 11;
				break;
			case 2:
				seatType = "MS";
				oppositeSeat = seatNumber + 9;
				break;
			case 3:
				seatType = "AS";
				oppositeSeat = seatNumber + 7;
				break;
			case 4:
				seatType = "AS";
				oppositeSeat = seatNumber + 5;
				break;
			case 5:
				seatType = "MS";
				oppositeSeat = seatNumber + 3;
				break;
			case 6:
				seatType = "WS";
				oppositeSeat = seatNumber + 1;
				break;
			}
		} else {// reverse
			switch (offset) {
			case 1:
				seatType = "WS";
				oppositeSeat = seatNumber - 1;
				break;
			case 2:
				seatType = "MS";
				oppositeSeat = seatNumber - 3;
				break;
			case 3:
				seatType = "AS";
				oppositeSeat = seatNumber - 5;
				break;
			case 4:
				seatType = "AS";
				oppositeSeat = seatNumber - 7;
				break;
			case 5:
				seatType = "MS";
				oppositeSeat = seatNumber - 9;
				break;
			case 6:
				seatType = "WS";
				oppositeSeat = seatNumber - 11;
				break;
			}
		}
		return oppositeSeat+" "+seatType;
	}
}
