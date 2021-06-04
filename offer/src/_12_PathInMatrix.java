public class _12_PathInMatrix {

    public static boolean hasPath(char[][] matrix, String path) {
        if (matrix == null || matrix.length == 0 ||
            matrix[0] == null || matrix[0].length == 0) {
            return false;
        }
        boolean[][] accessFlag = new boolean[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                // find the initial position
                if (matrix[i][j] == path.charAt(0)) {
                    boolean result = traverse(matrix, path, 0, accessFlag, i, j);
                    if (result) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    public static boolean traverse(char[][] matrix,
                                   String path,
                                   int startIndex,
                                   boolean[][] accessFlag,
                                   int x, int y) {
        // reaching the end of the path
        if (startIndex == path.length()) {
            return true;
        }
        // illegal position
        if (x < 0 || x == matrix.length || y < 0 || y == matrix[0].length) {
            return false;
        }
        // found mismatch character
        if (matrix[x][y] != path.charAt(startIndex)) {
            return false;
        }
        // already accessed this position
        if (accessFlag[x][y]) {
            return false;
        }
        startIndex++;
        // set access flag to true
        accessFlag[x][y] = true;
        boolean result =
                // up
                traverse(matrix,path,startIndex,accessFlag,x-1,y) ||
                // down
                traverse(matrix,path,startIndex,accessFlag,x+1,y) ||
                // left
                traverse(matrix,path,startIndex,accessFlag,x,y - 1) ||
                // right
                traverse(matrix,path,startIndex,accessFlag,x,y + 1);

        if (!result) {
            // reset access flag to false
            accessFlag[x][y] = false;
        }
        return result;
    }

    public static void main(String[] args) {
        char[][] matrix = {
                {'a','b','t','g'},
                {'c','f','c','s'},
                {'j','d','e','h'}
        };

        System.out.println(hasPath(matrix, "bfce"));
        System.out.println(hasPath(matrix, "abfb"));
        System.out.println(hasPath(matrix, "tbfc"));
        System.out.println(hasPath(matrix, "acfs"));
    }
}
