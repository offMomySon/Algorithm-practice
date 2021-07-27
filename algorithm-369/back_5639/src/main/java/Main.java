import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Node{
    private final int val;
    private Node left_node;
    private Node right_node;

    public int getVal() {
        return val;
    }

    public Node(int val) {
        this.val = val;
        left_node = null;
        right_node = null;
    }

    public void insertNode(Node new_node){
        if(val > new_node.getVal()){
            if(left_node == null) left_node = new_node;
            else left_node.insertNode(new_node);
        }else{
            if(right_node == null) right_node = new_node;
            else right_node.insertNode(new_node);
        }
    }

    public void postOrder(StringBuilder sb){
        if(left_node != null) left_node.postOrder(sb);
        if(right_node != null) right_node.postOrder(sb);
        sb.append(val+"\n");
    }
}

public class Main {
    public static FastReader bf = new FastReader();
    public static StringBuilder sb = new StringBuilder();
//    public static  BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
    public static int N;

    public static Node root_node = null;

    public static void pro(){
        root_node.postOrder(sb);

        System.out.println(sb.toString());
    }

    public static void input() throws  IOException {
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        root_node = new Node(bf.nextInt());

        String str = null;
        while(true){
            str = bf.nextLine();
            if(str == null || str.length() == 0)
                break;
            root_node.insertNode(new Node(Integer.parseInt(str)));
        }
//
//        while((str = bf.readLine()) != null && str.length() != 0) {
////            System.out.println(str);
//            root_node.insertNode(new Node(Integer.parseInt(str)));
//        }
    }

    public static void main(String[] args) throws IOException {

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

        private String next() throws IOException {
            while(st == null || !st.hasMoreElements()){
                st = new StringTokenizer(br.readLine());
            }
            return st.nextToken();
        }

        private int nextInt() throws IOException {
            String s = br.readLine();
            return Integer.parseInt(s);
        }
        private long nextLong() throws IOException {
            return Long.parseLong(next());
        }
        private double nextDouble() throws IOException {
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
