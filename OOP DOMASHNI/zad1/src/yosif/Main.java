package yosif;

import java.util.*;

public class Main {
    static void generateCombinations(List<Integer> set, int k , String prefix, List<Integer> data) {
        if (k == 0) {
            data.add(Integer.parseInt(prefix));
            return;
        }
        for (int j : set) {
            String newPrefix = prefix + j;
            generateCombinations(set, k - 1, newPrefix, data);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        if (num < 1 || num > 600000) return;

        List<Integer> specialDigits = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            if (num % i == 0) {
                specialDigits.add(i);
            }
        }

        List<Integer> specialNumbers = new ArrayList<>();
        generateCombinations(specialDigits,4,"",specialNumbers);
        System.out.println("The special numbers are: " + specialNumbers);
    }
}
