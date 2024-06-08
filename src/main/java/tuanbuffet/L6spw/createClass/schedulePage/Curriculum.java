package tuanbuffet.L6spw.createClass.schedulePage;
import tuanbuffet.common.StringProcessing.*;

public class Curriculum {
    String curriculum;
    public Curriculum(String curriculum){
        if (curriculum.toLowerCase().contains("mover") || curriculum.toLowerCase().contains("flyer") || curriculum.toLowerCase().contains("beginner") || curriculum.toLowerCase().contains("starter")){
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
