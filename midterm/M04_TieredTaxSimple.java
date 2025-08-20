import java.util.Scanner;

public class M04_TieredTaxSimple {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取收入筆數
        int n = Integer.parseInt(scanner.nextLine());
        int[] incomes = new int[n];

        // 讀取每筆收入
        for (int i = 0; i < n; i++) {
            incomes[i] = Integer.parseInt(scanner.nextLine());
        }

        // 計算稅額與總稅額
        int totalTax = 0;
        for (int income : incomes) {
            int tax = calculateTax(income);
            totalTax += tax;
            System.out.println("Tax: " + tax);
        }

        // 計算並輸出平均稅額
        int averageTax = totalTax / n;
        System.out.println("Average: " + averageTax);

        scanner.close();
    }

    // 計算稅額的方法
    private static int calculateTax(int income) {
        int tax = 0;

        if (income > 1000000) {
            tax += (income - 1000000) * 30 / 100;
            income = 1000000;
        }
        if (income > 500000) {
            tax += (income - 500000) * 20 / 100;
            income = 500000;
        }
        if (income > 120000) {
            tax += (income - 120000) * 12 / 100;
            income = 120000;
        }
        tax += income * 5 / 100;

        return tax;
    }
}