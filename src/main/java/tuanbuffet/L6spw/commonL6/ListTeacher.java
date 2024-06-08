package tuanbuffet.L6spw.commonL6;

import java.util.List;

public class ListTeacher {
    Teacher teacher;
    public ListTeacher(Teacher teacher){
        this.teacher = teacher;
    }
    public List<Teacher> getLisTeacher (){
        teacher = new Teacher();
        return teacher.getListTeacher();
    }
}
