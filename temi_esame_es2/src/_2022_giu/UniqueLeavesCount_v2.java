package _2022_giu;

/*
 * Scrivere un algoritmo divide-et-impera che dato un albero binario T
 * calcola il numero di foglie uniche (nodi foglie senza fratelli) di T.
 * Analizzare il costo computazionale dell’algoritmo proposto. 
 * Quando si verifica il caso migliore? 
 * Quando si verifica il caso pessimo?
 */

/*class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}*/

public class UniqueLeavesCount_v2 {
    public int countUniqueLeaves(TreeNode root) {
        if (root == null)
            return 0;
        
        if (root.left != null && root.right == null)
            if(root.left.left == null && root.left.right == null)
            	return 1;
        if (root.left == null && root.right != null)
            if(root.right.left == null && root.right.right == null)
            	return 1;
        
        return countUniqueLeaves(root.left) + countUniqueLeaves(root.right);
    }
    
    public static void main(String[] args) {
        UniqueLeavesCount_v2 counter = new UniqueLeavesCount_v2();
        
        // Esempio di albero
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.right = new TreeNode(8);  // 1
        root.right.left.right = new TreeNode(9); // 2

        
        int uniqueLeaves = counter.countUniqueLeaves(root);
        System.out.println("Number of unique leaves: " + uniqueLeaves);
    }
}
