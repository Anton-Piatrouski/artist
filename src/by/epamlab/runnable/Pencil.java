package by.epamlab.runnable;

import by.epamlab.bean.Artist;

public class Pencil implements Runnable {

	private Artist artist;
	
	public Pencil(Artist artist) {
		this.artist = artist;
	}
	
	/**
	 * Artist erases.
	 * If the Artist is busy, waits until another thread invokes method {@link by.epamlab.bean.Artist#finishAction()}.
	 */
	@Override
	public void run() {
		if (artist.isBusy()) {
			synchronized (artist) {
				try {
					artist.wait();
				} catch (InterruptedException e) {
					System.out.println("Drawing: Interrupted");
				}
			}
		}
		artist.draw();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			Thread.currentThread().interrupt();
		}
		artist.finishAction();
	}
}
