import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.testng.Assert.assertEquals;

public class test {

    studentBook a = new studentBook("Ivan",4);
    @Test
    public void diplomtest() throws Exception {
        a.addClass("Math",1,2);
        a.addClass("OS",1,3);
        a.addClass("Prolog",2,3);
        a.addClass("II",3,3);
        a.addGrades(new int[]{3, 5, 5, 5});
        a.addGrades(new int[]{5,5,5,5});
        a.setqGrade(5);
        a.addGrades(new int[]{5, 5, 5, 5});
        assert (!a.diplom());
        a.changeGrade("Math",1,5);
        assert (a.diplom());
        a.setqGrade(4);
        assert (!a.diplom());
    }
    @Test
    public void medGradeTest() throws Exception{
        assert(a.mediumGrades()==5);
    }
    @Test
    public void invalidGradeTest(){

    }
}
