package After;

import java.util.Scanner;

public class Bus extends Vehicles{
    String 버스_번호;
    BusState 상태;
    int 현재_승객수;
    int 최대_승객수;
    int 요금;
    int 주유량;
    int 현재_속도;

    public Bus(int 최대_승객수, int 요금, int 주유량, int 현재_속도) {
        super(주유량, 현재_속도);

        this.버스_번호 = get번호();
        this.현재_승객수 = 0;
        this.최대_승객수 = 최대_승객수;
        this.요금 = 요금;
        this.주유량 = get주유량();
        this.현재_속도 = get현재_속도();

        System.out.println(get번호() + ": 버스가 생성되었습니다.");

        운행();
    }

    @Override
    void 정보_출력() {
        System.out.println("[버스 정보] ========================================");
        System.out.println("버스 번호: " + get번호());
        System.out.println("버스 상태: " + 상태);
        System.out.println("현재 속도: " + get현재_속도() + " / 주유량: " + get주유량());
        System.out.println("요금: " + 요금);
        System.out.println("현재 승객수: " + 현재_승객수 + " / 최대 승객수: " + 최대_승객수);
        System.out.println("==================================================");
        System.out.println();
    }

    @Override
    public void 운행() {
        if(this.상태 == 상태.운행 ) {
            System.out.println(get번호() + ": 이미 운행 중인 버스입니다.");
        } else {
            if(주유량_확인()) {
                set주유량(get주유량()-1);

                상태 = 상태.운행;

                System.out.println(get번호() + ": 버스가 속도" + get현재_속도() + "으로 운행을 시작합니다.");
            } else {
                상태 = 상태.차고지행;

                System.out.println(get번호() + ": 운행이 불가능합니다. 주유량을 확인해 주세요.");
            }
        }

        정보_출력();
    }

    public void 버스_상태_변경(BusState 상태) {
        if(상태 == this.상태) {
            System.out.println(get번호() + ": 이미 " + 상태 + " 중인 버스입니다.");
        } else {
            if(상태 == BusState.운행) {
                운행();

                return;
            } else {
                this.상태 = BusState.차고지행;

                System.out.println(get번호() + ": 버스가 차고지로 향합니다.");
            }
        }

        정보_출력();
    }

    @Override
    public void 승객_탑승() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("탑승할 승객의 수를 입력하시오(정수): ");
        int 탑승_승객수 = scanner.nextInt();

        if(this.상태 == BusState.차고지행) {
            System.out.println(get번호() + ": 버스가 운행 중이 아닙니다.");
        } else {
            if(현재_승객수 == 최대_승객수) {
                System.out.println(get번호() + ": 승객이 더 이상 탑승할 수 없습니다.");
            } else if(현재_승객수 + 탑승_승객수 > 최대_승객수) {
                int 탑승가능_승객수 = 최대_승객수 - 현재_승객수;

                현재_승객수 += 탑승가능_승객수;

                System.out.println(get번호() + ": " + 탑승_승객수 + "명 중 " + 탑승가능_승객수 + "명이 탑승하였습니다.");
            } else {
                현재_승객수 += 탑승_승객수;

                System.out.println(get번호() + ": " + 탑승_승객수 + "명이 탑승하였습니다.");
            }
        }

        정보_출력();
    }

    @Override
    public void 속도_변경(int 속도) {
        if(주유량_확인()) {
            set주유량(get주유량()-1);

            System.out.println(get번호() + ": 버스가 속도를" + get현재_속도() + "에서 " + 속도 + "으로 변경합니다.");

            set현재_속도(속도);
        } else {
            상태 = BusState.차고지행;

            System.out.println(get번호() + ": 속도 변경이 불가능합니다. 주유량을 확인해 주세요.");
        }

        정보_출력();
    }
}
