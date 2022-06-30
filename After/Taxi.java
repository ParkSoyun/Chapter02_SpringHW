package After;

import java.util.Scanner;

public class Taxi extends Vehicles{
    String 택시_번호;
    TaxiState 상태;
    String 목적지;
    int 목적지까지_거리;
    int 기본_거리;
    int 기본_요금;
    int 거리당_요금;
    int 주유량;
    int 현재_속도;

    public Taxi(int 기본_거리, int 기본_요금, int 거리당_요금, int 주유량, int 현재_속도) {
        super(주유량, 현재_속도);

        this.택시_번호 = get번호();
        this.상태 = TaxiState.일반;
        this.기본_거리 = 기본_거리;
        this.기본_요금 = 기본_요금;
        this.거리당_요금 = 거리당_요금;
        this.주유량 = get주유량();
        this.현재_속도 = get현재_속도();

        System.out.println(택시_번호 + ": 택시가 생성되었습니다.");

        정보_출력();
    }

    @Override
    void 정보_출력() {
        System.out.println("[택시 정보] ========================================");
        System.out.println("택시 번호: " + get번호());
        System.out.println("택시 상태: " + 상태);
        System.out.println("현재 속도: " + get현재_속도() + " / 주유량: " + get주유량());
        System.out.println("기본 거리: " + 기본_거리);
        System.out.println("기본 요금: " + 기본_요금 + " / 거리당 요금: " + 거리당_요금);
        if(상태 == TaxiState.운행) {
            System.out.println("목적지: " + 목적지 + " / 목적지까지 거리: " + 목적지까지_거리);
        }
        System.out.println("==================================================");
        System.out.println();
    }

    @Override
    public void 운행() {
        String 목적지 = this.목적지;

        if(this.상태 == TaxiState.운행) {
            System.out.println(택시_번호 + ": 이미 운행 중인 택시입니다.");
        } else {
            if(주유량_확인()) {
                set주유량(get주유량()-1);

                상태 = TaxiState.운행;

                System.out.println(택시_번호 + ": 택시가 " + 목적지 + "로 운행을 시작합니다.");
            } else {
                System.out.println(택시_번호 + ": 운행이 불가능합니다. 주유량을 확인해 주세요.");
            }
        }

        정보_출력();
    }

    @Override
    public void 승객_탑승() {
        if(this.상태 == TaxiState.운행) {
            System.out.println(택시_번호 + ": 이미 다른 승객이 탑승 중입니다.");

            정보_출력();
        } else {
            Scanner scanner = new Scanner(System.in);
            System.out.print("목적지를 입력하시오(문자열): ");
            String 목적지 = scanner.next();
            System.out.print("목적지까지의 거리를 입력하시오(정수): ");
            int 목적지까지_거리 = scanner.nextInt();


            System.out.println(택시_번호 + ": " + 목적지 + "로 가는 승객이 탑승하였습니다.");
            this.목적지 = 목적지;
            this.목적지까지_거리 = 목적지까지_거리;

            운행();
        }
    }

    @Override
    public void 속도_변경(int 속도) {
        if(주유량_확인()) {
            set주유량(get주유량()-1);

            System.out.println(택시_번호 + ": 택시가 속도를" + 현재_속도 + "에서 " + 속도 + "으로 변경합니다.");

            현재_속도 = 속도;
        } else {
            System.out.println(택시_번호 + ": 속도 변경이 불가능합니다. 주유량을 확인해 주세요.");
        }

        정보_출력();
    }

    public int 거리당_요금_추가(int 목적지까지_거리) {
        int 추가_요금 = 0;

        if(목적지까지_거리 > 기본_거리) {
            추가_요금 = (목적지까지_거리 - 기본_거리) / 100 * 거리당_요금;
        }

        return 추가_요금;
    }

    public void 요금_결제() {
        if(this.상태 == TaxiState.운행) {
            int 최종_요금 = 기본_요금 + 거리당_요금_추가(this.목적지까지_거리);

            System.out.println(택시_번호 + ": " + 최종_요금 + "원을 결제합니다.");

            상태 = TaxiState.일반;
        } else {
            System.out.println(택시_번호 + ": 결제할 금액이 없습니다.");
        }


        정보_출력();
    }
}