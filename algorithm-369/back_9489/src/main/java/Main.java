import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

//날짜 - 2021/02/27
//시작 - 12:33
//종료 - 02:30
//실수 -
//참조 -

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int N, TARGET_NUM, TARGET_IDX;
    private static int arr[];
    private static int parent[];

    private static void grouping(){
        int groupIdx = -1;

        for (int i = 1; i <=N ; i++) {
            if(arr[i] == TARGET_NUM) TARGET_IDX = i;
            if(arr[i] != arr[i-1] +1) groupIdx++;

            parent[i] = groupIdx;
        }

    }

    private static void pro(){
        int count =0 ;
        for (int i = 1; i <= N; i++) {
            if(parent[i] != parent[TARGET_IDX] &&
                    parent[parent[i]] == parent[parent[TARGET_IDX]]) count++;
        }

        System.out.println(count);
    }

    public static void main(String[] args) {
        while(true){
            N = fr.nextInt();
            TARGET_NUM =fr.nextInt();

            if( N == 0 && TARGET_NUM == 0) break;

            arr = new int[N+1];
            parent = new int[N+1];

            arr[0] = -1;
            Arrays.fill(parent,-1);
            for (int i = 0; i < N; i++) arr[i+1] = fr.nextInt();

            grouping();

            pro();
        }
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
