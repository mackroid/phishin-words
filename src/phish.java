
public class phish {

	public static void main(String[] args) throws Exception {
		firstLetterString fls = new firstLetterString();
		String firtLetterSongs = fls.text("https://api.phish.net/api.js?api=2.0&method=pnet.shows.setlists.random&format=json");
		
		System.out.println(firtLetterSongs);
		
		
		
		
		

	}

}