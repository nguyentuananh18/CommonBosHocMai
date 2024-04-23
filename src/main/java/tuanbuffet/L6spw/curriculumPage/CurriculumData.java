package tuanbuffet.L6spw.curriculumPage;



public class CurriculumData {
    private String curiculum;
    private String courseName;
    private String lesson;
    public CurriculumData (String curiculum){
        this.curiculum = curiculum;
        if (curiculum.contains("Movers")){
            this.courseName = CurriculumType.KidsBoxMovers.getValue();
        }
        else if (curiculum.contains("Flyers")){
            this.courseName = CurriculumType.KidsBoxFlyers.getValue();
        }
        else if (curiculum.contains("Starters")){
            this.courseName = CurriculumType.KidsBoxStarters.getValue();
        }
        else if (curiculum.contains("Beginners")){
            this.courseName = CurriculumType.KidBoxBeginners.getValue();
        }
        else if (curiculum.contains("for teens 1")){
            this.courseName = CurriculumType.ChatRoomForTeens1.getValue();
        }
        else if (curiculum.contains("for teens 2")){
            this.courseName = CurriculumType.ChatRoomForTeens2.getValue();
        }
        else if (curiculum.contains("for teens 3")){
            this.courseName = CurriculumType.ChatRoomForTeens3.getValue();
        }
        else {
            this.courseName = CurriculumType.FourCorners.getValue();
        }
        if (curiculum.contains("Movers 2") || curiculum.contains("Flyers 2")){
            this.lesson = LessonType.KidBoxMover2_Flyer2.getValue();
        }
        else if (curiculum.contains("Stater 2")){
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
