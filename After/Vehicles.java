package After;

import java.util.UUID;

public abstract class Vehicles {
    private String 번호;
    private int 주유량;
    private int 현재_속도;

    public Vehicles(int 주유량, int 현재_속도) {
        this.번호 = UUID.randomUUID().toString();
        this.주유량 = 주유량;
        this.현재_속도 = 현재_속도;
    }

    public boolean 주유량_확인() {
        if(주유량 < 10) {
            return false;
        }

        return true;
    }

    public String get번호() {
        return 번호;
    }

    public int get주유량() {
        return 주유량;
    }

    public void set주유량(int 주유량) {
        this.주유량 = 주유량;
    }

    public int get현재_속도() {
        return 현재_속도;
    }

    public void set현재_속도(int 현재_속도) {
        this.현재_속도 = 현재_속도;
    }

    abstract void 정보_출력();

    public abstract void 운행();
    public abstract void 승객_탑승();
    public abstract void 속도_변경(int 속도);
}
