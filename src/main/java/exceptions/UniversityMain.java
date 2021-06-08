package exceptions;

import exceptions.exeptions.*;
import exceptions.faculties.Faculty;
import exceptions.faculties.FacultyName;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.student.Student;
import exceptions.subjects.Category;
import exceptions.university.University;

public class UniversityMain {
    public static void main(String[] args) throws NoGroupsException, NoSuchFacultyException, NoStudentsException, NoSuchGroupException, NoSuchStudentException, NoSubjectsException, NoFacultiesException, MarkOutOfBoundException, NoSuchSubjectException {
        University university = new University();
        Faculty treasonFaculty = new Faculty(FacultyName.TreasonFaculty);
        Faculty intrigueFaculty = new Faculty(FacultyName.IntrigueFaculty);
        university.addFaculty(treasonFaculty);
        university.addFaculty(intrigueFaculty);
        Group baratheons = new Group(GroupName.Baratheons);
        Group starks = new Group(GroupName.Starks);
        Group targariens = new Group(GroupName.Targariens);
        Group lannisters = new Group(GroupName.Lannisters);
        intrigueFaculty.addGroup(baratheons);
        intrigueFaculty.addGroup(starks);
        treasonFaculty.addGroup(targariens);
        treasonFaculty.addGroup(lannisters);

        Student petyr = Student.builder()
                .name("Petyr Baelish")
                .subjects(Category.PoisonSubject, 10)
                .subjects(Category.IntrigueArt, 10)
                .subjects(Category.WarCraft, 7)
                .build();
        baratheons.addStudent(petyr);

        Student geoffrey = Student.builder()
                .name("Geoffrey Baratheon")
                .subjects(Category.PoisonSubject, 10)
                .subjects(Category.IntrigueArt, 8)
                .subjects(Category.WarCraft, 3)
                .build();
        baratheons.addStudent(geoffrey);

        Student barristan = Student.builder()
                .name("Barristan Selmy")
                .subjects(Category.DragonSubject, 2)
                .subjects(Category.TreasonArt, 3)
                .subjects(Category.WarCraft, 10)
                .build();
        targariens.addStudent(barristan);

        Student ned = Student.builder()
                .name("Eddard Stark")
                .subjects(Category.DecapitationSubject, 10)
                .subjects(Category.WarCraft, 8)
                .build();
        starks.addStudent(ned);

        Student tywin = Student.builder()
                .name("Tywin Lannister")
                .subjects(Category.WealthSubject, 10)
                .subjects(Category.WarCraft, 10)
                .build();
        lannisters.addStudent(tywin);

        double averageGradeForUniversity = university.getAverageGrade(Category.WarCraft);
        System.out.format("\n%.2f", averageGradeForUniversity);

        double averageGradeForFaculty = intrigueFaculty.getAverageGrade(Category.IntrigueArt);
        System.out.format("\n%.2f", averageGradeForFaculty);

        double averageGradeForGroup = baratheons.getAverageGrade();
        System.out.format("\n%.2f", averageGradeForGroup);

        double averageGradeForStudent = petyr.getAverageGrade();
        System.out.format("\n%.2f", averageGradeForStudent);
    }
}

