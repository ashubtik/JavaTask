package exceptions.groups;

import exceptions.Student;
import exceptions.exeptions.*;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Group {
    private final GroupName groupName;
    List<Student> students;

    public Group(GroupName groupName)  {
        this.groupName = groupName;
        students = new ArrayList<>();
    }
    public GroupName getGroupName() {
        return groupName;
    }

    public List<Student> getStudents() throws NoStudentsException {
        if (students.isEmpty()) throw new NoStudentsException("There is no students in the List, please add student");
        return students;
    }

    public Student getStudent (String expectedStudent) throws NoStudentsException, NoSuchStudentException {
        for (Student student : getStudents()) {
            if (student.getName().equals(expectedStudent)){
                return student;
            }
        }
        throw new NoSuchStudentException("There is no such student " + expectedStudent + "in the University");
    }
    public void addStudent (Student student){
        students.add(student);
    }

    public double getAverageGradeForGroup () throws NoSuchStudentException, NoStudentsException, NoSubjectsException {
        int sum = 0;
        int numberOfMarks = 0;
        for (Student student : getStudents()) {
                for (Subject subject : student.getSubjects()){
                    sum += subject.getGrade();
                    numberOfMarks++;
                }
            }

        if (numberOfMarks == 0) {
            throw new NoSuchStudentException("There is no such student");
        }
        return (double) sum/numberOfMarks;
    }
}

