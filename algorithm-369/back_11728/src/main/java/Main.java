import java.io.*;
import java.util.StringTokenizer;

public class Main {
    private static FastScanner fs = new FastScanner();
    private static StringBuilder sb = new StringBuilder();
    private static int A, B;
    private static int A_GROUP[];
    private static int B_GROUP[];
    private static int NEW_GROUP[];

    public static void input(){
        A = fs.nextInt();
        B = fs.nextInt();

        A_GROUP = new int[A +1];
        for (int i = 1; i <= A; i++) A_GROUP[i] = fs.nextInt();

        B_GROUP = new int[B +1];
        for (int i = 1; i <= B; i++) B_GROUP[i] = fs.nextInt();
    }

    private static void pro(){
        int b_pointer = 1;
        int new_pointer = 1;

        for (int a_pointer = 1; a_pointer <= A; a_pointer++) {
            while(b_pointer <=B && B_GROUP[b_pointer]<A_GROUP[a_pointer]){
//                NEW_GROUP[new_pointer] = B_GROUP[b_pointer];
                sb.append(B_GROUP[b_pointer]+" ");
                b_pointer++;
//                new_pointer++;
            }

//            NEW_GROUP[new_pointer] = A_GROUP[a_pointer];
            sb.append(A_GROUP[a_pointer]+" ");
//            new_pointer++;
        }

        for (int i = b_pointer; i <= B_GROUP.length-1; i++) {
//            NEW_GROUP[new_pointer] = B_GROUP[i];
            sb.append(B_GROUP[i]+" ");
//            new_pointer++;
        }

        System.out.println(sb.toString());
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