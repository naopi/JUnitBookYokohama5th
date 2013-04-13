package cucumber.poker;


/**
 * Created with IntelliJ IDEA.
 * User: naopi
 * Date: 2013/04/13
 * Time: 23:50
 * To change this template use File | Settings | File Templates.
 */
public class PokerGame
{
	private enum Status
	{ INIT, READY, CHANGE;}

	private Status status = Status.INIT;
	private Hands hands = null;

	public void setUp(Card... cards)
	{
		if( status != Status.INIT) throw new IllegalStateException();
		hands = new Hands(cards);
		this.status = Status.READY;
	}

	public void noChange()
	{
		if( status != Status.READY) throw new IllegalStateException();
		this.status = Status.CHANGE;
	}

	public Pat pat()
	{
		if( status != Status.CHANGE) throw new IllegalStateException();
		return Pat.make(hands);
	}
}
