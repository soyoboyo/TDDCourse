package org.bmc.tdd;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;


class BowlingGameTest {

	BowlingGame theGame = new BowlingGame();

	@Test
	public void shouldReturnMaxScoreFor12Strikes() {
		assertEquals(300, theGame.getScore(Arrays.asList("X", "X", "X", "X", "X", "X", "X", "X", "X", "XXX")));
	}

	@Test
	public void shouldReturn90PointsForOnly9s() {
		assertEquals(90, theGame.getScore(Arrays.asList("9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-", "9-")));
	}

	@Test
	public void shouldReturn150PointsForOnly5s() {
		assertEquals(150, theGame.getScore(Arrays.asList("5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/", "5/5")));
	}

	@Test
	public void shouldReturn202() {
		assertEquals(202, theGame.getScore(Arrays.asList("X", "8/", "9/", "8-", "X", "X", "9/", "9/", "X", "X9/")));
	}

	@Test
	public void shouldReturn164() {
		assertEquals(164, theGame.getScore(Arrays.asList("7/", "X", "X", "81", "9/", "81", "X", "8/", "8/", "61")));
	}

	@Test
	public void shouldReturn276() {
		assertEquals(276, theGame.getScore(Arrays.asList("X", "X", "X", "X", "X", "X", "X", "X", "8/", "XXX")));
	}
}


