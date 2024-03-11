package _2022_feb;

/*
 * Si consideri un albero binario di ricerca, non necessariamente bilanciato,
 * in cui a ciascun nodo è associata una chiave numerica (reale). 
 * Non ci sono chiavi ripetute.
 * 1) Scrivere un algoritmo efficiente che dato in input l'albero 
 *    e due valori reali a e b, con a < b, restituisce il numero di nodi 
 *    la cui chiave appartiene all'intervallo [a, b] (estremi inclusi).
 * 2) Calcolare il costo computazionale dell'algoritmo di cui al punto a)
 *    nel caso migliore e nel caso peggiore.
 */

class TreeNode {
    double key;
    TreeNode left, right;
    
    TreeNode(double value) {
        key = value;
        left = right = null;
    }
}

public class IntervalSearch {
    public int countNodesInRange(TreeNode root, double a, double b) {
        if (root == null)
            return 0;
        
        // Se la chiave del nodo è fuori dall'intervallo, controlla solo il sottoalbero sinistro o destro
        if (root.key < a)
            return countNodesInRange(root.right, a, b);
        else if (root.key > b)
            return countNodesInRange(root.left, a, b);
        // Se la chiave è nell'intervallo, conta il nodo corrente e controlla entrambi i sottoalberi
        else
            return 1 + countNodesInRange(root.left, a, b) + countNodesInRange(root.right, a, b);
    }
    
    public static void main(String[] args) {
        IntervalSearch searcher = new IntervalSearch();
        
        // Esempio di albero
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);
        root.right.right = new TreeNode(20);
        
        double a = 7.5;
        double b = 15.5;
        
        int count = searcher.countNodesInRange(root, a, b);
        System.out.println("Number of nodes in the range [" + a + ", " + b + "]: " + count);
    }
}
