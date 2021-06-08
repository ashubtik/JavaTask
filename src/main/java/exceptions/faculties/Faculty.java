package exceptions.faculties;

import exceptions.exeptions.NoGroupsException;
import exceptions.exeptions.NoStudentsException;
import exceptions.exeptions.NoSubjectsException;
import exceptions.exeptions.NoSuchGroupException;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.student.Student;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Faculty {
    private final FacultyName facultyName;
    private final List<Group> groups;

    public Faculty(FacultyName facultyName) {
        this.facultyName = facultyName;
        groups = new ArrayList<>();
    }

    public FacultyName getFacultyName() {
        return facultyName;
    }

    public Group getGroup(GroupName expectedGroup) throws NoGroupsException, NoSuchGroupException {
        for (Group group : getGroups()) {
            if (group.getGroupName().equals(expectedGroup)) {
                return group;
            }
        }
        throw new NoSuchGroupException("There are only 4 groups in the University");
    }

    public void addGroup(Group group) {
        groups.add(group);
    }

    public List<Group> getGroups() throws NoGroupsException {
        if (groups.isEmpty()) throw new NoGroupsException("There are no students in the group");
        return groups;
    }

    public double getAverageGrade() throws NoSubjectsException, NoGroupsException, NoStudentsException {
        return getAverageGrade(null);
    }

    public double getAverageGrade(Category category) throws NoStudentsException, NoSubjectsException, NoGroupsException {
        int sum = 0;
        int numberOfMarks = 0;
        for (Group group : getGroups()) {
            for (Student student : group.getStudents()) {
                for (Subject subject : student.getSubjects()) {
                    if (category == null || subject.getCategory().equals(category)) {
                        sum += subject.getGrade();
                        numberOfMarks++;
                    }
                }
            }
        }
        if (numberOfMarks == 0) {
            throw new NoSubjectsException("There are no subjects in the List, please add subject");
        }
        return (double) sum / numberOfMarks;
    }
}
