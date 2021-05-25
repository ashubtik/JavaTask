package Exceptions.IntrigueFaculty;

import Exceptions.GradeException;

import java.util.Objects;

public class StudentOfStarkGroup extends StudentOfIntrigueFaculty{
    private final int decapitationSubjectGrade;

    public StudentOfStarkGroup(String name, String faculty, String group, int warCraftGrade, int intrigueArtGrade, int decapitationSubjectGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade, intrigueArtGrade);
        this.decapitationSubjectGrade = decapitationSubjectGrade;
    }

    public int getDecapitationSubjectGrade() {
        return decapitationSubjectGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfStarkGroup that = (StudentOfStarkGroup) o;
        return decapitationSubjectGrade == that.decapitationSubjectGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), decapitationSubjectGrade);
    }

    @Override
    public String toString() {
        return "StudentOfStarkGroup{" +
                "decapitationSubjectGrade=" + decapitationSubjectGrade +
                ", warCraftGrade=" + warCraftGrade +
                '}';
    }
}
