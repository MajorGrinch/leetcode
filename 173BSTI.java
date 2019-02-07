class BSTIterator {

    Deque<Integer> nodes;
    int curr = 0;
    int num;
    public BSTIterator(TreeNode root) {
        nodes = new ArrayDeque<>();
        inOrder(root, nodes);
    }
    
    /** @return the next smallest number */
    public int next() {
        return nodes.pollFirst();
    }
    
    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return nodes.isEmpty();
    }

    private void inOrder(TreeNode root, Deque<Integer> nodes){
        if(root == null) return;
        inOrder(root.left, nodes);
        nodes.offerLast(root.val);
        inOrder(root.right, nodes);
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */