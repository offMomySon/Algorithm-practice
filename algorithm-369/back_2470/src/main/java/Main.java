import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int storeIdx[] = new int[2];

    private static int[] nums;

    public static void input(){
        N = fs.nextInt();
        nums = new int[N+1];

        for (int i = 1; i <= N; i++) nums[i] = fs.nextInt();
    }

    private static int lower_bound(int []nums, int left, int right, int target){
        int res = right+1;

        while(left<= right){
            int mid = (left+right)/2;

            if(nums[mid] >= target){
                res = mid;
                right = mid-1;
            }else{
                left = mid+1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        input();

        Arrays.sort(nums,1, nums.length);

        int best_res = Integer.MAX_VALUE;
        int best_index[] = new int[2];

        for (int left_idx = 1; left_idx <= N-1; left_idx++) {
            int right_idx = lower_bound(nums, left_idx+1, N, -nums[left_idx]);

            // 존재하지 않는경우.
            // right_idx 조정
//                if(right_idx == N+1) right_idx = N;


            // 결과 값이 최적이면 index 를 바꿈.
            if(left_idx < right_idx -1 && Math.abs(nums[left_idx] + nums[right_idx -1]) <best_res ) {
                best_res = Math.abs(nums[left_idx] + nums[right_idx -1]);
                best_index[0] = left_idx;
                best_index[1] = right_idx-1;
            }

            if( right_idx<=N &&Math.abs(nums[left_idx] + nums[right_idx ]) <best_res){
                best_res = Math.abs(nums[left_idx] + nums[right_idx]);
                best_index[0] = left_idx;
                best_index[1] = right_idx;
            }
        }

        Arrays.sort(best_index);
        System.out.println(nums[best_index[0]]+ " "+nums[best_index[1]]);

    }

    static class FastScanner{
        private StringTokenizer st;
        private BufferedReader bf;

        public FastScanner(){
            bf = new BufferedReader(new InputStreamReader(System.in));
        }
        public FastScanner(String f) throws FileNotFoundException {
            bf = new BufferedReader(new FileReader(new File(f)));
        }

        private String next(){
            while(st == null || !st.hasMoreTokens()){
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

        public long nextLong(){
            return Long.parseLong(next());
        }

        public double nextDouble(){
            return Double.parseDouble(next());
        }

        public String readLine(){
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
