package tuanbuffet.L6spw.createClass.generalpage;

public enum TeacherType {
    GVVN("SPEAKWELL - GV Việt Nam"),
    GVPHIL("SPEAKWELL - GV Philippines"),
    GVNamPhi("SPEAKWELL - GV Nam Phi"),
    GVUSUK("SPEAKWELL - GV US/UK");

    private final String value;

    private TeacherType(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }
}
