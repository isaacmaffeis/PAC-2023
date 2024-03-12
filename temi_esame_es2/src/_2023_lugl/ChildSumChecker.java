package _2023_lugl;

import java.util.ArrayList;

/*
 * Scrivere un algoritmo divide-et-impera che riceve in input un albero binario T
 * con valori dei numeri interi e restituisce in output true/false se ci sono nodi
 * la cui somma dei valori dei figli è uguale. Ad esempio, considerando l'albero
 * in figura, l'algoritmo restituisce true, in quanto ci sono due nodi (la radice
 * e il nodo 14) la cui somma dei valori dei figli è uguale (13).
 * L’algoritmo ritorna non appena trova un abbinamento. 
 * Calcolare infine la complessità dell’algoritmo proposto.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class ChildSumChecker {
    public boolean hasEqualSumChildren(TreeNode root) {
    	ArrayList<Integer> sum_dictionary = new ArrayList<>();
        boolean result = hasEqualSumChildren(root, sum_dictionary);
    	System.out.println(sum_dictionary);
        return result;
    }
    
    private boolean hasEqualSumChildren(TreeNode node, ArrayList<Integer> sum_dictionary) {
        if (node == null || (node.left == null && node.right == null))
            return false;
        
        int childSum = 0;
        if (node.left != null)
            childSum += node.left.val;
        if (node.right != null)
            childSum += node.right.val;
        
        if(sum_dictionary.contains(childSum))
            return true;
        else
        	sum_dictionary.add(childSum);
        
        // Verifica ricorsivamente i sottoalberi sinistro e destro
        return hasEqualSumChildren(node.left, sum_dictionary) || hasEqualSumChildren(node.right, sum_dictionary);
    }
    
    public static void main(String[] args) {
        ChildSumChecker checker = new ChildSumChecker();
        
        // Esempio di albero
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(3);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(14);
        root.left.right.left = new TreeNode(4);
        root.left.right.right = new TreeNode(7);
        root.right.right.left = new TreeNode(13);
        
        boolean hasEqualSum = checker.hasEqualSumChildren(root);
        System.out.println("Has equal sum children: " + hasEqualSum);
    }
}
