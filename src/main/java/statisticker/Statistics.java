package statisticker;

import java.util.Collections;
import java.util.List;
import java.util.function.ToDoubleFunction;

/**
 * Utility/helper class to compute the statistics
 *
 * @author Adarsh Avadhoothrao
 *
 */
public class Statistics
{
  private Statistics()
  {
    // hiding the constructor as this is utility class and does not require to instantiate
  }

  /**
   * This method performs the statistics computation such as average, min and max of numbers
   *
   * @param numbers
   *                  - list of float numbers on which we need perform computation
   * @return an object which holds the computed data
   */
  public static Stats getStatistics(final List<Float> numbers)
  {
    Stats stats = new Stats();
    // as per the requirement, if the list is empty then we must say that average, min and max are NaN (not a number)
    if (numbers.isEmpty())
    {
      stats.setAverage(Float.NaN);
      stats.setMin(Float.NaN);
      stats.setMax(Float.NaN);
    }
    else
    {
      // finding the average of numbers and here it was not possible to change this anonymous class to lambda expression as the project needs JRE8 configuration
      stats.setAverage((float) numbers.stream().mapToDouble(new ToDoubleFunction<Float>()
      {
        @Override
        public double applyAsDouble(final Float number)
        {
          return number;
        }
      }).average().orElse(0.0));
      Collections.sort(numbers);
      // setting the minimum number to Stats object
      stats.setMin(numbers.get(0));
      // setting the maximum number to Stats object
      stats.setMax(numbers.get(numbers.size() - 1));
    }
    return stats;
  }
}
