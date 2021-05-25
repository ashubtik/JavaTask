package Exceptions.TreasonFaculty;

import Exceptions.GradeException;
import Exceptions.Student;

import java.util.Objects;

public class StudentOfTreasonFaculty extends Student {
    private final int treasonArtGrade;

    public StudentOfTreasonFaculty(String name, String faculty, String group, int warCraftGrade, int treasonArtGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade);
        this.treasonArtGrade = treasonArtGrade;
    }

    public int getTreasonArtGrade() {
        return treasonArtGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfTreasonFaculty that = (StudentOfTreasonFaculty) o;
        return treasonArtGrade == that.treasonArtGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), treasonArtGrade);
    }

    @Override
    public String toString() {
        return "StudentOfTreasonFaculty{" +
                "warCraftGrade=" + warCraftGrade +
                ", treasonArtGrade=" + treasonArtGrade +
                '}';
    }
}
