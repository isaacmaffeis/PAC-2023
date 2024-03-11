package _2022_gen;

/*
 * Si consideri un albero binario T in cui a ciascun nodo v è associato un
 * numero reale t.val. Dato un qualsiasi cammino che porta dalla radice ad 
 * una foglia, definiamo il costo del cammino come la somma dei valori 
 * associati a tutti i nodi attraversati (inclusa la radice e la foglia di
 * destinazione). Scrivere un algoritmo in codice Java che, dato in input
 * l'albero T, restituisce il costo massimo tra tutti i cammini radice-foglia.
 * Nel caso di albero vuoto, l'algoritmo restituisce 0. Analizzare poi il
 * costo computazionale dell'algoritmo.
 */

class TreeNode {
    double val;
    TreeNode left, right;
    
    TreeNode(double value) {
        val = value;
        left = right = null;
    }
}

public class MaxRootToLeafPathCost {
    public double maxPathCost(TreeNode node) {
        // Se l'albero è vuoto, il costo massimo è 0
        if (node == null)
            return 0;
        
        return node.val + Math.max(maxPathCost(node.left), maxPathCost(node.right));
        
        /*
        // Calcola il costo massimo del cammino per il sottoalbero sinistro e destro
        double leftMax = maxPathCost(node.left);
        double rightMax = maxPathCost(node.right);
        
        // Restituisce il costo massimo tra il sottoalbero sinistro e destro, sommato al valore del nodo corrente
        return Math.max(leftMax, rightMax) + node.val;
        */

    }
    
    public static void main(String[] args) {
        MaxRootToLeafPathCost calculator = new MaxRootToLeafPathCost();
        
        // Esempio di albero
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(20);
        root.left.right = new TreeNode(25);
        root.right.right = new TreeNode(30);
        
        double maxCost = calculator.maxPathCost(root);
        System.out.println("Max path cost: " + maxCost);
    }
}
