import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import com.google.gson.Gson;

public class firstLetterString {
	private String json;
	private Gson gson;
	private setListArray[] array;
	private String setListHtml;
	
	public firstLetterString() {
		
	}

	public String text(String url) throws Exception {

		json = readUrl(url);
		gson = new Gson();
		array = gson.fromJson(json, setListArray[].class);
		setListHtml = array[0].getsetListData();
//		System.out.println(setListHtml);

		Document doc = Jsoup.parse(setListHtml);
		Elements links = doc.getElementsByTag("a");
		int size = links.size();
		int index = 0;
		String[] songArray = new String[size];

		StringBuilder sb = new StringBuilder();

		for (Element link : links) {
			songArray[index] = link.text();
//			 System.out.println(songArray[index].toString());
			index++;
		}

		for (int i = 0; i < songArray.length; i++) {
			sb.append(songArray[i].charAt(0));
		}
		
		return sb.toString();

	}
	
	public static String readUrl(String urlString) throws Exception {
		BufferedReader reader = null;
		int read;
		
		try {
			URL url = new URL(urlString);
			reader = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuffer buffer = new StringBuffer();
			char[] chars = new char[1024];
			while ((read = reader.read(chars)) != -1) {
				buffer.append(chars, 0, read);
			}
			return buffer.toString();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

	}

}
