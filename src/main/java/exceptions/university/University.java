package exceptions.university;

import exceptions.exeptions.*;
import exceptions.faculties.Faculty;
import exceptions.faculties.FacultyName;
import exceptions.groups.Group;
import exceptions.student.Student;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class University {
    private final List<Faculty> faculties;

    public University() {
        faculties = new ArrayList<>();
    }

    public Faculty getFaculty(FacultyName expectedFaculty) throws NoFacultiesException, NoSuchFacultyException {
        for (Faculty faculty : getFaculties()) {
            if (faculty.getFacultyName().equals(expectedFaculty)) {
                return faculty;
            }
        }
        throw new NoSuchFacultyException("There are only 2 faculties in the University");
    }

    public void addFaculty(Faculty faculty) {
        faculties.add(faculty);
    }

    public List<Faculty> getFaculties() throws NoFacultiesException {
        if (faculties.isEmpty()) throw new NoFacultiesException("There are no groups in the faculty");
        return faculties;
    }

    public double getAverageGrade() throws NoSubjectsException, NoFacultiesException, NoGroupsException, NoStudentsException {
        return getAverageGrade(null);
    }

    public double getAverageGrade(Category category) throws NoStudentsException, NoGroupsException, NoSubjectsException, NoFacultiesException {
        int sum = 0;
        int numberOfMarks = 0;
        for (Faculty faculty : getFaculties()) {
            for (Group group : faculty.getGroups()) {
                for (Student student : group.getStudents()) {
                    for (Subject subject : student.getSubjects()) {
                        if (category == null || subject.getCategory().equals(category)) {
                            sum += subject.getGrade();
                            numberOfMarks++;
                        }
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


