import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;


public class SpaceWorld extends JPanel implements MouseListener, Runnable {
	private boolean debug;
	private boolean running;
	private Thread stageThread;
	private int FPS, secondCounter;
	private BufferedImage spaceship;
	public SpaceWorld()
	{
		secondCounter = 0;
		FPS = 0;
		//ImageLibrary.init();
		//AudioLibrary.init();
		debug = false;
		running = true;
		stageThread = new Thread(this);
		stageThread.start();
		addMouseListener(this);
		setFocusable(true);
		try {
			spaceship = ImageIO.read(SpaceWorld.class.getResource("Spaceship.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public boolean isInDebugMode()
	{
		return debug;
	}
	/*public void playAudio(GameAudio a)
	{
		GameAudio audio = AudioLibrary.getCopyOfAudio(a);
		audio.play();
		audioList.add(audio);
	}
	public void loopAudio(GameAudio a)
	{
		GameAudio audio = AudioLibrary.getCopyOfAudio(a);
		audio.loop();
		audioList.add(audio);
	}
	public void stopAllAudio()
	{
		for(int i = 0;i<audioList.size();i++)
		audioList.get(i).stop();
		audioList.clear();
	}*/
	public void run()
	{
		while(running)
		{
			secondCounter++;
			if(secondCounter == 60)
			{
				secondCounter = 0;
				System.out.println("FPS: " +FPS);
				FPS = 0;
			}		
			repaint();
			try
			{
				stageThread.sleep(17);
			}
			catch(InterruptedException e)
			{
				System.err.println(e);
			}
		}
	}
	public void mousePressed(MouseEvent e)
	{

	}
	public void mouseClicked(MouseEvent e)
	{
		if(e.getButton() == 3)
		{
			if(!debug)
			debug = true;
			else
			debug = false;
		}
	}
	public void mouseReleased(MouseEvent e)
	{

	}
	public void mouseEntered(MouseEvent e)
	{

	}
	public void mouseExited(MouseEvent e)
	{

	}
	public void paintComponent(Graphics g)
	{
		FPS++;
		super.paintComponent(g);
		setBackground(Color.white);
		g.drawImage(spaceship,0,0,spaceship.getWidth(),spaceship.getHeight(), this);
		/*for(int i = 0; i < ListOfObjects.size(); i++)
		{
			if(ListOfObjects.get(i) instanceof GraphicsObject);
				((GraphicsObject)ListOfObjects.get(i)).draw(g);
		}*/
	}
	public String toString()
	{
		return "Main Stage";
	}
}
