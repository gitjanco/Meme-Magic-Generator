
/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

public class Rating {

	private int score;
	private User user;

	// default
	public Rating() {
		// TODO Auto-generated constructor stub
		this.user = new User();
		this.score = 0;

	}

	// overloaded
	public Rating(User user, int score) {
		this.getScore();
		this.setScore(score);
		if (this.setScore(score) == false) {
			this.setScore(0);
		}
		this.getUser();
		this.setUser(user);

	}

	public int getScore() {
		return score;
	}

	public boolean setScore(int score) {
		if ((score == 1) || (score == -1) || (score == 0)) {
			this.score = score;
			return true;
		} else {
			return false;
		}
	}

	public User getUser() {
		return user;
	}

	public void setUser(User u) {
		user = u;
	}

	@Override
	public String toString() {
		String rate;
		if (this.getScore() == 1) {
			rate = user.getUserName() + " rated as an upvote";
		} else if (this.getScore() == -1) {
			rate = user.getUserName() + " rated as a downvote";
		} else {
			rate = user.getUserName() + " rated as a pass";
		}
		return rate;
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		// checks if obj is an instance of Rating
		if (obj instanceof Rating) {
			Rating rate = (Rating) obj;
			return this.getScore() == rate.getScore() && this.getUser().equals(rate.getUser());
		}
		return false;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
