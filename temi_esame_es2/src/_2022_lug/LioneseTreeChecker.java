package _2022_lug;

/*
 * Un albero binario etichettato da numeri interi positivi si definisce 
 * lionese se tutti i figli destri di nodi sono pari e tutti i figli
 * sinistri sono dispari. La radice dell’albero può contenere qualsiasi
 * valore in quanto non è né figlio destro né sinistro. Scrivere un 
 * algoritmo divide-et-impera in codice java che riceve un albero in 
 * input e restituisce vero se l’albero è lionese, falso altrimenti.
 * Analizzare il costo computazionale dell’algoritmo proposto.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right =null;
    }
}

public class LioneseTreeChecker {
    public boolean isLionese(TreeNode node) {
        // Se l'albero è vuoto, è lionese
        if (node == null || 
        		(node.left == null && node.right==null) )
            return true;
        if(node.left == null && node.right!=null)
        	return (node.right.val %2 == 0) 
        			&& isLionese(node.right);
        else if(node.left != null && node.right==null)
        	return (node.left.val %2 == 0) 
        			&& isLionese(node.left);
        else 
        	return (node.left.val %2 != 0) 
        			&& (node.right.val %2 == 0) 
        			&& isLionese(node.left) 
        			&& isLionese(node.right);
    }
    
    public static void main(String[] args) {
        LioneseTreeChecker checker = new LioneseTreeChecker();
        
        // Esempio di albero lionese
        TreeNode root1 = new TreeNode(10);
        root1.left = new TreeNode(7);
        root1.right = new TreeNode(12);
        root1.left.left = new TreeNode(5);
        root1.left.right = new TreeNode(8);
        root1.right.right = new TreeNode(14);
        
        // Esempio di albero non lionese
        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(7);
        root2.right = new TreeNode(12);
        root2.left.left = new TreeNode(5);
        root2.left.right = new TreeNode(9); // Nodo destro dispari
        root2.right.right = new TreeNode(14);
        
        boolean isLionese1 = checker.isLionese(root1);
        boolean isLionese2 = checker.isLionese(root2);
        
        System.out.println("Is tree 1 lionese? " + isLionese1); // True
        System.out.println("Is tree 2 lionese? " + isLionese2); // False
    }
}
