package tuanbuffet.L6spw.createClass.generalpage;
public enum ClassType {
    SPU11("1:1"),
    SPU12("1:2"),
    SPU13("1:3");

    private final String value;

    private ClassType(String value) {
        this.value = value;
    }
    public String getValue() {
        return this.value;
    }
}
