import org.junit.Assert;
import org.junit.jupiter.api.Test;

class Date2Test {


  int testDay = 1;
  int testMonth = 1;
  int testYear = 2000;
  Date date = new Date(testMonth, testDay, testYear);


  @Test
  public void testReadInputDay() {
    Assert.assertTrue(date.getDay() == testDay);
  }

  @Test
  public void testReadInputMonth() {
    Assert.assertTrue(date.getMonth() == testMonth);
  }

  @Test
  public void testReadInputYear() {
    Assert.assertTrue(date.getYear() == testYear);
  }

}
