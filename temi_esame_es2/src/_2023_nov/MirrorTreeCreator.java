package _2023_nov;

/* Scrivere un algoritmo divide-et-impera che riceve 
 * in input un albero binario T (ad esempio di interi) e restituisce in output l’albero specchio di T.
 */

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class MirrorTreeCreator {
    public TreeNode createMirrorTree(TreeNode root) {
        if (root == null)
            return null;
        
        // Crea il nodo corrente come nodo specchio e assegna i sottoalberi specchio
        TreeNode mirrorNode = new TreeNode(root.val);
        mirrorNode.left = createMirrorTree(root.right);
        mirrorNode.right = createMirrorTree(root.left);
        
        return mirrorNode;
    }
    
    // Metodo di utilità per stampare l'albero
    public void printTree(TreeNode root) {
        if (root == null)
            return;
        
        System.out.print(root.val + " ");
        printTree(root.left);
        printTree(root.right);
    }
    
    public static void main(String[] args) {
        MirrorTreeCreator creator = new MirrorTreeCreator();
        
        // Esempio di albero
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        // Creazione dell'albero specchio
        TreeNode mirrorTree = creator.createMirrorTree(root);
        
        //stampa albero
        System.out.println("Tree:");
        creator.printTree(root);
        
        // Stampa dell'albero specchio
        System.out.println("\nMirror tree:");
        creator.printTree(mirrorTree);
    }
}
