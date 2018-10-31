import java.util.Scanner;

class solution1 {

    public static int Solution1(int N) {
        return binaryGap(N, 0, 0, 0);
    }

    public static int binaryGap(int n, int counter, int max, int index) {
        if (n == 0)
            return max;

        if (n % 2 == 0 && index == 0)
            index = 0;

        else if (n % 2 == 0)
            counter++;
        else {
            max = Math.max(counter, max);
            index++;
            counter = 0;
        }
        n = n / 2;

        return binaryGap(n, counter, max, index);
    }



        public static void main (String[] args){
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter number:");
            int x = sc.nextInt();
            System.out.println(Solution1(x));
        }
    }