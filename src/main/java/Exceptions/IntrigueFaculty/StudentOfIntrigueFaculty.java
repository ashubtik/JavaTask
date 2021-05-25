package Exceptions.IntrigueFaculty;

import Exceptions.GradeException;
import Exceptions.Student;

import java.util.Objects;

public class StudentOfIntrigueFaculty extends Student {
    private final int intrigueArtGrade;

    public StudentOfIntrigueFaculty(String name, String faculty, String group, int warCraftGrade, int intrigueArtGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade);
        this.intrigueArtGrade = intrigueArtGrade;
    }

    public int getIntrigueArtGrade() {
        return intrigueArtGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfIntrigueFaculty that = (StudentOfIntrigueFaculty) o;
        return intrigueArtGrade == that.intrigueArtGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), intrigueArtGrade);
    }

    @Override
    public String toString() {
        return "StudentOfIntrigueFaculty{" +
                "specialSubjectGrade=" + intrigueArtGrade +
                ", commonSubjectGrade=" + warCraftGrade +
                '}';
    }
}

