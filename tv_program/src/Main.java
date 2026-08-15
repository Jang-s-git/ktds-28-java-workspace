import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// 프로그램 정보를 담는 클래스
class Program {
    private String title;
    private LocalTime startTime;
    private LocalTime endTime;

    public Program(String title, LocalTime startTime, LocalTime endTime) {
        this.title = title;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    // 주어진 시간에 방영 중인지 확인 (시작시간 <= targetTime < 종료시간)
    public boolean isAiringAt(LocalTime targetTime) {
        return !targetTime.isBefore(startTime) && targetTime.isBefore(endTime);
    }
}

// 방송사 클래스 (Has-A: Broadcaster has Programs)
class Broadcaster {
    private String name;
    private List<Program> programList; // Has-A 관계 (포함)

    public Broadcaster(String name) {
        this.name = name;
        this.programList = new ArrayList<>();
    }

    public void addProgram(Program program) {
        programList.add(program);
    }

    // 현재 시간에 방영 중인 프로그램 출력
    public void printCurrentProgram(LocalTime targetTime) {
        for (Program program : programList) {
            if (program.isAiringAt(targetTime)) {
                System.out.println(name + " “" + program.getTitle() + "” 이(가) 방영중입니다.");
                return;
            }
        }
        System.out.println(name + " 방영중인 시간이 아닙니다.");
    }
}

// 실행 클래스
public class Main {
    public static void main(String[] args) {
        LocalTime currentTime = LocalTime.now();

        // 방송사 객체 생성
        Broadcaster sbs = new Broadcaster("SBS");
        Broadcaster kbs1 = new Broadcaster("KBS 1");
        Broadcaster kbs2 = new Broadcaster("KBS 2");
        Broadcaster mbc = new Broadcaster("MBC");
        Broadcaster ebs = new Broadcaster("EBS");
        Broadcaster tvn = new Broadcaster("TVN");

        // 프로그램 등록 (09:00 방영 프로그램 포함)
        sbs.addProgram(new Program("좋은아침", LocalTime.of(8, 50), LocalTime.of(10, 0)));
        kbs1.addProgram(new Program("아침마당", LocalTime.of(8, 25), LocalTime.of(9, 30)));
        kbs2.addProgram(new Program("생생정보", LocalTime.of(8, 30), LocalTime.of(9, 30)));
        mbc.addProgram(new Program("드라마", LocalTime.of(9, 0), LocalTime.of(10, 0)));
        ebs.addProgram(new Program("애니메이션", LocalTime.of(8, 0), LocalTime.of(9, 30)));

        // TVN은 09:00에 해당하는 프로그램이 없는 상태 (오후 시간대만 등록)
        tvn.addProgram(new Program("예능", LocalTime.of(12, 0), LocalTime.of(13, 30)));

        // 방송사 목록 생성
        List<Broadcaster> broadcasters = List.of(sbs, kbs1, kbs2, mbc, ebs, tvn);

        // 출력
        System.out.printf("현재 시간 %02d:%02d\n", currentTime.getHour(), currentTime.getMinute());
        for (Broadcaster broadcaster : broadcasters) {
            broadcaster.printCurrentProgram(currentTime);
        }
    }
}