public class AVLNode {
    public AVLNode left;
    public AVLNode right;
    
    public int val;
    public int height;

    public AVLNode(int val) {
        this.val = val;
        this.height = 1;
    }

    public int height(AVLNode node) {
        if(node == null)
            return 0;
        return node.height;
    }

    public void recalculateHeight() {
        this.height = 1 + Math.max(height(left), height(right));
    }

    public AVLNode insert(int val) {
        return insert(this, val);
    }

    public AVLNode delete(int val) {
        return delete(this, val);
    }

    public AVLNode fixBalance(AVLNode root, int val) {
        int balanceFactor = height(root.right) - height(root.left);

        //left heavy
        if(balanceFactor < -1) {
            if(val > root.left.val) {
                root.left = rotateLeft(root.left);
            }

            root = rotateRight(root);
        } else if(balanceFactor > 1) {
            // right left case
            if(val < root.right.val) {
                root.right = rotateRight(root.right);
            }
            root = rotateLeft(root);
        }

        return root;
    }

    private AVLNode delete(AVLNode root, int val) {
        if(root == null) {
            return null;
        }

        if(val < root.val) {
            root.left = delete(root.left, val);
        } else if(val > root.val) {
            root.right = delete(root.right, val);
        } else {
            if(root.left == null) {
                root = root.right;
                return root;
            } else if(root.right == null) {
                root = root.left;
                return root;
            } else {
                AVLNode nextInOrder = root.right;
                while(nextInOrder.left != null) {
                    nextInOrder = nextInOrder.left;
                }

                root.val = nextInOrder.val;
                root.right = delete(root.right, root.val);
            }
        }
        
        root.recalculateHeight();

        root = fixBalance(root, -val);
        return root;
    }

    public AVLNode rotateRight(AVLNode root) {
        AVLNode leftChild = root.left;
        AVLNode subtree = leftChild.right;

        leftChild.right = root;
        root.left = subtree;

        root.recalculateHeight();
        leftChild.recalculateHeight();
        return leftChild;
    }

    public AVLNode rotateLeft(AVLNode root) {
        AVLNode rightChild = root.right;
        AVLNode subtree = rightChild.left;

        rightChild.left = root;
        root.right = subtree;

        root.recalculateHeight();
        rightChild.recalculateHeight();

        return rightChild;
    }
     
    private AVLNode insert(AVLNode root, int val) {
        if(root == null) {            
            return new AVLNode(val);
        }

        if(val < root.val) {
            root.left = insert(root.left, val);
        } else if(val > root.val) {
            root.right = insert(root.right, val);
        } else {
            return this;
        }

        root.recalculateHeight();
        root = fixBalance(root, val);

        return root;
    }
}
