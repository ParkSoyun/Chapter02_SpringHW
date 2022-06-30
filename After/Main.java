package After;

public class Main {
    public static void main(String[] args) {
        Bus bus1 = new Bus(30, 700, 12, 60);
        bus1.운행(); // 이미 운행 중
        bus1.버스_상태_변경(BusState.차고지행);
        bus1.버스_상태_변경(BusState.운행);
        bus1.승객_탑승();
        bus1.승객_탑승();
        bus1.속도_변경(30);
        bus1.속도_변경(40);

        Taxi taxi1 = new Taxi(2000, 3300, 100, 9, 80);
        taxi1.승객_탑승();
        taxi1.속도_변경(70);
        taxi1.승객_탑승(); // 이미 다른 승객이 탑승 중
        taxi1.속도_변경(60);
        taxi1.요금_결제();
        taxi1.요금_결제(); // 결제할 금액이 없음
    }
}
