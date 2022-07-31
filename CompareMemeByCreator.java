import java.util.Comparator;

/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

public class CompareMemeByCreator implements Comparator<Meme> {

	@Override
	public int compare(Meme meme1, Meme meme2) {

		int compareCreator = meme1.getCreator().compareTo(meme2.getCreator());
		if (compareCreator != 0) {
			return compareCreator;
		}

		// if Creators are identical
		int compareRating = (int) (meme2.calculateOverallRating() - meme1.calculateOverallRating());
		if (compareRating != 0) {
			return compareRating;
		}

		// if ratings are identical
		int compareCaption = meme1.getCaption().compareTo(meme2.getCaption());
		if (compareCaption != 0) {
			return compareCaption;
		}
		
		// if captions are identical
		int compareImages = meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage());
		if (compareImages != 0) {
			return compareImages;
		}

		// if background images are identical
		if (meme1.getShared() && !(meme2.getShared())) {
			return -1;
		}
		else if (!(meme1.getShared()) && meme2.getShared()) {
			return 1;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
