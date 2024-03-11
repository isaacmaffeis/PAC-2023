package _2023_feb;

/*
 * Dato un albero binario T con chiavi numeriche e di altezza h, un numero soglia N,
 * definiamo la mappa-di-bit-ad-N di T un array mappa[0,h] in cui la cella mappa[j]
 * contiene 1 se la somma delle chiavi dei nodi dell'albero che si trovano ad
 * altezza j è minore o uguale ad N, 0 altrimenti. Scrivere un algoritmo di tipo
 * divide-et-impera che calcoli la mappa-di-bit-ad-N di un albero binario T.
 * Calcolare la complessità dell’algoritmo proposto.
 */

class TreeNode {
    int key;
    TreeNode left, right;
    
    TreeNode(int value) {
        key = value;
        left = right = null;
    }
}

public class BitMapCalculator {
    public int[] computeBitMap(TreeNode root, int N) {
        int height = getHeight(root);
        int [] sumHeight = new int[height + 1];
        int [] bitmap = new int [height + 1];
        
        computeBitMapUtil(root, N, sumHeight, bitmap, height);
        /*
        for(int i=0; i < sumHeight.length ; i++) {
        	bitmap[i] = sumHeight[i] <= N ? 1 : 0;
        }*/
        
        return bitmap;
    }
    
    private void computeBitMapUtil(TreeNode node, int N, int[] sumHeight, int[] bitmap, int level) {
        if (node == null)
            return;
        
        sumHeight[level] += node.key;
        bitmap[level] = sumHeight[level] <= N ? 1 : 0;
        
        computeBitMapUtil(node.left, N, sumHeight, bitmap, level - 1);
        computeBitMapUtil(node.right, N, sumHeight, bitmap, level - 1);
    }
    
    private int getHeight(TreeNode node) {
        if (node == null)
            return -1;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    public static void main(String[] args) {
        BitMapCalculator calculator = new BitMapCalculator();
        
        // Esempio di albero
        // 3
        TreeNode root = new TreeNode(10);
        // 2
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        // 1
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(5);
        // 0
        root.left.left.left = new TreeNode(15);
        root.left.left.right = new TreeNode(1);
        root.right.right.right = new TreeNode(2);

        
        int N = 17;
        int[] bitMap = calculator.computeBitMap(root, N);
        
        System.out.println("Bit map for N = " + N + ":");
        for (int i = 0; i < bitMap.length; i++) {
            System.out.println("Level " + i + ": " + bitMap[i]);
        }
    }
}
