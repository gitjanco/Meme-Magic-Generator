/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

public class Meme implements Comparable <Meme>{

	private User creator;
	private BackgroundImage backgroundImage;
	private Rating[] ratings;
	private String caption;
	private String captionVerticalAlign;
	private boolean shared;

	// default
	public Meme() {
		// TODO Auto-generated constructor stub
		this.creator = new User();
		this.backgroundImage = new BackgroundImage();
		this.ratings = new Rating[10];
		this.caption = new String();
		this.captionVerticalAlign = "bottom";
		this.shared = false;

	}

	// overloaded
	public Meme(BackgroundImage backgroundImage, String caption, User creator) {
		ratings = new Rating[10];
		String captionVerticalAlign = "bottom";
		this.getCreator();
		this.setCreator(creator);
		this.getBackgroundImage();
		this.setBackgroundImage(backgroundImage);
		this.getRatings();
		this.setRatings(ratings);
		this.getCaption();
		this.setCaption(caption);
		this.getCaptionVerticalAlign();
		this.setCaptionVerticalAlign(captionVerticalAlign);
		this.getShared();
		this.setShared(shared);
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User c) {
		creator = c;
	}

	public BackgroundImage getBackgroundImage() {
		return backgroundImage;
	}

	public void setBackgroundImage(BackgroundImage image) {
		backgroundImage = image;
	}

	public Rating[] getRatings() {
		return ratings;
	}

	public void setRatings(Rating[] r) {
		ratings = r;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String c) {
		caption = c;
	}

	public String getCaptionVerticalAlign() {
		return captionVerticalAlign;
	}

	public boolean setCaptionVerticalAlign(String captionVerticalAlign) {
		if (captionVerticalAlign.equals("top") || captionVerticalAlign.equals("middle")
				|| captionVerticalAlign.equals("bottom")) { // was using && at first and it was not working but my
															// cohort advised me to use the logical operator || instead
			this.captionVerticalAlign = captionVerticalAlign;
			return true;
		}
		return false;

	}

	public boolean getShared() {
		return shared;
	}

	public void setShared(boolean s) {
		shared = s;
	}

	// checks if array is full, shifts ratings up one position and insert new one at
	// the last position of the array.
	// returns true if rating object is successfully added to the Meme's array of
	// ratings.
	public boolean addRating(Rating rating) {
		for (int i = 0; i < ratings.length; i++) {

			if (ratings[i] == null) {
				ratings[i] = rating;
				return true;
			}
		}

		for (int i = 0; i < ratings.length - 1; i++) {
			ratings[i] = ratings[i + 1];
		}
		ratings[ratings.length - 1] = rating;
		return true;
	}

	public double calculateOverallRating() {
		double ovr = 0.0;
		for (int i = 0; i < ratings.length && ratings[i] != null; i++) {
			ovr += ratings[i].getScore();
		}
		return ovr;
	}

	// talked with cohort to figure how to implement private helper functions to
	// find upvotes and downvotes
	private int upVotes(Rating[] ratings) {
		int upCount = 0;
		for (int i = 0; i < ratings.length; i++) {
			if ((ratings[i] != null) && (ratings[i].getScore() > 0)) {
				upCount++;
			}
		}
		return upCount;
	}

	private int downVotes(Rating[] ratings) {
		int downCount = 0;
		for (int i = 0; i < ratings.length; i++) {
			if ((ratings[i] != null) && (ratings[i].getScore() < 0)) {
				downCount++;
			}
		}
		return downCount;
	}

	@Override
	public String toString() {
		return backgroundImage + " " + "'" + caption + "'" + " " + calculateOverallRating() + " " + "[+1: "
				+ this.upVotes(this.ratings) + ", -1: " + this.downVotes(this.ratings) + "] - created by "
				+ creator.getUserName();

	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		// checks if obj is an instance of Meme
		if (obj instanceof Meme) {
			Meme meme = (Meme) obj;
			return this.getCreator().equals(meme.getCreator()) && this.getCaption().equals(meme.getCaption())
					&& this.getBackgroundImage().equals(meme.getBackgroundImage());
		}
		return false;
	}
	
	@Override
	public int compareTo (Meme other) {
		int orderCaption = this.caption.compareTo(other.caption);
		int orderBImage = this.backgroundImage.compareTo(other.backgroundImage);
		int orderOvrRating = (int) (other.calculateOverallRating() - (this.calculateOverallRating())); //descending
		
		if (orderCaption != 0) {
			return orderCaption;
		}
		if (orderBImage != 0) {
			return orderBImage;
		}
		if (orderOvrRating != 0) {
			return orderOvrRating;
		}
		if (this.shared && !(other.shared)) {
			return -1;
		}
		if (!(this.shared) && other.shared) {
			return 1;
		}
		return 0;
		}


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}