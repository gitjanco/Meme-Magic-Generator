
/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

import java.util.ArrayList;
import java.util.TreeSet;



public class User implements Comparable<User> {

	private String userName;
	private ArrayList<Meme> memesCreated;
	private TreeSet<Meme> memesViewed;

	// constructor that accepts a String for username.
	public User(String userName) {
		this.userName = userName;
		this.memesCreated = new ArrayList<Meme>();
		this.memesViewed = new TreeSet<Meme>();
	}

	// constructor
	public User() {
		this.userName = "";
		this.memesCreated = new ArrayList<>();
		this.memesViewed = new TreeSet<>();
	}
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String name) {
		userName = name;
	}

	public ArrayList<Meme> getMemesCreated() {
		return memesCreated;
	}

	public void setMemesCreated(ArrayList<Meme> mecreate) {
		memesCreated = mecreate;
	}    

	public ArrayList<Meme> getMemesViewed() {
		return new ArrayList<Meme>(memesViewed);
	}

	public void setMemesViewed(ArrayList<Meme> memesvi) {
		memesViewed = new TreeSet<Meme>(memesvi); 
	}

	public void rateMeme(Meme meme, int rating) {
		Rating rate = new Rating(this, rating); // TA and cohort helped with knowing that I would need to create a new
												// rating instance.
		memesViewed.add(meme);
		rate.setScore(rating);
		meme.addRating(rate);
	}

	/**
	 * Creates a new meme object.
	 *
	 * @return Adds the new meme object to the memesCreated ArrayList and returns
	 *         the new meme.
	 */
	public Meme createMeme(BackgroundImage backgroundimage, String caption) {
		Meme newMeme = new Meme(backgroundimage, caption, this);
		memesCreated.add(newMeme);
		return newMeme;
	}

	/**
	 * Deletes a meme object
	 *
	 * @return Deletes the meme if it is found in the memesCreated ArrayList. If the
	 *         meme was shared it will return false(not delete) if the meme isn't
	 *         shared it will proceed to delete the meme from the memesCreated
	 *         ArrayList and return true if successful.
	 */
	public boolean deleteMeme(Meme meme) {
		if (meme.getShared() == true) {
			return false;
		} else {
			this.memesCreated.remove(meme);
			return true;
		}

	}

	/**
	 * Marks a meme as being shared.
	 *
	 */
	public void shareMeme(Meme meme, Feed feed) {
		meme.setShared(true);
		feed.getMemes().add(meme);
	}

	/**
	 * Records a meme as being viewed and giving it a rating score
	 *
	 * @return Will return true if meme is recorded as being viewed and given a
	 *         score. If there are no memes to be viewed, it will return false.
	 */
	public boolean rateNextMemeFromFeed(Feed feed, int rating) {
		ArrayList<Meme> me = feed.getMemes();

		if (me == null) {
			return false;
		}

		for (Meme meme : me) {
			if (memesViewed.contains(meme) == false && meme.getCreator() != this) {
				Rating rate = new Rating(this, rating);
				this.rateMeme(meme, rating);
				meme.addRating(rate);
				return true;
			}
		}
		return false;
	}

	/**
	 * Calculates the average rating of all of the ratings from
	 * calculateOverallRating())
	 *
	 * @return The calculated average of all the ratings, if the user has not
	 *         created any memes or rated any memes it will return 0.0.
	 */
	public double calculateReputation() {
		double average = 0.0;
		int size = memesCreated.size();
		if (memesCreated != null) {
			for (Meme meme : memesCreated) {
				average += meme.calculateOverallRating() / size;
			}
		} else {
			average = 0.0;
		}
		return average;
	}

	/**
	 * toString that returns how many memes the user has rated and the average of
	 * the user's ratings.
	 *
	 * @return "username has rated (number of memes viewed) memes, (reputation)".
	 */

	@Override
	public String toString() {
		int viewedMemes = this.memesViewed.size();
		String average = String.format("%.1f", calculateReputation());
		if (average == null) {
			average = "0.0";
		}
		return this.userName + " has rated (" + viewedMemes + ") memes, (" + average + ")";
	}

	public boolean equals(Object obj) {
		if (obj == this) {
			return true;
		}
		if (obj instanceof User) {
			User user = (User) obj;
			return this.getUserName().equals(user.getUserName());
		}
		return false;
	}
	
	@Override
	public int compareTo(User other) {
		int orderUserName = this.userName.compareTo(other.userName);
		int orderCreatedMemes = other.memesCreated.size() - (this.memesCreated.size());

		if (orderUserName != 0) {
			return orderUserName;
		}
		if (orderCreatedMemes != 0) {
			return orderCreatedMemes;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
