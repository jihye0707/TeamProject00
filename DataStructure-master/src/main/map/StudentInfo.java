package main.map;

public class StudentInfo {
    private String studentID;
    private String studentName;

    public StudentInfo(String studentID, String studentName) {
        this.studentID = studentID;
        this.studentName = studentName;
    }

    public void setStudentID(String id) {
        studentID = id;
    }

    public void setStudentName(String name) {
        studentName = name;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }
}