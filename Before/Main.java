package Before;

public class Main {
    public static void main(String[] args) {
        Before.Bus bus1 = new Before.Bus(30, 700, 12, 60);
        bus1.운행();
        bus1.버스_상태_변경(Before.버스_상태.차고지행);
        bus1.버스_상태_변경(Before.버스_상태.운행);
        bus1.승객_탑승(20);
        bus1.승객_탑승(20);
        bus1.속도_변경(30);
        bus1.속도_변경(40);

        Before.Taxi taxi1 = new Before.Taxi(2000, 3300, 100, 11, 60);
        taxi1.승객_탑승("동대구역", 21000);
        taxi1.속도_변경(70);
        taxi1.승객_탑승("한일CGV", 13000);
        taxi1.속도_변경(60);
        taxi1.요금_결제();
    }
}
