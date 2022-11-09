import java.util.Scanner;


//Описание решаемой задачи:
/*
You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer.
The digits are ordered from most significant to least significant in left-to-right order.
The large integer does not contain any leading 0's.
Increment the large integer by one and return the resulting array of digits.
 */
public class Main {
    public static void main (String[] args) {
        Solution solution = new Solution();
        Scanner s = new Scanner(System.in);

        int size = s.nextInt();
        int[] digitsArray = new int[size];
        for (int t = 0; t < size; t++) {
            digitsArray[t] =  s.nextInt();
        }

        int[] plusOneMassive = solution.plusOne(digitsArray);
        for(int i = 0; i < plusOneMassive.length; i++) {
            System.out.print(plusOneMassive[i] + " ");
        }


    }
}



class Solution {
    int notZeroGlobal = -10;
    public int plusOneRecursive (int[] n, int t) {
        if (t >= 0) {
            if((n[t] + 1) / 10 != 0) {
                System.out.println("Значение участвующей в процессе переменной" + " " + t);
                t = t - 1;
                notZeroGlobal = t;
                plusOneRecursive(n, t);
            }
        }
        System.out.println("Значение возвращаемой переменной" + " " + t);
        return t;
    }

    public int[] plusOne(int[] digits) {

        plusOneRecursive(digits, digits.length - 1);
        int notZero;
        if(notZeroGlobal == - 10) {
           notZero = digits.length - 1;
        }
        else notZero = notZeroGlobal;
        if (notZero >= 0) {
            digits[notZero] = digits[notZero] + 1;
            for(int i = digits.length - 1; i > notZero; i--) {
                digits[i] = 0;
            }
            return digits;
        }
        else {
            System.out.println("Hey, I'm here!");
            int[] digitsPlusOne = new int [digits.length + 1];
            for (int i = digits.length; i > 0; i--) {
                digitsPlusOne[i] = 0;
            }
            digitsPlusOne[0] = 1;
            return digitsPlusOne;
        }
    }
}
