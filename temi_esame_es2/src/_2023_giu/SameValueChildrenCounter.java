package _2023_giu;

class TreeNode {
    int val;
    TreeNode left, right;
    
    TreeNode(int value) {
        val = value;
        left = right = null;
    }
}

public class SameValueChildrenCounter {
    public int countNodesWithSameValueChildren(TreeNode root) {
        if (root == null)
            return 0;
        int count = 0;
        if(root.left != null 
        		&& root.right != null 
        		&& root.left.val == root.right.val)
        	count = 1;
        return count 
    			+ countNodesWithSameValueChildren(root.left) 
    			+ countNodesWithSameValueChildren(root.right);
        
        /*
        // Controlla se i figli del nodo corrente hanno lo stesso valore
        int count = (root.left != null && root.right != null && root.left.val == root.right.val) ? 1 : 0;
        
        // Conta ricorsivamente i nodi con figli dello stesso valore nei sottoalberi sinistro e destro
        int leftCount = countNodesWithSameValueChildren(root.left);
        int rightCount = countNodesWithSameValueChildren(root.right);
        
        // Restituisce la somma dei contatori dei sottoalberi sinistro e destro più il contatore del nodo corrente
        return count + leftCount + rightCount;*/
    }
    
    public static void main(String[] args) {
        SameValueChildrenCounter counter = new SameValueChildrenCounter();
        
        // Esempio di albero
        TreeNode root = new TreeNode(1);
        //
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        // 
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        //
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        //
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(7);

        
        int count = counter.countNodesWithSameValueChildren(root);
        System.out.println("Number of nodes with same value children: " + count);
    }
}
