package tuanbuffet.L6spw.createClass.curriculumPage;

public class CurriculumData {
    private String curriculum;
    private String courseName;
    private String lesson;
    private String note;
    public CurriculumData (String curriculum,String note){
        this.note = note;
        this.curriculum = curriculum;

    }
    public CurriculumData (String curriculum,String note,String courseName, String lesson){
        this.note = note;
        this.curriculum = curriculum;

    }

    public String getCourseName() {
        if (getCurriculum().toLowerCase().contains("movers")){
            return CurriculumType.KidsBoxMovers.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("flyers")){
            return CurriculumType.KidsBoxFlyers.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("starters")){
            return CurriculumType.KidsBoxStarters.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("beginners")){
            return CurriculumType.KidBoxBeginners.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("for teens 2")){
            return CurriculumType.ChatRoomForTeens2.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("for teens 3")){
            return CurriculumType.ChatRoomForTeens3.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("for teens 1")){
            return CurriculumType.ChatRoomForTeens1.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("corners 1")){
            return CurriculumType.FourCorners1.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("corners 2")){
            return CurriculumType.FourCorners2.getValue();
        }
        else {
            return CurriculumType.FourCorners3.getValue();
        }
    }

    public String getCurriculum() {
        return curriculum;
    }


    public void setCourseName(String courseName) {
        System.out.println(courseName.toLowerCase());
    }

    public void setLesson(String lesson) {
        if (getCurriculum().toLowerCase().contains("movers 2") || curriculum.contains("Flyers 2")){
            this.lesson = LessonType.KidBoxMover2_Flyer2.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("stater 2")){
            this.lesson = LessonType.KidBoxStarters2.getValue();
        }
        else this.lesson = LessonType.Common.getValue();
    }

    public String getLesson() {
        if (getCurriculum().toLowerCase().contains("movers 2") || curriculum.contains("Flyers 2")){
            return LessonType.KidBoxMover2_Flyer2.getValue();
        }
        else if (getCurriculum().toLowerCase().contains("stater 2")){
            return LessonType.KidBoxStarters2.getValue();
        }
        else return LessonType.Common.getValue();
    }
    public String getNote(){
        return note;
    }
    public void setNote(String note){
        this.note = note;
    }

    public static void main(String[] args) {
        CurriculumData curriculumData = new CurriculumData("Movers","","","");
        System.out.println(curriculumData.getCurriculum());
        System.out.println(curriculumData.getCourseName());
        System.out.println(curriculumData.getLesson());
    }

}
