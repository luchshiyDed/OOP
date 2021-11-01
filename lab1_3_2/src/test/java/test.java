import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class test {

   private studentBook init() throws Exception {
       studentBook a = new studentBook("Ivan");
       a.addClass("math",1,3);
       a.addClass("OS",1,1);
       a.addClass("TV",2,3);
       return a;
   }
    @Test
    public void Functest() throws Exception {
        studentBook a = init();
        a.setqGrade(5);
        a.setGrade("math",1,5);
        a.setGrade("OS",1,5);
        assert (a.stipendia());
        assert(a.mediumGrades()==5);
        assert (a.diplom());
        a.setGrade("TV",2,5);
        a.setGrade("math",2,4);
        assert(!a.stipendia());
    }
    @Test
    public void invalidGradeTest() throws Exception {
        studentBook a = init();
        studentBook.gradeExeption e = assertThrows(studentBook.gradeExeption.class, () ->
        {a.setGrade("x",1,2);});
        assertEquals(e.getMessage(),"x- No such class found");
        studentBook.gradeExeption e1 = assertThrows(studentBook.gradeExeption.class, () ->
        {a.setGrade("math",-1,2);});
        assertEquals(e1.getMessage(),"math- There is no such class in this semester or invalid semester number");
        studentBook.gradeExeption e2 = assertThrows(studentBook.gradeExeption.class, () ->
        {a.setGrade("math",1,7);});
        assertEquals(e2.getMessage(),"math-Has invalid grade. Grade must be between 2 and 5");
        studentBook.gradeExeption e3 = assertThrows(studentBook.gradeExeption.class, () ->
        {a.setqGrade(7);});
        assertEquals(e3.getMessage(),"qualification grade-Has invalid grade. Grade must be between 2 and 5");
    }
    @Test
    public void invalidClassTest() throws Exception {
        studentBook a = init();
        studentBook.gradeExeption e2 = assertThrows(studentBook.gradeExeption.class, () ->
        {a.addClass("new",-1,7);});
        assertEquals(e2.getMessage(),"new Has invalid number of semesters");
    }
}
