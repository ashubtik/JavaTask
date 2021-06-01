package exceptions;

import exceptions.exeptions.*;
import exceptions.faculties.FacultyName;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    String name;
    private List<Subject> subjects;
    private FacultyName facultyName;
    private GroupName groupName;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setSubject(Category category, int grade) {
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(FacultyName facultyName) {
        this.facultyName = facultyName;
    }

    public GroupName getGroupName() {
        return groupName;
    }

    public void setGroupName(GroupName groupName) {
        this.groupName = groupName;
    }

    public static class Builder {
        private final Student newStudent;

        public Builder() {
            newStudent = new Student();
        }

        public Student.Builder name(String name) {
            newStudent.name = name;
            return this;
        }

        public Student.Builder subjects(Category category, int grade) {
            newStudent.subjects = new ArrayList<>();
            return this;
        }

        public Student.Builder facultyName(FacultyName facultyName) {
            newStudent.facultyName = facultyName;
            return this;
        }

        public Student.Builder groupName(GroupName groupName) {
            newStudent.groupName = groupName;
            return this;
        }

        public Student build() {
            return newStudent;
        }
    }
    public List<Subject> getSubjects() throws NoSubjectsException {
        if (subjects.isEmpty()) throw new NoSubjectsException("There are no subjects in the List, please add subject");
        return subjects;
    }

    public Subject getSubject (Category expectedCategory) throws NoSuchSubjectException, NoSubjectsException {
        for (Subject subject : getSubjects()) {
            if (subject.getCategory().equals(expectedCategory)){
                return subject;
            }
        }
        throw new NoSuchSubjectException("There is no such subject " + expectedCategory + "in the University" );
    }

    public void addSubject (Subject subject){
        subjects.add(subject);
    }
    public double getAverageGradeForStudent () throws NoSuchStudentException, NoSubjectsException {
        int sum = 0;
        int numberOfMarks = 0;
            for (Subject subject : getSubjects()){
                sum += subject.getGrade();
                numberOfMarks++;
            }

        if (numberOfMarks == 0) {
            throw new NoSuchStudentException("There is no such student");
        }
        return (double) sum/numberOfMarks;
    }
}
