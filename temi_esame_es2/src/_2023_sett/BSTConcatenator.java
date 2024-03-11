package _2023_sett;

class TreeNode {
    int key;
    TreeNode left, right;

    TreeNode(int value) {
        key = value;
        left = right = null;
    }
}

public class BSTConcatenator {
    public TreeNode concatenateTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        // Trova il massimo valore in T1 e il minimo valore in T2
        TreeNode maxNode = findMaxNode(root1);
        TreeNode minNode = findMinNode(root2);

        // Inserisci T1 come sottoalbero sinistro di T2
        minNode.left = root1;

        // Restituisci la radice di T2
        return root2;
    }

    private TreeNode findMaxNode(TreeNode node) {
        while (node.right != null) {
            node = node.right;
        }
        return node;
    }

    private TreeNode findMinNode(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    // Resto del codice per la stampa degli alberi
    public void printTree(TreeNode root) {
        if (root == null)
            return;
        
        printTree(root.left);
        System.out.print(root.key + " ");
        printTree(root.right);
    }

    public static void main(String[] args) {
        BSTConcatenator concatenator = new BSTConcatenator();

        // Esempio di alberi binari di ricerca
        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(3);
        root1.right = new TreeNode(7);

        TreeNode root2 = new TreeNode(10);
        root2.left = new TreeNode(8);
        root2.right = new TreeNode(12);
        
        // stampa alberi
        System.out.println("Tree 1:");
        concatenator.printTree(root1);
        System.out.println("\nTree 2:");
        concatenator.printTree(root2);

        // Concatenazione degli alberi
        TreeNode concatenatedRoot = concatenator.concatenateTrees(root1, root2);

        // Stampa dell'albero concatenato (se necessario)
        System.out.println("\nTree 1-2 concatenate:");
        concatenator.printTree(concatenatedRoot);

    }
}
