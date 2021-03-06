package mvc;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingConstants;

import net.miginfocom.swing.MigLayout;

/**
 * This class handles the GUI for the section of the game where the number of days and players are chosen for 
 * the game, as well as the help section.
 * 
 * 
 *
 */
public class GuiStartGame{
	
	private TamaModel m_model;
	
	private Dimension buttonSize = new Dimension(225, 50);
	
	private Font allFont = new Font(null, Font.BOLD, 20);
	
	private JLabel helpTextLabel = new JLabel();
	private JLabel menuTextLabel = new JLabel();
	private JLabel numPlayersLabel = new JLabel("How many players?");
	private JLabel numDaysLabel = new JLabel("How many days would you like to play for?");

	
	private JButton start = new JButton("Start");
	private JButton help = new JButton("Help");
	private JButton back = new JButton("Back");
	private JButton next = new JButton("Next");

	
	private JRadioButton players1 = new JRadioButton("1 player  ");
	private JRadioButton players2 = new JRadioButton("2 players ");
	private JRadioButton players3 = new JRadioButton("3 players  ");
	private JRadioButton days1 = new JRadioButton("3");
	private JRadioButton days2 = new JRadioButton("5");
	private JRadioButton days3 = new JRadioButton("7");
	private JRadioButton days4 = new JRadioButton("10");
	private JRadioButton days5 = new JRadioButton("15");

	private ButtonGroup numPlayersGroup = new ButtonGroup();
	private ButtonGroup numDaysGroup = new ButtonGroup();

	public GuiStartGame(TamaModel model)
	{
		m_model = model;
	}
	
	/**
	 * Builds a <code> JPanel </code> the first screen of the game
	 * displays some welcome text and button options to start the game or view the help section.
	 * 
	 * @return a <code> JPanel</code> with all the necessary main menu components.
	 */
	protected JPanel buildMainMenuPanel()
	{
		MigLayout menuLayout = new MigLayout(
				"fill, insets 20", 
				"[][]",
				"[][]");
		
		JPanel menuCard = new JPanel();
		menuCard.setLayout(menuLayout);
		//centerText(menuTextPane);
		menuTextLabel.setText(m_model.getMainMenuText());
		menuTextLabel.setFont(allFont);
		menuTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		//
		//info1.setPreferredSize(new Dimension(450, 300));
		menuCard.add(menuTextLabel, "span,grow,center,wrap, push");
		start.setPreferredSize(buttonSize);
		menuCard.add(start, "grow, hmax 50,center, span, split 2");
		help.setPreferredSize(buttonSize);
		menuCard.add(help, "grow, hmax 50,center");
		
		return menuCard;
	}
	
	/**
	 * Builds a <code>JPanel</code> that displays the help section of the game with a back button 
	 * to return to main menu.
	 * @return Help section <code>JPanel</code>.
	 */
	protected JPanel buildHelpPanel()
	{
		MigLayout helpLayout = new MigLayout(
				"fill, insets 40", 
				"[]",
				"[]");
		
		JPanel helpCard = new JPanel();
		helpCard.setLayout(helpLayout);
		helpTextLabel.setText(m_model.getHelpText());
		helpTextLabel.setFont(new Font(null, Font.BOLD, 16));
		helpTextLabel.setHorizontalAlignment(SwingConstants.CENTER);
		
		helpCard.add(helpTextLabel, "span,grow,center,wrap, push");
		back.setPreferredSize(buttonSize);
		helpCard.add(back, "grow");
		
		return helpCard;
	}
	
	/**
	 * Builds the <code>JPanel</code> where number of players and number of days for the game
	 * are chosen using <code>Radio Buttons</code>. Also contains a "Next" <code>Button</code> to
	 * advance to the player creation screen.
	 * 
	 * @return <code>JPanel</code> containing the Set Up Game screen.
	 */
	protected JPanel buildSetupPanel()
	{
		//Make the Setup card
		MigLayout setupLayout = new MigLayout(
				"fill, insets 20, wrap 2", 
				"[][]",
				"[][][]");
		
		JPanel setupCard = new JPanel();
		setupCard.setLayout(setupLayout);
		numPlayersLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numPlayersLabel.setFont(allFont);
		//numPlayersLabel.setText("How many players?");
		setupCard.add(numPlayersLabel, "grow");
		
		numPlayersGroup.add(players1);
		numPlayersGroup.add(players2);
		numPlayersGroup.add(players3);
		players1.setActionCommand("1");
		players1.setFont(allFont);
		players2.setActionCommand("2");
		players2.setFont(allFont);
		players3.setActionCommand("3");
		players3.setFont(allFont);
		
		players1.setSelected(true);
		setupCard.add(players1, "split 3");
		setupCard.add(players2);
		setupCard.add(players3);
		
		numDaysGroup.add(days1);
		numDaysGroup.add(days2);
		numDaysGroup.add(days3);
		numDaysGroup.add(days4);
		numDaysGroup.add(days5);
		days1.setActionCommand("1");
		days1.setFont(allFont);
		days2.setActionCommand("5");
		days2.setFont(allFont);
		days3.setActionCommand("7");
		days3.setFont(allFont);
		days4.setActionCommand("10");
		days4.setFont(allFont);
		days5.setActionCommand("15");
		days5.setFont(allFont);

		days1.setSelected(true);
		numDaysLabel.setHorizontalAlignment(SwingConstants.CENTER);
		numDaysLabel.setFont(allFont);
		setupCard.add(numDaysLabel, "grow");
		setupCard.add(days1, "split 5, gapright 30");
		setupCard.add(days2, "gapright 30");
		setupCard.add(days3, "gapright 30");
		setupCard.add(days4, "gapright 30");
		setupCard.add(days5);
		
		next.setPreferredSize(buttonSize);
		setupCard.add(next, "skip, grow, hmax 50");
		
		return setupCard;
	}
	
	protected void addButtonListener(ActionListener bal)
	{
		start.addActionListener(bal);
		help.addActionListener(bal);
		back.addActionListener(bal);
		next.addActionListener(bal);
	}

	protected int getNumPlayers()
	{
		return Integer.parseInt(numPlayersGroup.getSelection().getActionCommand());
	}
	
	protected int getNumDays()
	{
		return Integer.parseInt(numDaysGroup.getSelection().getActionCommand());
	}
}
