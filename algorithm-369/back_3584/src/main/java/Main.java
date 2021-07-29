//날짜 - 2021/07/29
//시작 - 11:52
//종료 - 02:30
//실수 -
//참조 -

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static FastReader fr = new FastReader();
    private static StringBuilder sb = new StringBuilder();
    private static int[] parent;
    private static int N;
    private static int target1, target2;

    public static void input(){
        N = fr.nextInt();

        parent = new int[N+1];
        for (int i = 0; i < parent.length; i++) {
            parent[i] = -1;
        }

        for (int i = 1; i <= N-1; i++) {
            int par = fr.nextInt();
            int child = fr.nextInt();

            parent[child] = par;
        }

        target1 = fr.nextInt();
        target2 = fr.nextInt();
    }

    public static List<Integer> dfs(int cur, List<Integer> tracker){
        if(parent[cur] == -1) {
            tracker.add(cur);
            return tracker;
        }

        tracker.add(cur);

        return dfs(parent[cur], tracker);
    }

    public static int findAncessor(List<Integer> arr1, List<Integer> arr2){
        Integer anc = Integer.parseInt("0");

        int length = Math.min(arr1.size(), arr2.size());

        for (int i = 0; i < length; i++) {
            if(arr1.get(i).equals(arr2.get(i))){
                anc = arr1.get(i);
            }
            else break;
        }

        return anc;
    }

    public static void pro(){

        List<Integer> target1_parents = dfs(target1, new ArrayList<>());
        List<Integer> target2_parents = dfs(target2, new ArrayList<>());

        Collections.reverse(target1_parents);
        Collections.reverse(target2_parents);

        int ancessor = findAncessor(target1_parents, target2_parents);
        sb.append(ancessor+"\n");
    }

    public static void main(String[] args) {
        int c = fr.nextInt();

        for (int i = 0; i < c; i++) {
            input();
            pro();
        }

        System.out.println(sb.toString());
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
