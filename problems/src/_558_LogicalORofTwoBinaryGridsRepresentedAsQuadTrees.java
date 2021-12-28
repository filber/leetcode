public class _558_LogicalORofTwoBinaryGridsRepresentedAsQuadTrees {
    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;
        public Node() {}
        public Node(boolean val,boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
        }
        public Node(boolean _val,boolean _isLeaf,Node _topLeft,Node _topRight,Node _bottomLeft,Node _bottomRight) {
            val = _val;
            isLeaf = _isLeaf;
            topLeft = _topLeft;
            topRight = _topRight;
            bottomLeft = _bottomLeft;
            bottomRight = _bottomRight;
        }
    };

    public static Node construct(int[][] grid) {
        int n = grid.length;
        return construct(grid, 0, 0, n - 1, n - 1);
    }

    public static Node construct(int[][] grid, int tlX, int tlY, int brX, int brY) {
        // 1. Grid with one element
        if (tlX == brX) {
            return new Node(grid[tlX][tlY] == 1, true); // leaf node
        }

        // 2. Split into four parts
        int middleX = (brX + tlX)/2;
        int middleY = (brY + tlY)/2;

        // 3. Construct nodes separately
        Node topLeftNode = construct(grid, tlX, tlY, middleX, middleY);
        Node topRightNode = construct(grid, tlX, middleY + 1, middleX, brY);
        Node bottomLeftNode = construct(grid, middleX + 1, tlY, brX, middleY);
        Node bottomRightNode = construct(grid, middleX + 1, middleY + 1, brX, brY);

        // 4. Construct root node
        if (topLeftNode.isLeaf && topRightNode.isLeaf &&
                bottomLeftNode.isLeaf && bottomRightNode.isLeaf &&
                topLeftNode.val == topRightNode.val &&
                topLeftNode.val == bottomLeftNode.val &&
                topLeftNode.val == bottomRightNode.val) {
            return new Node(topLeftNode.val, true); // leaf node
        } else {
            return new Node(true, false,
                    topLeftNode,topRightNode,
                    bottomLeftNode,bottomRightNode); // non-leaf node
        }
    }

    public static Node intersect(Node left, Node right) {
        // 1. Both leaf
        if (left.isLeaf && right.isLeaf) {
            left.val = left.val || right.val;
            return left;
        }

        // 2. Either is a leaf node
        else if (left.isLeaf) {
            if (left.val) {
                return left;
            } else {
                return right;
            }
        } else if (right.isLeaf) {
            if (right.val) {
                return right;
            } else {
                return left;
            }
        }

        // 3. Both are non-leaf nodes
        else {
            Node topLeft = intersect(left.topLeft, right.topLeft);
            Node topRight = intersect(left.topRight, right.topRight);
            Node bottomLeft = intersect(left.bottomLeft, right.bottomLeft);
            Node bottomRight = intersect(left.bottomRight, right.bottomRight);
            if (topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf
                    && topLeft.val == topRight.val
                    && topLeft.val == bottomLeft.val
                    && topLeft.val == bottomRight.val) {
                // can be merged
                return topLeft;
            } else {
                // cannot be merged
                return new Node(true, false, topLeft, topRight, bottomLeft, bottomRight);
            }
        }
    }

    public static void main(String[] args) {
        Node n1 = intersect(construct(new int[][]{{1}}), construct(new int[][]{{1}}));
        Node n2 = intersect(construct(new int[][]{{0}}), construct(new int[][]{{0}}));
        Node n3 = intersect(construct(new int[][]{{1}}), construct(new int[][]{{0}}));

        Node n4 = intersect(construct(new int[][]{  {1,1,1,1},
                                                    {1,1,1,1},
                                                    {0,0,0,0},
                                                    {0,0,0,0}}),

                            construct(new int[][]{  {1,1,0,0},
                                                    {1,1,1,1},
                                                    {1,1,0,0},
                                                    {1,1,0,0}}));
    }
}
