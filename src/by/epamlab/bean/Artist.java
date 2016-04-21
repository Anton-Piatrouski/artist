package by.epamlab.bean;

public class Artist {

	/**
	 * Artist status
	 */
	private boolean isBusy;
	
	public Artist() {
		isBusy = false;
	}
	
	public boolean isBusy() {
		return isBusy;
	}
	
	/**
	 * Changes the Artist status on busy.
	 * Prints "Drawing..." in console.
	 */
	public synchronized void draw() {
		isBusy = true;
		System.out.println("Drawing...");
	}
	
	/**
	 * Changes the Artist status on busy.
	 * Prints "Erasing..." in console.
	 */
	public synchronized void erase() {
		isBusy = true;
		System.out.println("Erasing...");
	}
	
	/**
	 * Changes the Artist status on free.
	 * Wakes up a single thread that is waiting on this object's monitor.
	 */
	public synchronized void finishAction() {
		isBusy = false;
		notify();
	}
}
