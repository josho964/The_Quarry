package mvc;

import javax.swing.ImageIcon;

public class PetEagle extends Pet {
	
	private static String favToy = "Freedom";
	private static int maxHunger = 8;
	private static int maxEnergy = 15;
	private static int weight = 100;
	private static int[] stats = {maxHunger, maxEnergy, weight};
	private static ImageIcon icon = new ImageIcon("resources/eagle_small.png");

	public PetEagle(String name){
		
		super("Eagle", favToy, stats, icon);
		super.setName(name);
	}
	
	public PetEagle()
	{
		super("Eagle", favToy, stats, icon);
	}
}