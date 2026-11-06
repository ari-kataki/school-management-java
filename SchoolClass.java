import java.lang.reflect.Array;
import java.util.ArrayList;

public class SchoolClass {

    private String className;
    private ArrayList<Student> students;
    private ArrayList<Subject> subjects;
    private ArrayList<Teacher> teachers;


    public SchoolClass(String className, ArrayList<Student> studs, ArrayList<Subject> subjs, ArrayList<Teacher>teachs){
        this.className = className;
        students = studs;
        subjects = subjs;
        teachers = teachs;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
    }

    public ArrayList<Subject> getSubjects() {
        return subjects;
    }

    public void setSubjects(ArrayList<Subject> subjects) {
        this.subjects = subjects;
    }

    public ArrayList<Teacher> getTeachers() {
        return teachers;
    }

    public void setTeachers(ArrayList<Teacher> teachers) {
        this.teachers = teachers;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }


    public boolean addStudent(Student student){
        if(student != null) {
            students.add(student);
            return true;
        }
        return false;
    }

    public boolean removeStudentById(String id){
        int pos = getStudentPosition(id);

        if(pos == -1)
            return false;

        return students.remove(pos) != null;
    }

    private int getStudentPosition(String id) {
        int pos = 0;
        for(Student s : students) {
            if (s.getId().compareTo(id) == 0)
                return pos;
            pos++;
        }
        return -1;
    }

    @Override
    public String toString(){
        String outputTxt = " --- INFO CLASSE " + className + " --- ";
        outputTxt += " \n Elenco studenti: ";

        for(Student s : students)
            outputTxt += "\n Nome: " + s.getName() + " Cognome: " + s.getSurname() + " Media: " + s.getAvgMark() + " Crediti totali: " + s.getTotalCredits();

        outputTxt+= "\n Elenco docenti: ";
        for(Teacher t: teachers)
            outputTxt += "\n Nome: " + t.getName() + " Cognome: " + t.getSurname();

        outputTxt+= "\n Elenco materia: ";
        for(Subject s: subjects)
            outputTxt += "\n Nome: " + s.getName() + " Crediti: " + s.getCredits();

        return outputTxt;
    }
}
