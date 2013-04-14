package cucumber.poker;

import java.util.ArrayList;
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

		ArrayList<Integer> stack = new ArrayList<Integer>();
		for(Map.Entry<Integer, Integer> entry: nums.entrySet())
		{
			// スリーカードの場合
			if( entry.getValue() == 3) return new ThreeCards(entry.getKey());

			// ペアの場合
			if( entry.getValue() == 2) stack.add(entry.getKey());
		}
		// TODO 役の実装

		switch (stack.size())
		{
			case 1: return new OnePair(stack.get(0));
			case 2: return new TwoPair(stack.get(0), stack.get(1));
		}
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

	public static class TwoPair extends Pat
	{
		public final int no1, no2;

		public TwoPair(int no1, int no2)
		{
			this.no1 = no1;
			this.no2 = no2;
		}

		@Override
		public int hashCode()
		{
			final int prime = 31;
			int result = 1;
			result = prime * result + no1 ;
			result = prime * result + no2 ;
			return result;
		}

		@Override
		public boolean equals(Object obj)
		{
			if( this == obj) return true;
			if( obj == null) return false;
			if( getClass() !=obj.getClass()) return false;

			TwoPair other = (TwoPair)obj;
			if( no1 != other.no1) return false;
			return true;
		}

	}

	public static class ThreeCards extends Pat
	{
		public final int no;

		public ThreeCards(int no)
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
			ThreeCards other = (ThreeCards)obj;
			if( no != other.no) return false;
			return true;
		}
	}
}
