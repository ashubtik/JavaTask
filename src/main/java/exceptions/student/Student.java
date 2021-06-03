package exceptions.student;

import exceptions.exeptions.NoSubjectsException;
import exceptions.exeptions.NoSuchSubjectException;
import exceptions.subjects.Category;
import exceptions.subjects.Subject;

import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private List<Subject> subjects;

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() throws NoSubjectsException {
        if (subjects.isEmpty()) throw new NoSubjectsException("There are no subjects in the List, please add subject");
        return subjects;
    }

    public Subject getSubject(Category expectedCategory) throws NoSuchSubjectException, NoSubjectsException {
        for (Subject subject : getSubjects()) {
            if (subject.getCategory().equals(expectedCategory)) {
                return subject;
            }
        }
        throw new NoSuchSubjectException("There is no such subject " + expectedCategory + "in the University");
    }

    public void addSubject(Subject subject) {
        subjects.add(subject);
    }

    public double getAverageGrade() throws NoSubjectsException {
        return getAverageGrade(null);
    }

    public double getAverageGrade(Category category) throws NoSubjectsException {
        int sum = 0;
        int numberOfMarks = 0;
        for (Subject subject : getSubjects()) {
            if (category == null) {
                sum += subject.getGrade();
                numberOfMarks++;
            } else if (subject.getCategory().equals(category)) {
                sum += subject.getGrade();
                numberOfMarks = 1;
            }
        }
        if (numberOfMarks == 0) {
            throw new NoSubjectsException("There are no subjects in the List, please add subject");
        }
        return (double) sum / numberOfMarks;
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

        public Student build() {
            return newStudent;
        }
    }
}
