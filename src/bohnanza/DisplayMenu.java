package bohnanza;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

//Class Author - Adam P.

/*This class displays the main menu, with 4 buttons:
 * 1-Player Mode, 2-Player Mode, Rules, and Exit.
 */

@SuppressWarnings("serial")
public class DisplayMenu extends JFrame implements ActionListener {

	private final ImageIcon backgroundImage = new ImageIcon("images/menuBackground.png");

	// GUI elements
	JPanel menuPanel = new JPanel();
	JLabel label = new JLabel();
	JLabel background = new JLabel();

	// buttons
	JButton p1Button = new JButton();
	JButton p2Button = new JButton();
	JButton closeButton = new JButton();
	JButton rulesButton = new JButton();

	private Clip menuMusic;

	public DisplayMenu(Clip menuMusic) {

		this.menuMusic = menuMusic;

		// call methods
		buttonSetup();
		frameSetup();

	}

	// set buttons
	private void buttonSetup() {

		// start button set up
		p1Button.addActionListener(this);
		p1Button.setFocusPainted(false);
		p1Button.setBounds(760, 350, 400, 100);
		p1Button.setIcon(new ImageIcon(new ImageIcon("images/1player.png").getImage().getScaledInstance(400, 100, 0)));
		add(p1Button);

		// start button set up
		p2Button.addActionListener(this);
		p2Button.setFocusPainted(false);
		p2Button.setBounds(760, 500, 400, 100);
		p2Button.setIcon(new ImageIcon(new ImageIcon("images/2player.png").getImage().getScaledInstance(400, 100, 0)));
		add(p2Button);

		// instruction button set up
		rulesButton.addActionListener(this);
		rulesButton.setFocusPainted(false);
		rulesButton.setBounds(760, 650, 400, 100);
		rulesButton.setIcon(new ImageIcon(new ImageIcon("images/rules.png").getImage().getScaledInstance(400, 100, 0)));
		add(rulesButton);

		// exit button set up
		closeButton.addActionListener(this);
		closeButton.setFocusPainted(false);
		closeButton.setBounds(760, 800, 400, 100);
		closeButton
				.setIcon(new ImageIcon(new ImageIcon("images/exitGame.png").getImage().getScaledInstance(400, 100, 0)));
		add(closeButton);

		p1Button.setContentAreaFilled(false);
		p2Button.setContentAreaFilled(false);
		closeButton.setContentAreaFilled(false);
		rulesButton.setContentAreaFilled(false);

	}

	// set up and display
	private void frameSetup() {

		// frame size and title
		setSize(1920, 1080);
		setLayout(null);
		setResizable(true);
		getContentPane().setBackground(Color.black);

		// panel display
		add(menuPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		background.setBounds(0, 0, 1920, 1080);
		add(label);

		label.setIcon(backgroundImage);
		label.setBounds(0, 0, 1920, 1080);
		setVisible(true);

		label.setIcon(
				new ImageIcon(new ImageIcon("images/menuBackground.png").getImage().getScaledInstance(1920, 1080, 0)));

	}

	// actions
	@Override
	public void actionPerformed(ActionEvent event) {

		// if the 'start 1-player' button is pressed,
		// a sound effect will play and a 1-player game will start
		if (event.getSource() == p1Button) {
			buttonSound();
			setVisible(false);
		
			new Game(true);

		}

		// if the 'start 2-player' button is pressed,
		// a sound effect will play and a 2-player game will start
		if (event.getSource() == p2Button) {
			buttonSound();
			setVisible(false);
			new Game(false);

		}

		// plays a sound effect and opens the 'rules' screen
		if (event.getSource() == rulesButton) {
			buttonSound();
			setVisible(false);
			new DisplayRules();
		}

		// plays a sound effect and closed the program
		if (event.getSource() == closeButton) {
			buttonSound();
			System.exit(EXIT_ON_CLOSE);
		}
	}

	// this method controls the button sound effect
	private void buttonSound() {
		File buttonClick1 = new File("sounds/buttonClick1.wav");
		try {

			Clip bClick = AudioSystem.getClip();

			bClick.open(AudioSystem.getAudioInputStream(buttonClick1));
			bClick.start();

		} catch (Exception e)

		{

		}

	}

}