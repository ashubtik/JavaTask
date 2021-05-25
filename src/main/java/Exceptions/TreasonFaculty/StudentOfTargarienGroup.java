package Exceptions.TreasonFaculty;

import Exceptions.GradeException;

import java.util.Objects;

public class StudentOfTargarienGroup extends StudentOfTreasonFaculty{
    private final int dragonSubjectGrade;

    public StudentOfTargarienGroup(String name, String faculty, String group, int warCraftGrade, int treasonArtGrade, int dragonSubjectGrade) throws GradeException {
        super(name, faculty, group, warCraftGrade, treasonArtGrade);
        this.dragonSubjectGrade = dragonSubjectGrade;
    }

    public int getDragonSubjectGrade() {
        return dragonSubjectGrade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        StudentOfTargarienGroup that = (StudentOfTargarienGroup) o;
        return dragonSubjectGrade == that.dragonSubjectGrade;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), dragonSubjectGrade);
    }

    @Override
    public String toString() {
        return "StudentOfTargarienGroup{" +
                "warCraftGrade=" + warCraftGrade +
                ", dragonSubjectGrade=" + dragonSubjectGrade +
                '}';
    }
}
