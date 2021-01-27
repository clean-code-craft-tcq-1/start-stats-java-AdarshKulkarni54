package statisticker;

import java.util.List;

/**
 * This class check set the respective value to {@link EmailAlert} and {@link LEDAlert} based on max threshold calculation
 *
 * @author Adarsh Avadhoothrao
 *
 */
public class StatsChecker
{
  private float maxThreshold;
  private IAlerter[] alerters;

  public StatsChecker(final float maxThreshold, final IAlerter[] alerters)
  {
    this.maxThreshold = maxThreshold;
    this.alerters = alerters;
  }

  public float getMaxThreshold()
  {
    return this.maxThreshold;
  }

  public IAlerter[] getAlerters()
  {
    return this.alerters;
  }

  /**
   * This method will compare max value from list of number to max threshold value if it is greater than threshold value then it will set the respective value
   *
   * @param numbers
   *                  - list of numbers
   */
  public void checkAndAlert(final List<Float> numbers)
  {
    Stats stats = Statistics.getStatistics(numbers);
    if (stats.getMax() > getMaxThreshold())
    {
      for (IAlerter alerter : getAlerters())
      {
        if (alerter instanceof EmailAlert)
        {
          ((EmailAlert) alerter).setEmailSent(true);
        }
        else if (alerter instanceof LEDAlert)
        {
          ((LEDAlert) alerter).setLEDGlows(true);
        }
      }
    }
  }
}
