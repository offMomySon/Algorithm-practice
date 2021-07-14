import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int N;
    private static int nums[];

    public static void input(){
        N = fs.nextInt();

        nums = new int[N+1];
        for (int i = 1; i <= N; i++) nums[i] = fs.nextInt();
    }

    private static int[] findSolution(){
        int arr[] = new int[3];
        long cur_min = Long.MAX_VALUE;

        for (int solution_one_idx = 1; solution_one_idx <= N; solution_one_idx++) {
            int left_solution_idx = 1;
            int right_solution_idx = N;

            while (left_solution_idx < right_solution_idx) {
                if (left_solution_idx == solution_one_idx){
                    left_solution_idx++;
                    continue;
                }
                if (right_solution_idx == solution_one_idx){
                    right_solution_idx--;
                    continue;
                }

                long curSum = (long)nums[solution_one_idx] + nums[left_solution_idx] + nums[right_solution_idx];

                if(cur_min > Math.abs(curSum)){
                    cur_min = Math.abs(curSum);

                    arr[0] = nums[solution_one_idx];
                    arr[1] = nums[left_solution_idx];
                    arr[2] = nums[right_solution_idx];
                }

                if (curSum == 0) {
                    arr[0] = nums[solution_one_idx];
                    arr[1] = nums[left_solution_idx];
                    arr[2] = nums[right_solution_idx];

                    return arr;
                }
                else if(curSum < 0){
                    left_solution_idx++;
                }
                else if(curSum > 0){
                    right_solution_idx--;
                }
            }
        }
        return arr;
    }

    private static void pro() {
        Arrays.sort(nums, 1, nums.length);

        int arr[] = findSolution();

        Arrays.sort(arr);
        System.out.println(arr[0] + " " + arr[1] + " " + arr[2]);
    }

    public static void main(String[] args) {
        input();
        pro();
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

