package tests;

import static org.junit.Assert.*;

import org.junit.Test;

import mvc.*;


public class PetTest {

	//Change variable names?
	Pet Tigger = new PetTiger("PuddyCat");
	Food Piggy = new FoodBacon();
	Toy Ballo = new ToyBall();
	Toy Clubbo = new ToyClub();
	
	@Test
	public void testFeed() {
		Tigger.feed(Piggy);
		assertEquals(Tigger.getStats()[0], 18);
	}
	
	@Test
	public void testSleep() {
		int currEnergy = Tigger.getStats()[1];
		Tigger.sleep();
		assertEquals(currEnergy + 5, Tigger.getStats()[1]);
	}
	
	@Test
	public void testPlay() {
		Toy testToy = Ballo;
		//Toy testToy = Clubbo;
		int tiggerMood = Tigger.getStats()[5];
		Tigger.play(testToy);
		if(testToy.getName() == Tigger.getFavToy()){
			assertEquals(tiggerMood + 5, Tigger.getStats()[5]);
		}
		else{
			assertEquals(tiggerMood + 2, Tigger.getStats()[5]);
		}
		
	}

}