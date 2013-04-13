package cucumber.poker;

import java.util.Iterator;
import java.util.HashSet;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: naopi
 * Date: 2013/04/13
 * Time: 23:53
 * To change this template use File | Settings | File Templates.
 */
public class Hands implements Iterable<Card>
{
	private static final int SIZE = 5;
	final Set<Card> cards = new HashSet<Card>(SIZE);

	public Hands(Card... cards)
	{
		if( cards.length != SIZE) throw new IllegalArgumentException();
		for(Card card: cards)
		{
			this.cards.add(card);
		}
	}
	@Override
	public Iterator<Card> iterator()
	{
		return cards.iterator();
	}
}
