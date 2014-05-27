import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

public class PhysicsFrame extends JFrame{
	public static void main(String[] args)
	{
		System.out.println("Spaceship Time Dilation Applet");
		new PhysicsFrame();
	}
	public PhysicsFrame()
	{
		setTitle("Special Relativity Applet: Time Dilation");
		try
		{
			//System.out.println("yes");
			setIconImage(ImageIO.read(PhysicsFrame.class.getResource("Spaceship.png")));
		}
		catch(Exception e)
		{
			System.out.println("Nur");
		}
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(1000,1000);
		add(new SpaceWorld());
		setVisible(true);
		
	}
}