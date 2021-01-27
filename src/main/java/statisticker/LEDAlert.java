package statisticker;

/**
 * LED Alerter bean class that holds the data based on the threshold
 *
 * @author Adarsh Avadhoothrao
 *
 */
public class LEDAlert implements IAlerter
{
  private boolean isLEDGlows;

  public boolean isLEDGlows()
  {
    return this.isLEDGlows;
  }

  public void setLEDGlows(final boolean isLEDGlows)
  {
    this.isLEDGlows = isLEDGlows;
  }

}
