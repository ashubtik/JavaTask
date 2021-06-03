package exceptions.subjects;

import exceptions.exeptions.MarkOutOfBoundException;

public class Subject {
    private final Category category;
    private final int grade;


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


