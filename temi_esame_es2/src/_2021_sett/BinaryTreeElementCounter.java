package _2021_sett;

/*
 * Progettare e scrivere il codice java di un algoritmo di tipo
 * divide-et-impera in grado di contare gli elementi di un albero
 * binario con etichetta uguale a una data (el) come parametro di
 * input. Determinare, inoltre, il costo dell’algoritmo.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class BinaryTreeElementCounter {
    public int countElements(TreeNode node, int el) {
        // Se l'albero è vuoto, restituisce 0
        if (node == null)
            return 0;
        /*
        // Controlla se il nodo corrente ha l'etichetta desiderata
        int count = (node.val == el) ? 1 : 0;
        
        // Conta ricorsivamente gli elementi nei sottoalberi sinistro e destro
        int leftCount = countElements(node.left, el);
        int rightCount = countElements(node.right, el);
        
        // Restituisce il totale degli elementi trovati
        return count + leftCount + rightCount;
        */
        
        if(node.val == el)
        	return 1 + countElements(node.left, el) + countElements(node.right, el);
        else
        	return countElements(node.left, el) + countElements(node.right, el);
    }
    
    public static void main(String[] args) {
        BinaryTreeElementCounter counter = new BinaryTreeElementCounter();
        
        // Esempio di albero
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(2);

        
        int elementToCount = 2;
        int count = counter.countElements(root, elementToCount);
        System.out.println("Number of elements with label " + elementToCount + ": " + count);
    }
}
