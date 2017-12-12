package hello;

public class CuteThing {
	    private String imageLink;
	    private String title;
	    private String author;
	    
	    public CuteThing(String author, String title, String imageLink) {
	        this.author = author;
	        this.title = title;
	        this.imageLink = imageLink;
	    }
	    
		public String getImageLink() {
			return imageLink;
		}
		public void setImageLink(String imageLink) {
			this.imageLink = imageLink;
		}
		public String getTitle() {
			return title;
		}
		public void setTitle(String title) {
			this.title = title;
		}
		public String getAuthor() {
			return author;
		}
		public void setAuthor(String author) {
			this.author = author;
		}

}
