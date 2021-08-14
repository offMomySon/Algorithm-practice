import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int NUMBER, START_VOLUME, MAX_VOLUME;
    private static int[] volumes;
    private static boolean[][] dp;

    private static void input(){
        NUMBER = fr.nextInt();
        START_VOLUME = fr.nextInt();
        MAX_VOLUME = fr.nextInt();

        volumes = new int[101];

        for (int i = 1; i <= NUMBER; i++) {
            volumes[i] = fr.nextInt();
        }

        dp = new boolean[101][MAX_VOLUME+1];
        dp[0][START_VOLUME] = true;
    }

    private static void pro(){
        for (int i = 1; i <= NUMBER; i++) {

            for (int j = 0; j <= MAX_VOLUME; j++) {
                if(j-volumes[i]<0 && j+ volumes[i]<=MAX_VOLUME){
                    dp[i][j] = dp[i-1][j+volumes[i]];
                }else if( j - volumes[i] >=0 && j+volumes[i] > MAX_VOLUME){
                    dp[i][j] = dp[i-1][j-volumes[i]];
                }else if( j -volumes[i]>=0 && j+volumes[i] <= MAX_VOLUME){
                    dp[i][j] = dp[i-1][j+volumes[i]] || dp[i-1][j-volumes[i]];
                }
            }
        }

        for (int i = 1; i <= NUMBER; i++) {
            boolean isPossible = false;
            for (int j = 0; j <=MAX_VOLUME ; j++) {
                if(dp[i][j])
                    isPossible = true;
            }
            if(!isPossible){
                System.out.println(-1);
                return;
            }
        }

        int maxVolume =0;
        for (int i = 0; i <= MAX_VOLUME; i++) {
            if(dp[NUMBER][i]) maxVolume =i;
        }
        System.out.println(maxVolume);
    }

    public static void main(String[] args) {
        input();
        pro();
    }

    static class FastReader{
        private BufferedReader bf;
        private StringTokenizer st;

        public FastReader(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastReader(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        public String next(){
            while(st == null || !st.hasMoreElements()){
                try {
                    st = new StringTokenizer(bf.readLine());
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
                str = bf.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}

