package Exceptions;

import java.util.Objects;

public class Student {
    String name;
    String faculty;
    String group;
    public int warCraftGrade;

    public String getName() {
        return name;
    }

    public String getFaculty() {
        return faculty;
    }

    public String getGroup() {
        return group;
    }

    public int getWarCraftGrade() {
        return warCraftGrade;
    }

    public Student(String name, String faculty, String group, int warCraftGrade) throws GradeException{
        if (warCraftGrade < 0 || warCraftGrade > 10)
            throw new GradeException("Wrong grade");
            this.warCraftGrade = warCraftGrade;
            this.name = name;
            this.faculty = faculty;
            this.group = group;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return warCraftGrade == student.warCraftGrade && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, warCraftGrade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", warCraftGrade=" + warCraftGrade +
                '}';
    }
}
