import java.io.*;
import java.util.*;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static int N,M,COUNT;
    private static String[] N_group;
    private static String[] M_group;
    private static List<String> result_name;

    private static void input(){
        N = fs.nextInt();
        M = fs.nextInt();

        result_name = new ArrayList<>();
        N_group = new String[N+1];
        M_group = new String[M+1];

        for (int i = 1; i <= N; i++) N_group[i] = fs.readLine();
        for (int i = 1; i <= M; i++) M_group[i] = fs.readLine();
    }

    public static int binarySearch(String arr[], int left, int right, String target){
        int res = left;

        while(left<=right){
            int mid = (left+right)/2;

            int compareResult = arr[mid].compareTo(target);
            if(compareResult == 0){
                return mid;
            }

            if(compareResult < 0 ){
                left = mid+1;
            }
            else if (compareResult > 0){
                right = mid-1;
            }
        }

        return res-1;
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(M_group,1, M+1);

        for (int i = 1; i < N_group.length; i++) {
//            int resultIndex = Arrays.binarySearch(M_group,1, M_group.length,N_group[i]);
            int resultIndex = binarySearch(M_group,1, M_group.length-1,N_group[i]);

            if( resultIndex >=1){
                result_name.add(M_group[resultIndex]);
            }
        }

        Collections.sort(result_name);

        System.out.println(result_name.size());
        for(String name : result_name){
            System.out.println(name);
        }
    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader br;

        public FastScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while((st == null || !st.hasMoreTokens())){
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
        public long nextLong(){
            return Long.parseLong(next());
        }
        public double nextDouble(){
            return Double.parseDouble(next());
        }
        public String readLine(){
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
