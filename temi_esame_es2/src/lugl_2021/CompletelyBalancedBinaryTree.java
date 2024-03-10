package lugl_2021;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class CompletelyBalancedBinaryTree {
    public boolean isCompletelyBalanced(TreeNode root) {
        // Se l'albero è vuoto, è bilanciato
        if (root == null)
            return true;
        
        // Verifica la profondità delle foglie a sinistra e a destra
        int leftDepth = depth(root.left);
        int rightDepth = depth(root.right);
        
        // Se le differenze di profondità sono maggiori di 1, l'albero non è bilanciato
        if (Math.abs(leftDepth - rightDepth) > 1)
            return false;
        
        // Ricorsivamente controlla se i sottoalberi sono bilanciati
        return isCompletelyBalanced(root.left) && isCompletelyBalanced(root.right);
    }
    
    // Funzione per calcolare la profondità di un albero
    private int depth(TreeNode node) {
        if (node == null)
            return -1;
        
        // Calcola la profondità massima tra i sottoalberi sinistro e destro
        // Restituisce la profondità massima + 1
        return 1 + Math.max(depth(node.left), depth(node.right)) ;
    }
    
    public static void main(String[] args) {
        CompletelyBalancedBinaryTree treeChecker = new CompletelyBalancedBinaryTree();
        
        // Esempio di albero
        // 4
        TreeNode root = new TreeNode(1);
        // 3
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        // 1
        root.left.left.left = new TreeNode(7);
        // 0
        root.left.left.left.left = new TreeNode(8);

        
        boolean isBalanced = treeChecker.isCompletelyBalanced(root);
        System.out.println("Is the tree completely balanced? " + isBalanced);
        
        CompletelyBalancedBinaryTree treeChecker2 = new CompletelyBalancedBinaryTree();
        
        // Esempio di albero
        TreeNode root2 = new TreeNode(1);
        // 2
        root2.left = new TreeNode(2);
        root2.right = new TreeNode(3);
        // 3
        root2.left.left = new TreeNode(4);
        root2.left.right = new TreeNode(5);
        root2.right.left = new TreeNode(6);
        root2.right.right = new TreeNode(7);
        // 4
        root2.left.left.left = new TreeNode(8);
        root2.left.left.right = new TreeNode(9);
        
        boolean isBalanced2 = treeChecker2.isCompletelyBalanced(root2);
        System.out.println("Is the tree completely balanced? " + isBalanced2);
    }
}
