import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int R,C;
    private static String[] map;
    private static boolean[][] visited;
    private static int tempV_count, tempO_count;
    private static int[][] dirs= {{-1,0},{0,1}, {1,0},{0,-1}};

    public static void input(){
        R = fr.nextInt();
        C = fr.nextInt();

        visited = new boolean[R][C];

        map = new String[R];
        for (int i = 0; i < R; i++) {
            map[i] = fr.nextLine();
        }
    }


    private static void dfs(int row, int col){
        if(map[row].charAt(col) == 'o') tempO_count++;
        else if(map[row].charAt(col) == 'v') tempV_count++;

        visited[row][col] = true;

        for(int[] dir : dirs){
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if(nextRow >= R || nextRow <0 || nextCol >= C || nextCol < 0) continue;
            if(map[nextRow].charAt(nextCol) == '#') continue;
            if(visited[nextRow][nextCol]) continue;

            dfs(nextRow, nextCol);
        }
    }

    public static void pro(){
        int total_V_count =0;
        int total_O_count =0;

        for (int row = 0; row < R; row++) {
            for (int col = 0; col < map[row].length(); col++) {
                if(map[row].charAt(col) == '#') continue;
                if(visited[row][col]) continue;
                tempO_count = 0 ;
                tempV_count = 0 ;

                dfs(row,col);

                if(tempO_count > tempV_count){
                    total_O_count += tempO_count;
                }else{
                    total_V_count += tempV_count;
                }
            }
        }

        System.out.println(total_O_count + " " + total_V_count);
    }

    public static void main(String[] args) {
        input();
        pro();
    }


    static class FastReader{
        private BufferedReader br;
        private StringTokenizer st;

        public FastReader(){
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public long nextLong(){
            return Long.parseLong(next());
        }
        public String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }

}
