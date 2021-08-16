import java.util.ArrayList;
import java.util.List;

public class Main {
    private static int mount_day[] = {0, 31,28,31,30,31,30,31,31,30,31,30,31};

    public static int solution(String[] deposits) {
        List<String> deposit_day_infos = new ArrayList<>();
        List<String> ratios = new ArrayList<>();
        List<String> moneys = new ArrayList<>();

        for(String deposit: deposits){
            String[] deposit_info = deposit.split(" ");

            deposit_day_infos.add(deposit_info[0]);
            ratios.add(deposit_info[1]);
            moneys.add(deposit_info[2]);
        }

        int sum = 0;

        for (int i = 0; i < deposits.length; i++) {
            String[] deposit_day_info = deposit_day_infos.get(i).split("/");
            int mount = Integer.parseInt(deposit_day_info[0]);
            int day = Integer.parseInt(deposit_day_info[1]);

            double ratio = (double)Integer.parseInt(ratios.get(i))/100;

            int money = Integer.parseInt(moneys.get(i));

            int left_day= 365;
            for (int j = 1; j < mount; j++) {
                left_day -= mount_day[j];
            }
            left_day -= day;

            sum += money + Math.floor(( money*ratio ) * ((double)left_day/365));
        }

        return sum;
    }

    public static void main(String[] args) {
//        String[] deposit = {"01/01 2 50000", "01/03 1 999", "01/31 9 10000", "02/05 5 6547", "02/05 6 1", "06/30 5 5000", "10/15 5 2529", "12/30 4 10000"};
        String[] deposit = {"03/01 5 15000", "05/15 2 9527", "11/30 9 10000"};
        solution(deposit);
    }
}
