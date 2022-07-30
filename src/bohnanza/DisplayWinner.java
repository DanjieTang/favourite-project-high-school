package bohnanza;

import java.awt.Color;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class DisplayWinner extends JFrame implements ActionListener {

	// GUI elements
	JPanel main = new JPanel();
	JButton quit = new JButton();

	// main class
	public DisplayWinner(int winner) {

		frameSetup(winner);
		mainSetup();

	}

	// Sets up the panel for end screen options
	private void mainSetup() {

		main.setBounds(0, 0, 1920, 1080);
		main.setLayout(null);
		main.setOpaque(false);

		// quit button set up
		quit.addActionListener(this);
		quit.setFocusPainted(false);
		quit.setBounds(875, 840, 170, 100);
		quit.setIcon(new ImageIcon(new ImageIcon("images/exit.png").getImage().getScaledInstance(170, 100, 0)));
		main.add(quit);

	}

	// frame setup
	private void frameSetup(int winner) {

		// frame size and title
		setSize(1920, 1080);
		setLayout(null);
		setResizable(true);
		setContentPane((new JLabel(new ImageIcon("images/winP" + winner + ".png"))));

		// panel display
		add(main);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

	}

	// Button action class
	public void actionPerformed(ActionEvent e) {

		// Plays button click sound
		buttonSound();

		// Exits program on click
		if (e.getSource() == quit)
			System.exit(1);

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