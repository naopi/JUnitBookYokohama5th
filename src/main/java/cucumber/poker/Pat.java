package cucumber.poker;

/**
 * Created with IntelliJ IDEA.
 * User: naopi
 * Date: 2013/04/14
 * Time: 0:13
 * To change this template use File | Settings | File Templates.
 */
public abstract class Pat
{
	public static final Pat NO_PAIR = new NoPair();

	public static Pat make(Hands hands)
	{
		// TODO 役の実装
		return NO_PAIR;
	}

	public static class NoPair extends Pat
	{

	}

	// hashCode,equalsメソッドは省略
}
