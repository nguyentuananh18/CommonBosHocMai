package tuanbuffet.L6spw.createClass.schedulePage;
import tuanbuffet.common.StringProcessing.*;

public class Curriculum {
    String curriculum;
    public Curriculum(String curriculum){
        if (curriculum.toLowerCase().contains("movers") ||curriculum.toLowerCase().contains("flyers") ||curriculum.toLowerCase().contains("beginners") ||curriculum.toLowerCase().contains("starters")){
            this.curriculum = CourseType.KidsBox.getValue();
        }
        else if (curriculum.toLowerCase().contains("chat room for")){
            this.curriculum = CourseType.ChatRoomForTeens.getValue();
        }
        else this.curriculum = CourseType.FourCorners.getValue();
    }
    public String getCurriculum(){
        return curriculum;
    }
}
