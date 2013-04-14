package cucumber.poker;

import java.util.HashMap;
import java.util.Map;

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
		HashMap<Integer, Integer> nums = new HashMap<Integer, Integer>(5);
		for(Card card: hands)
		{
			Integer count = nums.get(card.no);
			if( count == null ) count = 0;
			count++;
			nums.put(card.no, count);
		}

		for(Map.Entry<Integer, Integer> entry: nums.entrySet())
		{
			if( entry.getValue() == 2) return new OnePair(entry.getKey());
		}
		// TODO 役の実装
		return NO_PAIR;
	}

	public static class NoPair extends Pat
	{
		@Override
		public boolean equals(Object obj) {
			return obj instanceof NoPair;
		}

		@Override
		public int hashCode() {
			return 17;
		}
	}

	public static class OnePair extends Pat
	{
		public final int no;

		public OnePair(int no)
		{
			this.no = no;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + no;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if( this == obj) return true;
			if( obj == null) return false;
			if( getClass() !=obj.getClass()) return false;
			OnePair other = (OnePair)obj;
			if( no != other.no) return false;
			return true;
		}
	}

}
