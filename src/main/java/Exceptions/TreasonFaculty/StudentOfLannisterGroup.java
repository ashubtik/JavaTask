package Exceptions.TreasonFaculty;

import Exceptions.GradeException;

import java.util.Objects;

public class StudentOfLannisterGroup extends StudentOfTreasonFaculty{
    private final int wealthSubjectGrade;

    public StudentOfLannisterGroup(String name, String faculty, String group, int warCraftGrade, int treasonArtGrade, int wealthSubjectGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade, treasonArtGrade);
        this.wealthSubjectGrade = wealthSubjectGrade;
    }

    public int getWealthSubjectGrade() {
        return wealthSubjectGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfLannisterGroup that = (StudentOfLannisterGroup) o;
        return wealthSubjectGrade == that.wealthSubjectGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), wealthSubjectGrade);
    }

    @Override
    public String toString() {
        return "StudentOfLannisterGroup{" +
                "warCraftGrade=" + warCraftGrade +
                ", wealthSubjectGrade=" + wealthSubjectGrade +
                '}';
    }
}
