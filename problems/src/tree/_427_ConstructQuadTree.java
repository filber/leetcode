package tree;

// https://leetcode.com/problems/construct-quad-tree/
public class _427_ConstructQuadTree {
    public static class Node {
        public boolean val;
        public boolean isLeaf;
        public Node topLeft;
        public Node topRight;
        public Node bottomLeft;
        public Node bottomRight;

        public Node() {
            this.val = false;
            this.isLeaf = false;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = null;
            this.topRight = null;
            this.bottomLeft = null;
            this.bottomRight = null;
        }

        public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
            this.val = val;
            this.isLeaf = isLeaf;
            this.topLeft = topLeft;
            this.topRight = topRight;
            this.bottomLeft = bottomLeft;
            this.bottomRight = bottomRight;
        }
    };

//    Constraints:
//        n == grid.length == grid[i].length
//        n == 2^x where 0 <= x <= 6
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

    public static void main(String[] args) {
        Node n1 = construct(new int[][]{{1}});

        Node n2 = construct(new int[][]{{1,1},{1,1}});

        Node n3 = construct(new int[][]{{0,0},{0,0}});

        Node n4 = construct(new int[][]{{0,1},{1,0}});

        Node n5 = construct(new int[][]{{1,1,0,0},
                                        {1,1,0,0},
                                        {0,0,1,0},
                                        {0,0,1,0}
        });
        Node n8 = construct(new int[][]{{1,1,1,1,0,0,0,0},
                                        {1,1,1,1,0,0,0,0},
                                        {1,1,1,1,1,1,1,1},
                                        {1,1,1,1,1,1,1,1},
                                        {1,1,1,1,0,0,0,0},
                                        {1,1,1,1,0,0,0,0},
                                        {1,1,1,1,0,0,0,0},
                                        {1,1,1,1,0,0,0,0}});
    }
}
