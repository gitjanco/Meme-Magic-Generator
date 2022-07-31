import java.util.Comparator;

/**
 * Homework 5 Janco Megerssa, jam6nnu
 *
 * Sources: TA and cohort help, lecture slides, and piazza
 */
public class CompareMemeByRating implements Comparator<Meme> {
	
	@Override
	public int compare(Meme meme1, Meme meme2) {
		int compareRatings = (int) (meme2.calculateOverallRating() - meme1.calculateOverallRating());
		if (compareRatings != 0) {
			return compareRatings;
		}

		// if overall ratings are identical
		int compareCaptions = meme1.getCaption().compareTo(meme2.getCaption());
		if (compareCaptions != 0) {
			return compareCaptions;
		}

		// if captions are identical
		int compareImage = meme1.getBackgroundImage().compareTo(meme2.getBackgroundImage());
		if (compareImage != 0) {
			return compareImage;
		}

		// if background images are identical
		int compareCreator = meme1.getCreator().compareTo(meme2.getCreator());
		if (compareCreator != 0) {
			return compareCreator;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}