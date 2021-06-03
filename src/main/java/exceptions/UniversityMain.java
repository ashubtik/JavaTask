package exceptions;

import exceptions.exeptions.*;
import exceptions.faculties.Faculty;
import exceptions.faculties.FacultyName;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.student.Student;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;
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
        petyr.addSubject(new Subject(Category.WarCraft, 7));
        petyr.addSubject(new Subject(Category.IntrigueArt, 10));
        petyr.addSubject(new Subject(Category.PoisonSubject, 10));

        Student geoffrey = Student.builder()
                .name("Geoffrey Baratheon")
                .subjects(Category.PoisonSubject, 10)
                .subjects(Category.IntrigueArt, 8)
                .subjects(Category.WarCraft, 3)
                .build();
        baratheons.addStudent(geoffrey);
        geoffrey.addSubject(new Subject(Category.WarCraft, 3));
        geoffrey.addSubject(new Subject(Category.PoisonSubject, 10));
        geoffrey.addSubject(new Subject(Category.IntrigueArt, 8));

        Student barristan = Student.builder()
                .name("Barristan Selmy")
                .subjects(Category.DragonSubject, 2)
                .subjects(Category.TreasonArt, 3)
                .subjects(Category.WarCraft, 10)
                .build();
        targariens.addStudent(barristan);
        barristan.addSubject(new Subject(Category.WarCraft, 10));
        barristan.addSubject(new Subject(Category.DragonSubject, 3));
        barristan.addSubject(new Subject(Category.TreasonArt, 2));

        Student ned = Student.builder()
                .name("Eddard Stark")
                .subjects(Category.DecapitationSubject, 10)
                .subjects(Category.WarCraft, 8)
                .build();
        starks.addStudent(ned);
        ned.addSubject(new Subject(Category.DecapitationSubject, 10));
        ned.addSubject(new Subject(Category.WarCraft, 8));

        Student tywin = new Student.Builder()
                .name("Tywin Lannister")
                .subjects(Category.WealthSubject, 10)
                .subjects(Category.WarCraft, 10)
                .build();
        lannisters.addStudent(tywin);
        tywin.addSubject(new Subject(Category.WarCraft, 10));
        tywin.addSubject(new Subject(Category.WealthSubject, 10));

        double averageGradeForUniversity = university.getAverageGrade(Category.WarCraft);
        System.out.format("\n%.2f", averageGradeForUniversity);

        double averageGradeForFaculty = intrigueFaculty.getAverageGrade();
        System.out.format("\n%.2f", averageGradeForFaculty);

        double averageGradeForGroup = baratheons.getAverageGrade(Category.PoisonSubject);
        System.out.format("\n%.2f", averageGradeForGroup);

        double averageGradeForStudent = petyr.getAverageGrade();
        System.out.format("\n%.2f", averageGradeForStudent);
    }
}

