package cucumber.poker;

import cucumber.annotation.ja.ならば;
import cucumber.annotation.ja.もし;
import cucumber.annotation.ja.前提;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class PokerGameStepDefs
{
	PokerGame sut;

	@前提("^手札に([SHDC])(\\d+), ([SHDC])(\\d+), ([SHDC])(\\d+), ([SHDC])(\\d+), ([SHDC])(\\d+)が配られた$")
	public void 手札にカードが配られた(
		char suit1, int no1,
		char suit2, int no2,
		char suit3, int no3,
		char suit4, int no4,
		char suit5, int no5)
	{
		sut = new PokerGame();
		sut.setUp(
			Card.get(suit1, no1),
			Card.get(suit2, no2),
			Card.get(suit3, no3),
			Card.get(suit4, no4),
			Card.get(suit5, no5)
			);
	}

	@もし("^チェンジしない$")
	public void チェンジしない() throws Throwable
	{
		sut.noChange();
	}



	@ならば("^ノーペアであるべき$")
	public void ノーペアであるべき() throws Throwable
	{
		Pat result = sut.pat();
		assertThat(result, is(Pat.NO_PAIR));
	}

	@ならば("^(\\d+)のワンペアであるべき$")
	public void ワンペアであるべき(int no) throws Throwable
	{
		Pat excepted = new Pat.OnePair(no);

		Pat result = sut.pat();
		assertThat(result, is(excepted));
	}

	@ならば("^(\\d+)と(\\d+)のツーペアであるべき$")
	public void ツーペアであるべき(int no1, int no2) throws Throwable
	{
		Pat excepted = new Pat.TwoPair(no1, no2);

		Pat result = sut.pat();
		assertThat(result, is(excepted));
	}

	@ならば("^(\\d+)のスリーカードであるべき$")
	public void スリーカードであるべき(int no) throws Throwable
	{
		Pat excepted = new Pat.ThreeCards(no);

		Pat result = sut.pat();
		assertThat(result, is(excepted));
	}

}
