package Exceptions.IntrigueFaculty;

import Exceptions.GradeException;

import java.util.Objects;

public class StudentOfBaratheonGroup extends StudentOfIntrigueFaculty{
    private final int poisonSubjectGrade;

    public StudentOfBaratheonGroup(String name, String faculty, String group, int warCraftGrade, int intrigueArtGrade, int poisonSubjectGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade, intrigueArtGrade);
        this.poisonSubjectGrade = poisonSubjectGrade;
    }

    public int getPoisonSubjectGrade() {
        return poisonSubjectGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfBaratheonGroup that = (StudentOfBaratheonGroup) o;
        return poisonSubjectGrade == that.poisonSubjectGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poisonSubjectGrade);
    }

    @Override
    public String toString() {
        return "StudentOfBaratheonGroup{" +
                "poisonSubjectGrade=" + poisonSubjectGrade +
                ", warCraftGrade=" + warCraftGrade +
                '}';
    }
}
