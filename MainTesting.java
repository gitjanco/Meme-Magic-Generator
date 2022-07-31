//import java.util.ArrayList;
//import java.util.Collections;
//
///**
// * Homework 5 Janco Megerssa, jam6nnu
// *
// * Sources: TA and cohort help, lecture slides, and piazza
// */
//
//public class MainTesting {
//
//	public static void main(String[] args) {
//		// TODO Auto-generated method stub
//
//		// Background Images
//		BackgroundImage image1 = new BackgroundImage("fileName1", "title1", "description1");
//		BackgroundImage image2 = new BackgroundImage("fileName2", "title2", "description2");
//		BackgroundImage image3 = new BackgroundImage("fileName3", "title3", "description3");
//		BackgroundImage image4 = new BackgroundImage("fileName1", "title1", "description1");
//
//		// users
//		User user1 = new User("Derrick");
//		User user2 = new User("James");
//		User user3 = new User("Fil");
//		User user4 = new User("Derrick");
//
//		// memes
//		Meme meme1 = new Meme(image1, "caption1", user1);
//		Meme meme2 = new Meme(image2, "caption2", user2);
//		Meme meme3 = new Meme(image3, "caption3", user3);
//		Meme meme4 = new Meme(image1, "caption1", user1);
//
//		// compareTo background image
//		System.out.println("compareTo for Background image");
//		System.out.println(image2.compareTo(image1));
//		System.out.println(image1.compareTo(image3));
//		System.out.println(image1.compareTo(image4));
//		System.out.println("");
//
//
//		// compareTo meme
//		System.out.println("compareTo for Meme");
//		System.out.println(meme2.compareTo(meme1));
//		System.out.println(meme1.compareTo(meme3));
//		System.out.println(meme1.compareTo(meme4));
//		System.out.println("");
//
//
//		// compareTo for user
//		System.out.println("compareTo for User");
//		System.out.println(user2.compareTo(user1));
//		System.out.println(user1.compareTo(user3));
//		System.out.println(user1.compareTo(user4));
//		System.out.println("");
//
//
//		// CompareMemeByRating compare methods
//		System.out.println("CompareMemeByRating compare methods");
//		ArrayList<Meme> memesByRating = new ArrayList<Meme>();
//		// adding memes
//		memesByRating.add(meme1);
//		memesByRating.add(meme2);
//		memesByRating.add(meme3);
//
//		// first test
//		Collections.sort(memesByRating, new CompareMemeByRating());
//		System.out.println(memesByRating);
//
//		// second test
//		memesByRating.add(meme4);
//		Collections.sort(memesByRating, new CompareMemeByRating());
//		System.out.println(memesByRating);
//		System.out.println("");
//
//		// CompareMemeByCreator compare methods
//		System.out.println("CompareMemeByCreator compare methods");
//		ArrayList<Meme> memesByCreator = new ArrayList<Meme>();
//		// add memes
//		memesByCreator.add(meme1);
//		memesByCreator.add(meme2);
//		memesByCreator.add(meme3);
//
//		// first test
//		Collections.sort(memesByCreator, new CompareMemeByCreator());
//		System.out.println(memesByCreator);
//
//		// second test
//		memesByCreator.add(meme4);
//		Collections.sort(memesByCreator, new CompareMemeByCreator());
//		System.out.println(memesByCreator);
//		System.out.println("");
//
//		// Orderable Feeds
//		OrderableFeed feed1 = new OrderableFeed();
//		OrderableFeed feed2 = new OrderableFeed();
//		OrderableFeed feed3 = new OrderableFeed();
//
//		User u1 = new User("user1");
//		User u2 = new User("user2");
//		User u3 = new User("user3");
//		
//		Meme one = u1.createMeme(image1, "Meme one");
//		Meme two = u2.createMeme(image2, "Meme two");
//		Meme three = u3.createMeme(image3, "Meme three");
//
//		
//		u1.shareMeme(one, feed1);
//		u1.shareMeme(two, feed1);
//		u1.shareMeme(three, feed1);
//		u2.shareMeme(one, feed2);
//		u2.shareMeme(two, feed2);
//		u2.shareMeme(three, feed2);
//		u3.shareMeme(one, feed3);
//		u3.shareMeme(two, feed3);
//		u3.shareMeme(three, feed3);
//
//		// Sort by caption
//		System.out.println("'Sort by Caption'");
//		feed1.sortByCaption();
//		System.out.println(feed1);
//		feed2.sortByCaption();
//		System.out.println(feed2);
//		feed3.sortByCaption();
//		System.out.println(feed3);
//		System.out.println("");
//
//		// sort by creator
//		System.out.println("'Sort by Creator'");
//		feed1.sortByCreator();
//		System.out.println(feed1);
//		feed2.sortByCreator();
//		System.out.println(feed2);
//		feed3.sortByCreator();
//		System.out.println(feed3);
//		System.out.println("");
//
//		// sort by rating
//		System.out.println("'Sort by Rating'");
//		feed1.sortByRating();
//		System.out.println(feed1);
//		feed2.sortByRating();
//		System.out.println(feed2);
//		feed3.sortByRating();
//		System.out.println(feed3);
//		System.out.println("");
//
//		// OrderableFeed's getNewMeme
//		System.out.println("'OrderableFeed's inherited getNewMeme'");
//		System.out.println("Check getNewMeme(). Expected Return of the Meme. " + feed1.getNewMeme(u1));
//		System.out.println("Check getNewMeme(). Expected Return of the Meme. " + feed2.getNewMeme(u2));
//		System.out.println("Check getNewMeme(). Expected Return of the Meme. " + feed3.getNewMeme(u3));
//
//	}
//}