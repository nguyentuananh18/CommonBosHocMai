package tuanbuffet.L6spw.createClass.curriculumPage;



public class CurriculumData {
    private final String curriculum;
    private final String courseName;
    private final String lesson;
    public CurriculumData (String curriculum){
        this.curriculum = curriculum;
        if (curriculum.toLowerCase().contains("movers")){
            this.courseName = CurriculumType.KidsBoxMovers.getValue();
        }
        else if (curriculum.toLowerCase().contains("flyers")){
            this.courseName = CurriculumType.KidsBoxFlyers.getValue();
        }
        else if (curriculum.toLowerCase().contains("starters")){
            this.courseName = CurriculumType.KidsBoxStarters.getValue();
        }
        else if (curriculum.toLowerCase().contains("beginners")){
            this.courseName = CurriculumType.KidBoxBeginners.getValue();
        }
        else if (curriculum.toLowerCase().contains("for teens 2")){
            this.courseName = CurriculumType.ChatRoomForTeens2.getValue();
        }
        else if (curriculum.toLowerCase().contains("for teens 3")){
            this.courseName = CurriculumType.ChatRoomForTeens3.getValue();
        }
        else if (curriculum.toLowerCase().contains("for teens 1")){
            this.courseName = CurriculumType.ChatRoomForTeens1.getValue();
        }
        else if (curriculum.toLowerCase().contains("corners 1")){
            this.courseName = CurriculumType.FourCorners1.getValue();
        }
        else if (curriculum.toLowerCase().contains("corners 2")){
            this.courseName = CurriculumType.FourCorners2.getValue();
        }
        else {
            this.courseName = CurriculumType.FourCorners3.getValue();
        }

        if (curriculum.toLowerCase().contains("movers 2") || curriculum.contains("Flyers 2")){
            this.lesson = LessonType.KidBoxMover2_Flyer2.getValue();
        }
        else if (curriculum.toLowerCase().contains("stater 2")){
            this.lesson =LessonType.KidBoxStarters2.getValue();
        }
        else this.lesson = LessonType.Common.getValue();
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLesson() {
        return lesson;
    }

}
