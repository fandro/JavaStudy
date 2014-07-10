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
		for (Iterator iterator = e.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			Element ec = element.child(0).child(0);
			Element ec2 = element.child(0);
			
			System.out.println("********************************************************************************************");
			System.out.println("ec.getElementsByTag(\"a\").attr(\"href\")="+ec.getElementsByTag("a").attr("href"));
			System.out.println("********************************************************************************************");
			System.out.println("ec.getElementsByTag(\"img\").attr(\"original\")="+ec.getElementsByTag("img").attr("original"));
			System.out.println("********************************************************************************************");
			System.out.println("ec.ec.nextElementSibling().text()="+ec.nextElementSibling().text());
			System.out.println("********************************************************************************************");
			System.out.println("ec.ec.nextElementSibling().ownText()="+ec.nextElementSibling().ownText());
			
			
			System.out.println("ec2.nextSibling()="+ec2.nextSibling());
			System.out.println("ec.nextElementSibling()="+ec.nextElementSibling());
			
			System.out.println("********************************************************************************************");
			System.out.println("ec.data()="+ec.data());
			System.out.println("********************************************************************************************");
			System.out.println("ec.html()="+ec.html());
			System.out.println("********************************************************************************************");
			System.out.println("ec.nodeName()="+ec.nodeName());
			System.out.println("********************************************************************************************");
			System.out.println("ec.outerHtml()="+ec.outerHtml());
			System.out.println("********************************************************************************************");
			System.out.println("ec.ownText()="+ec.ownText());
			System.out.println("********************************************************************************************");
			System.out.println("ec.siblingIndex()="+ec.siblingIndex());
			System.out.println("********************************************************************************************");
			System.out.println("ec.tagName()="+ec.tagName());
			System.out.println("********************************************************************************************");
			System.out.println("ec.text()="+ec.text());
			System.out.println("********************************************************************************************");
			System.out.println("ec.val()="+ec.val());
			System.out.println("********************************************************************************************");
			System.out.println("ec.elementSiblingIndex()="+ec.elementSiblingIndex());
			System.out.println("********************************************************************************************");
			System.out.println("ec.childNode(0)="+ec.childNode(0));
			System.out.println("********************************************************************************************");
			System.out.println("ec.getElementsByTag(\"a\")="+ec.getElementsByTag("a"));
			System.out.println("********************************************************************************************");
			System.out.println("ec.getElementsByTag(\"img\").outerHtml()="+ec.getElementsByTag("img").outerHtml());
			System.out.println("********************************************************************************************");
			System.out.println("ec.select(\"a[href]\").toString()"+ec.select("a[href]").toString());
			System.out.println("********************************************************************************************");
			System.out.println("ec.select(\"img[original]\").toString()"+ec.select("img[original]").toString());
//			System.out.println(""+ec.);
		}
		//获取连接地址，img地址，文本描述
		
		
	}
}
