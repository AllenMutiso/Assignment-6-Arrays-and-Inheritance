public class Student extends Person{
    private String studentNumber;
    private String degree;

    public Student(String name, String id, String studentNumber, String degree) {
        super(name, id);
        this.studentNumber = studentNumber;
        this.degree = degree;
    }

    public String getStudentNumber() {
        return studentNumber;
    }

    public String getDegree () {
        return degree;
    }

    @Override 
    public String toString () {
        return String.format("%s %s %s %s", getName(), getId(), getStudentNumber(), getDegree());
    }

    
}
