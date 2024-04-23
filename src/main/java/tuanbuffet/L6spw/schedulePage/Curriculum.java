package tuanbuffet.L6spw.schedulePage;

public class Curriculum {
    String curriculum;
    public Curriculum(String curriculum){
        if (curriculum.contains("Movers") ||curriculum.contains("Flyers") ||curriculum.contains("Beginners") ||curriculum.contains("Starters")){
            this.curriculum = CourseType.KidsBox.getValue();
        }
        else if (curriculum.contains("room for")){
            this.curriculum = CourseType.ChatRoomForTeens.getValue();
        }
        else this.curriculum = CourseType.FourCorners.getValue();
    }
    public String getCurriculum(){
        return curriculum;
    }
}
