package statisticker;

/**
 * Email Alerter bean class that holds the data based on the threshold
 *
 * @author Adarsh Avadhoothrao
 *
 */
public class EmailAlert implements IAlerter
{
  private boolean isEmailSent;

  public boolean isEmailSent()
  {
    return this.isEmailSent;
  }

  public void setEmailSent(final boolean isEmailSent)
  {
    this.isEmailSent = isEmailSent;
  }

}
