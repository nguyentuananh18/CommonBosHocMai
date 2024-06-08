package tuanbuffet.L6spw.createClass.schedulePage;
import static tuanbuffet.common.StringProcessing.*;

public class Curriculum {
    String curriculum;
    public Curriculum(String curriculum){
        if (removeAccentAndSpace(curriculum).contains("mover") || removeAccentAndSpace(curriculum).contains("flyer") || removeAccentAndSpace(curriculum).contains("beginner") || removeAccentAndSpace(curriculum).contains("starter")){
            this.curriculum = CourseType.KidsBox.getValue();
        }
        else if (removeAccentAndSpace(curriculum).contains("chat room for")){
            this.curriculum = CourseType.ChatRoomForTeens.getValue();
        }
        else if (removeAccentAndSpace(curriculum).contains("easy")){
            this.curriculum = CourseType.EasySpeak.getValue();
        }
        else this.curriculum = CourseType.FourCorners.getValue();
    }
    public String getCurriculum(){
        return curriculum;
    }
}
