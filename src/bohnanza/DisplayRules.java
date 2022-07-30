package bohnanza;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;

//Class Author - Adam P.

//This class displays the rules for 'Bohnanza!'


@SuppressWarnings("serial")
public class DisplayRules extends JFrame implements ActionListener {

	// GUI components
	JPanel menuPanel = new JPanel();
	JPanel background = new JPanel();
	JLabel rulesImage = new JLabel();
	JLabel examplePic = new JLabel();

	// buttons
	JButton backButton = new JButton();

	private Clip menuMusic;

	public DisplayRules() {

		// call methods to set up the frame.
		buttonSetup();
		frameSetup();

	}

	// set main buttons and title
	private void buttonSetup() {

		// exit button set up
		backButton.addActionListener(this);
		backButton.setFocusPainted(false);
		backButton.setBounds(760, 850, 400, 100);
		backButton.setIcon(new ImageIcon(new ImageIcon("images/back.png").getImage().getScaledInstance(400, 100, 0)));
		add(backButton);
		backButton.setContentAreaFilled(false);

	}

	// sets up the frame
	private void frameSetup() {

		// frame size
		setSize(1920, 1080);
		setLayout(null);
		setResizable(true);
		getContentPane().setBackground(Color.black);

		// panel display
		add(menuPanel);
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		rulesImage.setBounds(0, 0, 1920, 1080);
		rulesImage
				.setIcon(new ImageIcon(new ImageIcon("images/rulesPage.png").getImage().getScaledInstance(1920, 1080, 0)));
		add(rulesImage);

		background.setBounds(900, 300, 900, 400);

	}

	// actions
	@Override
	public void actionPerformed(ActionEvent event) {

		// returns to main menu and plays a sound effect
		if (event.getSource() == backButton) {
			buttonSound();
			setVisible(false);
			new DisplayMenu(menuMusic);
		}

	}

	//this method controls the button sound effect
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