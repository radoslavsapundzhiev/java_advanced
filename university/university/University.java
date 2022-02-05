package university;
import java.util.ArrayList;
import java.util.List;

public class University {
    public int capacity;
    public List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {
        return this.students.size();
    }

    public String registerStudent(Student student) {
        String result = "";
        if(capacity > 0) {
            if(!this.checkStudentExists(student)) {
                this.students.add(student);
                capacity--;
                result =  String.format("Added student %s %s", student.getFirstName(), student.getLastName());
            } else {
                result = "Student is already in the university";
            }
        } else {
            result = "No seats in the university";
        }
        return result;
    }

    private boolean checkStudentExists(Student student) {
        boolean studentExists = false;
        for (Student s: this.students) {
            if(student.hashCode() == s.hashCode()) {
                studentExists = true;
                break;
            }
        }
        return studentExists;
    }

    public String dismissStudent(Student student) {
        if(this.checkStudentExists(student)) {
            this.students.remove(student);
            this.capacity++;
            return String.format("Removed student %s %s", student.getFirstName(), student.getLastName());
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        Student student = null;
        for (Student s: this.students) {
            if(s.getFirstName().equals(firstName) && s.getLastName().equals(lastName)) {
                student = s;
            }
        }
        return student;
    }

    public String getStatistics() {
        StringBuilder builder = new StringBuilder();
        for (Student student: this.students) {
            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()));
            builder.append(System.lineSeparator());
        }

        return builder.toString();
    }
}
