package _2024_gen;

/*
 * Definire e calcolare la complessità (nel caso peggiore) di un algoritmo
 * divide-et-impera che riceve in input un albero binario ed un certo
 * livello k (>=0) e stampa tutti i nodi di livello k.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class LevelKNodePrinter {
    public void printNodesAtLevelK(TreeNode root, int k) {
        printNodesAtLevelK(root, k, 0);
    }
    
    private void printNodesAtLevelK(TreeNode node, int k, int currentLevel) {
        if (node == null)
            return;
        
        if (currentLevel == k) {
            System.out.println(node.val); // Stampa il nodo se il livello corrente è k
            return;
        }
        
        // Ricorsivamente visita i sottoalberi sinistro e destro con il livello incrementato di 1
        printNodesAtLevelK(node.left, k, currentLevel + 1);
        printNodesAtLevelK(node.right, k, currentLevel + 1);
    }
    
    public static void main(String[] args) {
        LevelKNodePrinter printer = new LevelKNodePrinter();
        
        // Esempio di albero
        // 0
        TreeNode root = new TreeNode(1);
        // 1
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        // 2
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        // 3
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        
        int k = 2; // Livello desiderato
        
        System.out.println("Nodes at level " + k + ":");
        printer.printNodesAtLevelK(root, k);
    }
}
