package exceptions.faculties;

import exceptions.Student;
import exceptions.exeptions.*;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final FacultyName facultyName;
    private List<Group> groups;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
        groups = new ArrayList<>();
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public Group getGroup (GroupName expectedGroup) throws NoGroupsException, NoSuchGroupException {
        for (Group group : getGroups()) {
            if (group.getGroupName().equals(expectedGroup)){
                return group;
            }
        }
        throw new NoSuchGroupException("There are only 4 groups in the University");
    }
    public void addGroup (Group group){
        groups.add(group);
    }

    public List<Group> getGroups () throws NoGroupsException {
        if (groups.isEmpty()) throw new NoGroupsException("There are no students in the group");
        return groups;
    }

    public double getAverageGradeForFaculty () throws NoStudentsException, NoSubjectsException, NoGroupsException {
        int sum = 0;
        int numberOfMarks = 0;
        for (Group group : getGroups()) {
            for (Student student : group.getStudents()){
                for (Subject subject : student.getSubjects()){
                    sum += subject.getGrade();
                    numberOfMarks++;
                }
            }
    }
        if (numberOfMarks == 0) {
            throw new ArithmeticException("Division by 0");
        }
        return (double) sum/numberOfMarks;
}
}
