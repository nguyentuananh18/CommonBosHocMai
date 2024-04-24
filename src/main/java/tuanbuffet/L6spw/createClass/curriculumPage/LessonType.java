package tuanbuffet.L6spw.createClass.curriculumPage;

public enum LessonType {
    KidsBoxMovers_Flyers_Starters_Beginners("1"),
    KidBoxMover2_Flyer2("46"),
    KidBoxStarters2("36"),
    Common("1");

    private final String value;

    private LessonType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}

