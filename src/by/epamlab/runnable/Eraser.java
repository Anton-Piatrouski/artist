package by.epamlab.runnable;

import by.epamlab.bean.Artist;

public class Eraser implements Runnable {

	private Artist artist;
	
	public Eraser(Artist artist) {
		this.artist = artist;
	}
	
	/**
	 * Artist draws.
	 * If the Artist is busy, waits until another thread invokes method {@link by.epamlab.bean.Artist#finishAction()}.
	 */
	@Override
	public void run() {
		if (artist.isBusy()) {
			synchronized (artist) {
				try {
					artist.wait();
				} catch (InterruptedException e) {
					System.out.println("Erasing: Interrupted");
				}
			}
		}
		artist.erase();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		artist.finishAction();
	}
}
