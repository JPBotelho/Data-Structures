public class BSTNode {
    public int val = 0;
    public BSTNode left;
    public BSTNode right;

    public BSTNode() {

    }

    public void printInOrder () {
        if(left != null) {
            left.printInOrder();
        }
        System.out.print(val + " ");
        if(right != null) {
            right.printInOrder();
        }
    }
    public BSTNode(int val) {
        this.val = val;
    }

    public BSTNode get(int val) {
        return get(this, val);
    }

    private BSTNode get(BSTNode root, int val) {
        if(root == null || val == root.val) {
            return root;
        }

        if(val < root.val) {
            return get(root.left, val);
        } 

        return get(root.right, val);
    }

    public BSTNode insert(int val) {
        return insert(this, val);
    }
    
    private BSTNode insert(BSTNode root, int val) {
        if(root == null) {
            root = new BSTNode(val);
            return root;
        }

        if(val < root.val) {
            root.left = insert(root.left, val);
        } else if(val > root.val) {
            root.right = insert(root.right, val);
        }

        return root;
    }

    public BSTNode delete(int val) {
        return delete(this, val);
    }

    private BSTNode delete(BSTNode root, int val) {
        if(root == null) return null;

        if(val < root.val) {
            root.left = delete(root.left, val);
        } else if(val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if(root.right == null) {
                root = root.left;
            } else if(root.left == null) {
                root = root.right;
            } else {
                BSTNode parent = null;
                BSTNode nextInOrder = root.right;
                while(nextInOrder.left != null) {
                    parent = nextInOrder;
                    nextInOrder = nextInOrder.left;
                }

                root.val = nextInOrder.val;                
                if(parent == null) {
                    root.right = nextInOrder.right;
                } else {
                    parent.left = nextInOrder.right;
                }                                
            }
        }

        return root;
    }
}
/*
    5
  4   6
X  4 X  7
*/