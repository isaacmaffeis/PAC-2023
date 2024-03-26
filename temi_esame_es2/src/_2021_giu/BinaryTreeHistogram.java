package _2021_giu;

class TreeNode {
    int key;
    TreeNode left, right;

    public TreeNode(int item) {
        key = item;
        left = right = null;
    }
}

public class BinaryTreeHistogram {
    public static int[] computeHistogram(TreeNode root) {
        int maxHeight = getHeight(root);
        int[] histogram = new int[maxHeight + 1];
        computeHistogramHelper(root, maxHeight, histogram);
        return histogram;
    }

    private static void computeHistogramHelper(TreeNode node, int height, int[] histogram) {
        if (node == null) return;

        histogram[height] += node.key;
        
        computeHistogramHelper(node.left, height - 1, histogram);
        computeHistogramHelper(node.right, height - 1, histogram);
        
       
    }

    private static int getHeight(TreeNode node) {
        if (node == null) return -1;
        return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
    	// Altezza 3: 1
        TreeNode root = new TreeNode(1);
        // Altezza 2: 5
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // Altezza 1: 22
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // Altezza 0: 3
        root.left.left.left = new TreeNode(3);

        int[] histogram = computeHistogram(root);
        System.out.println("Istogramma dell'albero binario:");
        for (int i = 0; i < histogram.length; i++) {
            System.out.println("Altezza " + i + ": " + histogram[i]);
        }
        
        /* Output stamp:
         * 
         * Istogramma dell'albero binario:
         * Altezza 0: 3
         * Altezza 1: 22
         * Altezza 2: 5
         * Altezza 3: 1
         * 
         */
        
    }
}