
import java.util.Collections;

/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

public class OrderableFeed extends Feed { // re-order the instance's list of memes
		
		// re-orders the feed by caption, using Meme's natural ordering
		public void sortByCaption() {
			Collections.sort(this.getMemes());
		}
		
		// re-orders the feed by rating, using the CompareMemeByRating comparator
		public void sortByRating() {
			Collections.sort(this.getMemes(), new CompareMemeByRating());
		}
		
		// re-orders the feed by creator, using the CompareMemeByCreator comparator
		public void sortByCreator() {
			Collections.sort(this.getMemes(), new CompareMemeByCreator());
		}
		


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}