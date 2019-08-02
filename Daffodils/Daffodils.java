public class Daffodils {
    public static void main(String[] args) {
        for(int i=100; i <= 999; i++) {
            if(isDaffodils(i)) {
                System.out.println(i);
            }
        }
    }

    public static boolean isDaffodils(int num) {
        int unit = num % 10;
        int decade = (num / 10) % 10;
        int hundreds = num /100;

        int result = unit*unit*unit + decade*decade*decade + hundreds*hundreds*hundreds;

        if(result == num) {
            return true;
        }
        return false;
    }
}