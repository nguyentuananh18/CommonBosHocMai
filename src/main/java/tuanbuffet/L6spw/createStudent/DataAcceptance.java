package tuanbuffet.L6spw.createStudent;

public class DataAcceptance {
    private String id;
    private String name;
    private String classIn;
    private String idBos;

    public DataAcceptance(){}
    public DataAcceptance(String id, String name, String classIn, String idBos) {
        this.id = id;
        this.name = name;
        this.classIn = classIn;
        this.idBos = idBos;

    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getClassIn() {
        return classIn;
    }

    public String getIdBos() {
        return idBos;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setClassIn(String classIn) {
        this.classIn = classIn;
    }

    public void setIdBos(String idBos) {
        this.idBos = idBos;
    }
}
