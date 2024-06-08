package tuanbuffet.L6spw.createClass.schedulePage;

public enum CourseType {
    KidsBox("Kid's Box"),
    ChatRoomForTeens("Chat room for teens"),
    FourCorners("Four Corners"),
    EasySpeak("Easy Speak");

    private final String value;

    private CourseType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

}