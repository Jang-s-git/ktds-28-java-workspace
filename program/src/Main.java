import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

// 프로그램 정보 클래스
class Program {
    private String name;
    private LocalTime startTime;
    private LocalTime endTime;

    public Program(String name, LocalTime startTime, LocalTime endTime) {
        this.name = name;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    // 지정한 시간이 방영 시간 범위(시작시간 ~ 종료시간) 내에 있는지 확인
    public boolean isAiring(LocalTime targetTime) {
        return !targetTime.isBefore(startTime) && !targetTime.isAfter(endTime);
    }
}

// 채널 편성표 관리 클래스
class ScheduleManager {
    private List<Program> scheduleList = new ArrayList<>();

    public void addProgram(String name, int startH, int startM, int endH, int endM) {
        scheduleList.add(new Program(name, LocalTime.of(startH, startM), LocalTime.of(endH, endM)));
    }

    public String getAiringProgram(LocalTime time) {
        for (Program program : scheduleList) {
            if (program.isAiring(time)) {
                return program.getName();
            }
        }
        return "방영중인 시간이 아닙니다.";
    }
}

public class Main {
    public static void main(String[] args) {
        ScheduleManager manager = new ScheduleManager();

        // 편성표 등록
        manager.addProgram("프로그램 1", 3, 0, 5, 0);
        manager.addProgram("프로그램 2", 5, 1, 6, 30);
        manager.addProgram("프로그램 3", 6, 31, 8, 0);
        manager.addProgram("프로그램 4", 8, 1, 9, 0);
        manager.addProgram("프로그램 5", 9, 1, 10, 0);
        manager.addProgram("프로그램 6", 10, 1, 12, 0);
        manager.addProgram("프로그램 7", 12, 1, 13, 30);
        manager.addProgram("프로그램 8", 13, 31, 15, 0);
        manager.addProgram("프로그램 9", 15, 1, 17, 0);
        manager.addProgram("프로그램 10", 17, 1, 18, 0);
        manager.addProgram("프로그램 11", 18, 1, 21, 0);
        manager.addProgram("프로그램 12", 21, 1, 23, 0);
        manager.addProgram("프로그램 13", 23, 1, 23, 59);

        // 실제 현재 시간 기준 확인 시:
        LocalTime now = LocalTime.now();
        System.out.println("현재 방영: " + manager.getAiringProgram(now));
    }
}