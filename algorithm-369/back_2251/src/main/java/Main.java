import java.io.*;
import java.util.*;

public class Main {
    private static FastReader fr = new FastReader();
    private static int[] LIMIT = new int[3];
    private static boolean[][][] visited = new boolean[201][201][201];
    private static ArrayList<Integer> ans = new ArrayList<>();
    private static StringBuilder sb = new StringBuilder();

    private static void input(){
        LIMIT[0] = fr.nextInt();
        LIMIT[1] = fr.nextInt();
        LIMIT[2] = fr.nextInt();
    }

    private static void bfs(WaterCans waterCans){
        Queue<WaterCans> q = new LinkedList<>();
        q.add(waterCans);

        ans.add(waterCans.capacity[2]);
        visited[waterCans.capacity[0]][waterCans.capacity[1]][waterCans.capacity[2]] = true;

        while(!q.isEmpty()){
            WaterCans cur_watercans = q.poll();

            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    if(i == j) continue;

                    WaterCans nextWaterCans = cur_watercans.move(i, j, LIMIT);

                    if(visited[nextWaterCans.capacity[0]][nextWaterCans.capacity[1]][nextWaterCans.capacity[2]]) continue;

                    visited[nextWaterCans.capacity[0]][nextWaterCans.capacity[1]][nextWaterCans.capacity[2]] = true;
                    if(nextWaterCans.capacity[0] == 0) ans.add(nextWaterCans.capacity[2]);

                    q.add(nextWaterCans);
                }
            }
        }
    }

    private static void pro(){
        bfs(new WaterCans(new int[]{0, 0, LIMIT[2]}));

        Collections.sort(ans);

        for(int capacity: ans) sb.append(capacity).append(" ");

        System.out.println(sb.toString());
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

        public String nextLine(){
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int nextInt(){
            return Integer.parseInt(next());
        }

        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
    }
}


class WaterCans{
    int[] capacity;

    public WaterCans(int[] capacity){
        this.capacity = new int[3];
        this.capacity[0] = capacity[0];
        this.capacity[1] = capacity[1];
        this.capacity[2] = capacity[2];
    }

    public int[] getCapacity(){
        return capacity;
    }

    public WaterCans move(int from, int to , int[] LIMITS){
        int[] _nx = new int[]{capacity[0], capacity[1], capacity[2]};

        if(capacity[from] + capacity[to] > LIMITS[to]){
            _nx[to] = LIMITS[to];
            _nx[from] = capacity[from] + capacity[to] - LIMITS[to];
        }else{
            _nx[to] = capacity[from]+ capacity[to];
            _nx[from] = 0;
        }
        return new WaterCans(_nx);
    }
}
