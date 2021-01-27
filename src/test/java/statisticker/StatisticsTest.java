package statisticker;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * This is test class to test the functionality of {@link Statistics} class
 *
 * @author Adarsh Avadhoothrao
 *
 */
public class StatisticsTest
{
  @Test
  public void reportsAverageMinMaxx()
  {
    Float[] numbers = { 1.5f, 8.9f, 3.2f, 4.5f };
    List<Float> numberList = Arrays.asList(numbers);

    Stats s = Statistics.getStatistics(numberList);

    float epsilon = 0.001f;
    // As per static code analysis on coding standards (from sonarqube), swapped actual and expected result arguments
    assertEquals(4.525f, s.getAverage(), epsilon);
    assertEquals(1.5f, s.getMin(), epsilon);
    assertEquals(8.9f, s.getMax(), epsilon);
  }

  @Test
  public void reportsNaNForEmptyInput()
  {
    List<Float> emptyList = new ArrayList<>();

    Stats s = Statistics.getStatistics(emptyList);
    assertTrue(Float.isNaN(s.getAverage()));
    assertTrue(Float.isNaN(s.getMin()));
    assertTrue(Float.isNaN(s.getMax()));
  }

  @Test
  public void reportsAlertsIfMaxIsMoreThanThreshold()
  {
    EmailAlert emailAlerter = new EmailAlert();
    LEDAlert ledAlerter = new LEDAlert();
    IAlerter alerters[] = { emailAlerter, ledAlerter };
    float maxThreshold = 10.2f;
    StatsChecker checker = new StatsChecker(maxThreshold, alerters);

    Float[] numbers = { 11.5f, 6.9f, 7.5f, 6.6f };
    List<Float> numberList = Arrays.asList(numbers);
    checker.checkAndAlert(numberList);

    assertTrue(emailAlerter.isEmailSent());
    assertTrue(ledAlerter.isLEDGlows());
  }
}
