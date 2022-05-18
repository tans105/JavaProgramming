package competitiveProgramming.geekforgeeks.phase1;

//https://www.geeksforgeeks.org/oyorooms-interview-experience-set-12-4-experience-backend-developer/
public class FetchEachNumberFromString {
    public static void main(String[] args) {
        String s = "xyzonexyzthreeabrdcminusfourctgdeight";
        int i = 0;
        int sum = 0;
        boolean isMinus = false;
        try {
            while (i < s.length()) {
                switch (s.charAt(i)) {
                    case 'o':
                        if (checkO(s.substring(i)) && !isMinus) {
                            sum = sum + 1;
                            i = i + 3;
                        }
                        if (checkO(s.substring(i)) && isMinus) {
                            sum = sum - 1;
                            isMinus = false;
                            i = i + 3;
                        }
                        i++;
                        break;
                    case 'f': {
                        if (checkF(s.substring(i), 0) && !isMinus) {
                            sum = sum + 5;
                            i = i + 4;
                        }
                        if (checkF(s.substring(i), 0) && isMinus) {
                            sum = sum - 5;
                            isMinus = false;
                            i = i + 4;
                        }
                        if (checkF(s.substring(i), 1) && !isMinus) {
                            sum = sum + 4;
                            i = i + 4;
                        }
                        if (checkF(s.substring(i), 1) && isMinus) {
                            sum = sum - 4;
                            isMinus = false;
                            i = i + 4;
                        }
                        i++;
                        break;
                    }
                    case 't': {
                        if (checkT(s.substring(i), 0) && !isMinus) {
                            sum = sum + 3;
                            i = i + 5;
                        }
                        if (checkT(s.substring(i), 0) && isMinus) {
                            sum = sum - 3;
                            isMinus = false;
                            i = i + 5;
                        }
                        if (checkT(s.substring(i), 1) && !isMinus) {
                            sum = sum + 2;
                            i = i + 3;
                        }
                        if (checkT(s.substring(i), 1) && isMinus) {
                            sum = sum - 2;
                            isMinus = false;
                            i = i + 5;
                        }
                        i++;
                        break;
                    }
                    case 's': {
                        if (checkS(s.substring(i), 0) && !isMinus) {
                            sum = sum + 7;
                            i = i + 5;
                        }
                        if (checkS(s.substring(i), 0) && isMinus) {
                            sum = sum - 7;
                            isMinus = false;
                            i = i + 5;
                        }
                        if (checkS(s.substring(i), 1) && !isMinus) {
                            sum = sum + 6;
                            i = i + 3;
                        }
                        if (checkS(s.substring(i), 1) && isMinus) {
                            sum = sum - 6;
                            isMinus = false;
                            i = i + 3;
                        }
                        i++;
                        break;
                    }
                    case 'e':
                        if (checkE(s.substring(i)) && !isMinus) {
                            sum = sum + 8;
                            i = i + 5;
                        }
                        if (checkE(s.substring(i)) && isMinus) {
                            sum = sum - 8;
                            isMinus = false;
                            i = i + 5;
                        }
                        i++;
                        break;
                    case 'n':
                        if (checkN(s.substring(i)) && !isMinus) {
                            sum = sum + 9;
                            i = i + 4;
                        }
                        if (checkN(s.substring(i)) && isMinus) {
                            sum = sum - 9;
                            isMinus = false;
                            i = i + 4;
                        }
                        i++;
                        break;
                    case 'm':
                        isMinus = true;
                        i = i + 5;
                        break;

                    default:
                        i++;
                        break;
                }
            }
        } catch (Exception ignored) {

        }
        System.out.println(sum);
    }

    private static boolean checkO(String s) {
        return s.contains("one");
    }

    private static boolean checkF(String s, int set) {
        if (set == 1) { // four
            return s.contains("four");
        } else { //five
            return s.contains("five");
        }
    }

    private static boolean checkT(String s, int set) {
        if (set == 1) { // two
            return s.contains("two");
        } else { //three
            return s.contains("three");
        }
    }

    private static boolean checkS(String s, int set) {
        if (set == 1) { // six
            return s.contains("six");
        } else { //seven
            return s.contains("seven");
        }
    }

    private static boolean checkE(String s) {
        return s.contains("eight");
    }

    private static boolean checkN(String s) {
        return s.contains("nine");
    }

    private static boolean checkM(String s) {
        return s.contains("minus");
    }
}
