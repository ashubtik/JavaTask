package exceptions;

import exceptions.exeptions.*;
import exceptions.faculties.Faculty;
import exceptions.faculties.FacultyName;
import exceptions.groups.Group;
import exceptions.groups.GroupName;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;

public class UniversityMain {
    public static void main(String[] args) throws NoGroupsException, NoSuchFacultyException, NoStudentsException, NoSuchGroupException, NoSuchStudentException, NoSubjectsException, NoFacultiesException, MarkOutOfBoundException {
//                Student geoffrey = new Student.Builder()
//                        .name("Geoffrey Baratheon")
//                        .subjects(Category.PoisonSubject, 10)
//                        .subjects(Category.IntrigueArt, 8)
//                        .subjects(Category.WarCraft, 4)
//                        .facultyName(FacultyName.IntrigueFaculty)
//                        .groupName(GroupName.Baratheons)
//                        .build();
//                Student barristan = new Student.Builder()
//                        .name("Barristan Selmy")
//                        .subjects(Category.DragonSubject, 2)
//                        .subjects(Category.TreasonArt, 3)
//                        .subjects(Category.WarCraft, 10)
//                        .facultyName(FacultyName.TreasonFaculty)
//                        .groupName(GroupName.Targariens)
//                        .build();
//                Student petyr = new Student.Builder()
//                        .name("Petyr Baelish")
//                        .subjects(Category.PoisonSubject, 10)
//                        .subjects(Category.IntrigueArt, 10)
//                        .subjects(Category.WarCraft, 8)
//                        .facultyName(FacultyName.IntrigueFaculty)
//                        .groupName(GroupName.Baratheons)
//                        .build();
//                Student arya = new Student.Builder()
//                        .name("Arya Stark")
//                        .subjects(Category.DecapitationSubject, 8)
//                        .subjects(Category.IntrigueArt, 4)
//                        .subjects(Category.WarCraft, 9)
//                        .facultyName(FacultyName.IntrigueFaculty)
//                        .groupName(GroupName.Starks)
//                        .build();
//                Student tywin = new Student.Builder()
//                        .name("Tywin Lannister")
//                        .subjects(Category.WealthSubject, 10)
//                        .subjects(Category.TreasonArt, 10)
//                        .subjects(Category.WarCraft, 10)
//                        .facultyName(FacultyName.TreasonFaculty)
//                        .groupName(GroupName.Lannisters)
//                        .build();
//                Student cersei = new Student.Builder()
//                        .name("Cersei Lannister")
//                        .subjects(Category.WealthSubject, 9)
//                        .subjects(Category.TreasonArt, 10)
//                        .subjects(Category.WarCraft, 7)
//                        .facultyName(FacultyName.TreasonFaculty)
//                        .groupName(GroupName.Lannisters)
//                        .build();
//                Student ned = new Student.Builder()
//                        .name("Eddard Stark")
//                        .subjects(Category.DecapitationSubject, 10)
//                        .subjects(Category.IntrigueArt, 2)
//                        .subjects(Category.WarCraft, 8)
//                        .facultyName(FacultyName.IntrigueFaculty)
//                        .groupName(GroupName.Starks)
//                        .build();
//                Student jorah = new Student.Builder()
//                        .name("Jorah Mormont")
//                        .subjects(Category.DragonSubject, 7)
//                        .subjects(Category.IntrigueArt, 8)
//                        .subjects(Category.WarCraft, 9)
//                        .facultyName(FacultyName.TreasonFaculty)
//                        .groupName(GroupName.Targariens)
//                        .build();


        University university = new University();
        Faculty treasonFaculty = new Faculty(FacultyName.IntrigueFaculty);
        university.addFaculty(treasonFaculty);
        Group baratheons = new Group(GroupName.Baratheons);
        treasonFaculty.addGroup(baratheons);
        Student petyr = new Student.Builder()
                .name("Petyr Baelish")
                .subjects(Category.PoisonSubject, 10)
                .subjects(Category.IntrigueArt, 10)
                .subjects(Category.WarCraft, 8)
                .facultyName(FacultyName.IntrigueFaculty)
                .groupName(GroupName.Baratheons)
                .build();
        baratheons.addStudent(petyr);
        Subject warCraft1 = new Subject(Category.WarCraft, 8);
        Subject poisonSubject1 = new Subject(Category.PoisonSubject, 10);
        Subject intrigueArt1 = new Subject(Category.IntrigueArt, 9);
        petyr.addSubject(warCraft1);
        petyr.addSubject(poisonSubject1);
        petyr.addSubject(intrigueArt1);

        Student geoffrey = new Student.Builder()
                .name("Geoffrey Baratheon")
                .subjects(Category.PoisonSubject, 10)
                .subjects(Category.IntrigueArt, 8)
                .subjects(Category.WarCraft, 3)
                .facultyName(FacultyName.IntrigueFaculty)
                .groupName(GroupName.Baratheons)
                .build();
        baratheons.addStudent(geoffrey);
        Subject warCraft2 = new Subject(Category.WarCraft, 3);
        Subject poisonSubject2 = new Subject(Category.PoisonSubject, 10);
        Subject intrigueArt2 = new Subject(Category.IntrigueArt, 8);
        geoffrey.addSubject(warCraft2);
        geoffrey.addSubject(poisonSubject2);
        geoffrey.addSubject(intrigueArt2);

        double average = geoffrey.getAverageGradeForStudent();
        System.out.println(average);
    }
}

