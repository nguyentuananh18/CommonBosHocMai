package tuanbuffet.L6spw.createClass.curriculumPage;

public enum CurriculumType {
    KidsBoxMovers("Movers"),
    KidsBoxFlyers("Flyers"),
    KidsBoxStarters("Starters"),
    KidBoxBeginners("Beginners (NEW PROGRAMME - 48 Lessons)"),
    ChatRoomForTeens1("Chat room for teens 1"),
    ChatRoomForTeens2("Chat room for teens 2"),
    ChatRoomForTeens3("Chat room for teens 3"),
    FourCorners1("Four Corners 1"),
    FourCorners2("Four Corners 2"),
    FourCorners3("Four Corners 3");


    private final String value;

    private CurriculumType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
