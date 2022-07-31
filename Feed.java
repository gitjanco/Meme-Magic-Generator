
/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

import java.util.ArrayList;

public class Feed {

	private ArrayList<Meme> memes;

	public Feed() {
		memes = new ArrayList<Meme>();
	}

	public ArrayList<Meme> getMemes() {
		return memes;
	}

	public void setMemes(ArrayList<Meme> meme) {
		memes = meme;
	}

	/**
	 * Gets a new meme from the feed that user has not seen and not created
	 * themselves
	 *
	 * @return A meme that is not in memesViewed and memesCreated, but will return
	 *         null if there is no meme to return.
	 */
	public Meme getNewMeme(User creator) {
		ArrayList<Meme> viewedMemes = creator.getMemesViewed(); // Asked cohort about accessing memesViewed and
																// memesCreated
		ArrayList<Meme> createdMemes = creator.getMemesCreated();
		for (Meme meme : memes) {
			if (viewedMemes.contains(meme) == false && createdMemes.contains(meme) == false) { // check if meme is in viewedMemes an createdMemes. Used .contains() from lecture.
				return meme;
			}
		}
		return null;
	}

	@Override
	public String toString() {
		if (memes.size() == 0) { // Asked cohort how to check for empty
			return "";
		}
		String memesInFeed = "";
		for (Meme meme : memes) {
			memesInFeed += meme.toString() + "\n";
		}
		return memesInFeed;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}