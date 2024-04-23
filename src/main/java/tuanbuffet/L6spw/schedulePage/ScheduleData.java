package tuanbuffet.L6spw.schedulePage;

public class ScheduleData {
    Curriculum curriculum;

    public ScheduleData(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

    public String getCurriculum() {
        return curriculum.getCurriculum();
    }

    public void setCurriculum(Curriculum curriculum) {
        this.curriculum = curriculum;
    }

}
