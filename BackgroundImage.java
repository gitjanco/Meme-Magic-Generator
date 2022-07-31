
/**
* Homework 5
* Janco Megerssa, jam6nnu
*
* Sources: TA and cohort help, lecture slides, and piazza
*/

public class BackgroundImage implements Comparable<BackgroundImage> {

	private String imageFileName;
	private String title;
	private String description;

	// default
	public BackgroundImage() {
		// TODO Auto-generated constructor stub
		this.imageFileName = "";
		this.title = "";
		this.description = "";
	}

	// overloaded
	public BackgroundImage(String imageFileName, String title, String description) {
		this.getImageFileName();
		this.setImageFileName(imageFileName);
		this.getTitle();
		this.setTitle(title);
		this.getDescription();
		this.setDescription(description);
	}

	public String getImageFileName() {
		return imageFileName;
	}

	public void setImageFileName(String fileName) {
		imageFileName = fileName;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String t) {
		title = t;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String desc) {
		description = desc;
	}

	@Override
	public String toString() {
		return this.title + " <" + this.description + ">";
	}

	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (obj instanceof BackgroundImage) {
			BackgroundImage image = (BackgroundImage) obj;
			return this.getImageFileName().equals(image.getImageFileName()) && this.getTitle().equals(image.getTitle())
					&& this.getDescription().equals(image.getDescription());
		}
		return false;
	}

	@Override
	public int compareTo(BackgroundImage other) {
		int orderImages = this.imageFileName.compareTo(other.imageFileName);
		int orderTitles = this.title.compareTo(other.title);
		int orderDesc = this.description.compareTo(other.description);

		if (orderImages != 0) {
			return orderImages;
		}
		if (orderTitles != 0) {
			return orderTitles;
		}
		else if (orderDesc != 0) {
			return orderDesc;
		}
		return 0;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
