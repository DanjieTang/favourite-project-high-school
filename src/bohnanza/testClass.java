package bohnanza;

import java.io.File;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;

//Authors - Adam, Danjie, Jesse, Ganan


//this is the main test class.

public class testClass {
	public static void main(String[] args) {

		File mm = new File("sounds/menuMusic.wav");
		try {

			Clip menuMusic = AudioSystem.getClip();

			menuMusic.open(AudioSystem.getAudioInputStream(mm));
			menuMusic.loop(10*10*10);

			new DisplayMenu(menuMusic);

		} catch (Exception e)

		{

		}
		{

		}

	}
}
