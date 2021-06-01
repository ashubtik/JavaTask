package exceptions.subjects;

import exceptions.Student;
import exceptions.exeptions.MarkOutOfBoundException;

import java.util.List;

public class Subject {
    private final Category category;
    public int grade;


    public Subject(Category category, int grade) throws MarkOutOfBoundException {
        if (grade < 0 || grade > 10) {
            throw new MarkOutOfBoundException("Wrong grade, expected from 0 to 10, actual " + grade);
        }
        this.category = category;
        this.grade = grade;
    }

    public Category getCategory() {
        return category;
    }

    public int getGrade() {
        return grade;
    }


}


