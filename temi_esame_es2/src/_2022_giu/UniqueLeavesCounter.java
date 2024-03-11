package _2022_giu;

/*
 * Scrivere un algoritmo divide-et-impera che dato un albero binario T
 * calcola il numero di foglie uniche (nodi foglie senza fratelli) di T.
 * Analizzare il costo computazionale dell’algoritmo proposto. 
 * Quando si verifica il caso migliore? 
 * Quando si verifica il caso pessimo?
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class UniqueLeavesCounter {
    public int countUniqueLeaves(TreeNode root) {
        if (root == null)
            return 0;
        
        // Se il nodo non ha figli, è una foglia unica
        if (root.left == null && root.right == null)
            return 1;
        
        return countUniqueLeaves(root.left) + countUniqueLeaves(root.right);
    }
    
    public static void main(String[] args) {
        UniqueLeavesCounter counter = new UniqueLeavesCounter();
        
        // Esempio di albero
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        
        int uniqueLeaves = counter.countUniqueLeaves(root);
        System.out.println("Number of unique leaves: " + uniqueLeaves);
    }
}
