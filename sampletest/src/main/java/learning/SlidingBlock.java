package learning;

import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Result {

    /*
     * Complete the 'movesToSolve' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts 2D_INTEGER_ARRAY puzzle as parameter.
     */

    public static int movesToSolve(int[][] board) {
    // Write your code here
    //Integer[][] board;

    //board = puzzle.stream().map(x->x.toArray(new Integer[x.size()])).toArray(Integer[][]::new);

    String target = "123450";
    String start = "";
    for (int i=0;i<board.length;i++) {
        for (int j=0;j<board[0].length;j++) {
            start += board[i][j];
        }
    }
    HashSet<String> visited = new HashSet<>();

    int[][] dirs = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
    Queue<String> queue = new LinkedList();
    queue.offer(start);
    visited.add(start);
    int res = 0;
    while ( !queue.isEmpty()) {
        int size = queue.size();
        for (int i=0;i<size;i++) {
            String cur = queue.poll();
            if(cur.equals(target)) {
                return res;
            }
            int zero = cur.indexOf('0');
            for (int dir : dirs[zero]) {
                String next = swap(cur, zero, dir);
                if(visited.contains(next)) {
                    continue;
                }
                visited.add(next);
                queue.offer(next);
            }
        }
        res++;
    }
    return -1;
    }

    private static String swap(String str, int i, int j) {
        StringBuilder sb = new StringBuilder(str);
        sb.setCharAt(i, str.charAt(j));
        sb.setCharAt(j, str.charAt(i));
        return sb.toString();
    }

}


public class SlidingBlock{
    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int puzzleRows = Integer.parseInt(bufferedReader.readLine().trim());
//        int puzzleColumns = Integer.parseInt(bufferedReader.readLine().trim());
//
//        List<List<Integer>> puzzle = new ArrayList<>();
//
//        IntStream.range(0, puzzleRows).forEach(i -> {
//            try {
//                puzzle.add(
//                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList())
//                );
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        int result = Result.movesToSolve(puzzle);
//
//        bufferedWriter.write(String.valueOf(result));
//        bufferedWriter.newLine();
//
//        bufferedReader.close();
//        bufferedWriter.close();
    	int[][] arr = {{0,1,2},{3,4,5}};
    	System.out.println(movesToSolve(arr));
    }
    private static final int[] d = { 1, -1, 3, -3 };
    public static int movesToSolve(int[][] board) {
        // Write your code here
        //Integer[][] board;

        //board = puzzle.stream().map(x->x.toArray(new Integer[x.size()])).toArray(Integer[][]::new);

        String target = "123456780";
        String start = "";
        for (int i=0;i<board.length;i++) {
            for (int j=0;j<board[0].length;j++) {
                start += board[i][j];
            }
        }
        HashSet<String> visited = new HashSet<>();

        int[][] dirs = new int[][]{{1,3},{0,2,4},{1,5},{0,4},{1,3,5},{2,4}};
        Queue<String> queue = new LinkedList();
        queue.offer(start);
        visited.add(start);
        int res = 0;
        while ( !queue.isEmpty()) {
            int size = queue.size();
            for (int i=0;i<size;i++) {
                String cur = queue.poll();
                if(cur.equals(target)) {
                    return res;
                }
                int zero = cur.indexOf('0');
                
                for (int dir : dirs[zero]) {
                    String next = swap(cur, zero, dir);
                    if(visited.contains(next)) {
                        continue;
                    }
                    visited.add(next);
                    queue.offer(next);
                }
            }
            res++;
        }
        return -1;
        }

        private static String swap(String str, int i, int j) {
            StringBuilder sb = new StringBuilder(str);
            sb.setCharAt(i, str.charAt(j));
            sb.setCharAt(j, str.charAt(i));
            return sb.toString();
        }
}