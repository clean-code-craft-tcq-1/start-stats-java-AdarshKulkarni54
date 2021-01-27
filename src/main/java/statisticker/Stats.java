package statisticker;

/**
 * This is a bean class that holds the average, min and max data
 * 
 * @author RDV1KOR
 *
 */
public class Stats
{
  private float average;
  private float min;
  private float max;

  public float getAverage()
  {
    return this.average;
  }

  public void setAverage(final float average)
  {
    this.average = average;
  }

  public float getMin()
  {
    return this.min;
  }

  public void setMin(final float min)
  {
    this.min = min;
  }

  public float getMax()
  {
    return this.max;
  }

  public void setMax(final float max)
  {
    this.max = max;
  }

}
