import by.epamlab.bean.Artist;
import by.epamlab.runnable.Eraser;
import by.epamlab.runnable.Pencil;

public class Runner {

	public static void main(String[] args) throws InterruptedException {

		Artist artist = new Artist();
		Pencil pencil = new Pencil(artist);
		Eraser eraser = new Eraser(artist);
		
		Thread pencilThread = new Thread(pencil);
		Thread eraserThread = new Thread(eraser);
		
		pencilThread.start();
		Thread.sleep(250);
		eraserThread.start();
		
		Thread.sleep(10000);
		pencilThread.interrupt();
		eraserThread.interrupt();
	}

}
