package ExamPrep.university;

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
        if (this.students.size() < this.capacity) {
            for (Student st : this.students) {
                if (st.getFirstName().equals(student.getFirstName()) &&
                        st.getLastName().equals(student.getLastName())) {
                    return "Student is already in the ExamPrep.university";
                }
            }
            this.students.add(student);
            return "Added student " + student.firstName + " " + student.lastName;
        } else {
            return "No seats in the ExamPrep.university";
        }
    }

    public String dismissStudent(Student student) {
        boolean isRemoved = this.students.removeIf
                (st -> st.getFirstName().equals(student.getFirstName())
                        && st.getLastName().equals(student.getLastName()));
        if (isRemoved) {
            return "Removed student " + student.firstName + " " + student.lastName;
        } else {
            return "Student not found";
        }
    }

    public Student getStudent(String firstName, String lastName) {
        for (Student student : students) {
            if (student.getFirstName().equals(firstName) && student.getLastName().equals(lastName)) {
                return student;
            }
        }
        return null;
    }

    public String getStatistics() {
        StringBuilder sb = new StringBuilder();
        for (Student student : students) {
            String text = String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s",
                    student.firstName, student.lastName, student.bestSubject);
            sb.append(text).append("\n");
        }
        return sb.toString();
    }
}
