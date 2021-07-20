import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static FastReader fr = new FastReader();
    public static StringBuilder sb = new StringBuilder();
    private static int start, end;
    private static boolean visited[] = new boolean[100000+1];
    private static int distance[] = new int[100000+1];

    public static void input(){
        start = fr.nextInt();
        end = fr.nextInt();
    }

    public static void bfs(int start){
        Queue<Integer> q = new LinkedList<>();
        q.add(start);

        distance[start ] =0 ;
        visited[start] = true;

        while(!q.isEmpty()){
            Integer cur_position = q.poll();
            if(cur_position == end) return;

            int next_walk_position_front = cur_position+1;
            int next_walk_position_back = cur_position-1;
            int next_magic_position = cur_position*2;

            if(0<= next_walk_position_front && next_walk_position_front <= 100000){
                if(!visited[next_walk_position_front]){
                    visited[next_walk_position_front] = true;
                    distance[next_walk_position_front] = distance[cur_position] + 1;
                    q.add(next_walk_position_front);
                }
            }

            if(0<= next_walk_position_back && next_walk_position_back <= 100000){
                if(!visited[next_walk_position_back]){

                    visited[next_walk_position_back] = true;
                    distance[next_walk_position_back] = distance[cur_position] + 1;
                    q.add(next_walk_position_back);
                }
            }

            if(0<= next_magic_position && next_magic_position <= 100000){
                if(!visited[next_magic_position]){

                    visited[next_magic_position] = true;
                    distance[next_magic_position] = distance[cur_position] + 1;
                    q.add(next_magic_position);
                }
            }
        }

    }

    public static void pro(){
        bfs(start);

        System.out.println(distance[end]);
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

        private String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        private int nextInt(){
            return Integer.parseInt(next());
        }
        private long nextLong(){
            return Long.parseLong(next());
        }
        private double nextDouble(){
            return Double.parseDouble(next());
        }
        private String nextLine(){
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
