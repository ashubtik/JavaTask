package Exceptions;

import Exceptions.IntrigueFaculty.StudentOfBaratheonGroup;
import Exceptions.IntrigueFaculty.StudentOfStarkGroup;
import Exceptions.TreasonFaculty.StudentOfLannisterGroup;
import Exceptions.TreasonFaculty.StudentOfTargarienGroup;
import Exceptions.TreasonFaculty.StudentOfTreasonFaculty;

import java.util.stream.IntStream;

import java.util.*;

public class UniversityOfThrones {
    static List<Student> students;

    static {
        try {
            students = Arrays.asList(
                new StudentOfBaratheonGroup("Geoffrey Baratheon", "IF", "Deers", 3, 7, 10),
                new StudentOfBaratheonGroup("Barristan Selmy", "IF", "Deers", 10, 3, 2),
                new StudentOfBaratheonGroup("Sandor Clegane", "IF", "Deers", 9, 5, 4),
                new StudentOfBaratheonGroup("Robert Baratheon", "IF", "Deers", 8, 6, 10),
                new StudentOfBaratheonGroup("Petyr Baelish", "IF", "Deers", 7, 10, 10),
                new StudentOfStarkGroup("Arya Stark","IF", "Wolves", 9, 5, 8),
                new StudentOfStarkGroup("John Snow", "IF", "Wolves",8, 2, 8),
                new StudentOfStarkGroup("Rob Stark", "IF", "Wolves",9, 4, 10),
                new StudentOfStarkGroup("Lysa Arryn", "IF", "Wolves",4, 10, 5),
                new StudentOfStarkGroup("Eddard Stark", "IF", "Wolves",9, 2, 10),
                new StudentOfLannisterGroup("Tywin Lannister", "TF", "Lions",10, 10, 10),
                new StudentOfLannisterGroup("Cersei Lannister", "TF", "Lions",6, 9, 8),
                new StudentOfLannisterGroup("Podrick Payne", "TF", "Lions",5, 2, 2),
                new StudentOfLannisterGroup("Gregor Clegane", "TF", "Lions",8, 6, 3),
                new StudentOfLannisterGroup("Bronn", "TF", "Lions",9, 7, 4),
                new StudentOfTargarienGroup("Daenerys Targaryen", "TF", "Dragons", 10, 4, 10),
                new StudentOfTargarienGroup("Jorah Mormont", "TF", "Dragons",8, 9, 3),
                new StudentOfTargarienGroup("Davos Seaworth", "TF", "Dragons", 8, 3, 2),
                new StudentOfTargarienGroup("Viserys Targaryen", "TF", "Dragons", 2, 9, 3),
                new StudentOfTargarienGroup("Khal Drogo", "TF", "Dragons", 10, 3, 3)
            );
        } catch (GradeException e) {
            System.out.println("Grade is out of range (0-10)");
        }
    }

    public static void main(String[] args) {
            double warCraftAverageGrade = students.stream()
                    .mapToDouble(Student::getWarCraftGrade)
                    .average()
                    .getAsDouble();
            System.out.println("Average grade in WarCraft for the entire university = " + warCraftAverageGrade);

        try {
            double averageGradeForFaculty = students.stream()
                    .filter((faculty) -> faculty.getFaculty().equals("TF"))
                    .flatMapToInt(faculty -> {
                        if(faculty instanceof StudentOfTreasonFaculty treason){
                            return IntStream.of(treason.getTreasonArtGrade());
                        } else {
                            return null;
                        }
                    })
                    .average()
                    .getAsDouble();
            System.out.println("Average grade in Treason for TreasonFaculty = " + averageGradeForFaculty);
        } catch (NoSuchElementException e) {
            System.out.println("!!! There's no such faculty in the UniversityOfThrones !!!");
        }

        try {
            double averageGradeForTheCertainGroup = students.stream()
                    .filter((group) -> group.getGroup().equals("Wolves"))
                    .flatMapToInt(group -> {
                        if(group instanceof StudentOfStarkGroup starks){
                            return IntStream.of(starks.getDecapitationSubjectGrade());
                        } else {
                            return null;
                        }
                    })
                    .average()
                    .getAsDouble();
            System.out.println("Average grade in Decapitation for Starks = " + averageGradeForTheCertainGroup);
        } catch (NoSuchElementException e) {
            System.out.println("!!! There's no such group in the UniversityOfThrones !!!");
        }

        try {
            double averageGradeOfTheCertainStudent = students.stream()
                    .filter((student) -> student.getName().equals("Petyr Baelish"))
                    .flatMapToInt(student -> {
                        if(student instanceof StudentOfBaratheonGroup studentOfGroup){
                            return IntStream.of(studentOfGroup.getPoisonSubjectGrade(),
                                    studentOfGroup.getIntrigueArtGrade(), student.getWarCraftGrade());
                        } else {
                            return IntStream.of(student.getWarCraftGrade());
                        }
                    })
                    .average()
                    .getAsDouble();
            System.out.println("Average grade of student Petyr Baelish = " + averageGradeOfTheCertainStudent);
        } catch (NoSuchElementException e) {
            System.out.println("!!! There's no such student in the UniversityOfThrones !!!");
        }
    }
}

