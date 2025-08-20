import java.util.*;

public class M03_TopKConvenience {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // 讀取 n 和 K
        int n = scanner.nextInt();
        int k = scanner.nextInt();
        scanner.nextLine(); // 清除換行符號

        // 儲存商品名稱與銷量的清單
        List<Item> items = new ArrayList<>();

        // 讀取商品名稱與銷量
        for (int i = 0; i < n; i++) {
            String name = scanner.next();
            int qty = scanner.nextInt();
            items.add(new Item(name, qty));
        }

        // 使用 PriorityQueue 實現 Top-K
        PriorityQueue<Item> pq = new PriorityQueue<>(Comparator.comparingInt(Item::getQty).reversed()
                .thenComparing(Item::getName));

        pq.addAll(items);

        // 輸出 Top-K 結果
        int count = 0;
        while (!pq.isEmpty() && count < k) {
            Item item = pq.poll();
            System.out.println(item.getName() + " " + item.getQty());
            count++;
        }

        scanner.close();
    }

    // 定義商品類別
    static class Item {
        private String name;
        private int qty;

        public Item(String name, int qty) {
            this.name = name;
            this.qty = qty;
        }

        public String getName() {
            return name;
        }

        public int getQty() {
            return qty;
        }
    }
}