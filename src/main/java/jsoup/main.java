package jsoup;

import java.io.IOException;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class main {

	public static void main(String[] args) throws IOException {
		String html = "<html><head><title>First parse</title></head>"
					+ "<body><p>Parsed HTML into a doc.</p></body></html>";
		Document testDoc = Jsoup.parse(html);
		
		Document doc = Jsoup.connect("http://catalog.vancl.com").get();
		String title = doc.title();
		System.out.println(title);
		
		//"ul>class:ztCollectImg>li>img";
		
		Elements e = doc.getElementsByClass("ztCollectImg");
//		e = doc.getElementsByClass("track");
		for (Iterator iterator = e.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			String imgHtml = element.child(0).child(0).outerHtml();
			System.out.println(imgHtml);
		}
	}
}
