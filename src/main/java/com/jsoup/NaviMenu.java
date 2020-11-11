package com.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.Iterator;

public class NaviMenu {

	public static void main(String[] args) throws IOException {
		Document doc = Jsoup.connect("http://www.vancl.com").get();
		/*String title = doc.title();
		System.out.println(title);*/
		
		//"ul>class:ztCollectImg>li>img";
		
		Element mainNavDiv = doc.getElementById("mainNav");
		Element subNavDiv = doc.getElementById("floor_nav");
		
		/*System.out.println(mainNavDiv.outerHtml());
		System.out.println("---------------------------------------------");
		System.out.println(mainNavDiv.html());*/
		
		Elements mainNavUl = mainNavDiv.children();
		Elements mainNavA = mainNavDiv.getElementsByTag("a");
		
		Elements subNavUl = subNavDiv.children();
		Elements subNavA = mainNavDiv.getElementsByTag("a");
		
		
		 //int i=1;
		for (Iterator<Element> iterator = mainNavUl.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			//System.out.println(i++);
			System.out.println(element.outerHtml());
		}
		System.out.println("--------------------------------------");
		for (Iterator<Element> iterator = subNavUl.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			//System.out.println(i++);
			System.out.println(element.outerHtml());
		}

		
		int tableWidth = 0;
		int totalWidth=650;
		for (Iterator<Element> iterator = mainNavA.iterator(); iterator.hasNext();) {
			Element element = (Element) iterator.next();
			//System.out.println(i++);
			//System.out.println(element.outerHtml());
			//System.out.println(element.attr("href"));
			
			String navText = element.text();
			int width = 0;
			for (int j = 0; j < navText.length(); j++) {
				String s = navText.substring(j, j+1);
				System.out.println("字符="+s);
				// 判断navText是中文or英文，几个字符，计算出宽度
				byte[] bytes =s.getBytes();
				int i = bytes.length;
				int k = s.length();
				if(i==k){//英文 9px
					width +=9;
				}else{//中文 16px17
					width +=16;
				}
				
			}
			tableWidth+=width;
			System.out.println("<td width=\""+width+"\" height=\"32\" ><a href=\""+element.attr("href")+"\" target=\"_blank\" style=\"color: #FFFFFF; display: inline;float: left;height: 30px;line-height: 28px; margin-top: 1px; padding: 0 9px; font-size:12px;}\">"+navText+"</a></td>");
			if(tableWidth>totalWidth){
				break;
			}
		}
		System.out.println("tableWidth="+tableWidth);
		
		
		
	}
	
	
	
	/*<table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><a href="http://www.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_03.jpg" width="49" height="32" border="0" /></a></td>
      <td><a href="http://weiyi.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_04.jpg" width="41" height="32" border="0" /></a></td>
      <td><a href="http://shirts.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_05.jpg" width="39" height="32" border="0" /></a></td>
      <td><a href="http://fanbuxie.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_06.jpg" alt="" width="53" height="32" border="0" /></a></td>
      <td><a href="http://catalog.vancl.com/integrated/zcjx_20120223.html?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_07.jpg" width="40" height="32" border="0" /></a></td>
      <td><a href="http://channel.vancl.com/niuzai?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_08.jpg" width="40" height="32" border="0" /></a></td>
      <td><a href="http://xiuxianku.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_09.jpg" width="53" height="32" border="0" /></a></td>
      <td><a href="http://nvren.vancl.com/search/?navtype=27&amp;attrid_series=21373&amp;view=1&amp;cateid=5458&amp;Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_10.jpg" width="54" height="32" border="0" /></a></td>
      <td><a href="http://stockings.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_11.jpg" width="36" height="32" border="0" /></a></td>
      <td><a href="http://channel.vancl.com/sneakers/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_12.jpg" width="48" height="32" border="0" /></a></td>
      <td><a href="http://tuan.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_13.jpg" width="40" height="32" border="0" /></a></td>
      <td><a href="http://m.vancl.com/m/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_14.jpg" width="68" height="32" border="0" /></a></td>
      <td><a href="http://mkt.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_15.jpg" width="52" height="32" border="0" /></a></td>
      <td><a href="http://s.vancl.com/search?k=&amp;amp&amp;Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_16.jpg" width="52" height="32" border="0" /></a></td>
      <td><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_17.jpg" width="35" height="32" /></td>
    </tr>
  </table>
  <table width="100%" border="0" cellspacing="0" cellpadding="0">
    <tr>
      <td><a href="http://men.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_19.jpg" width="56" height="31" border="0" /></a></td>
      <td><a href="http://nvren.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_20.jpg" width="48" height="31" border="0" /></a></td>
      <td><a href="http://children.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_21.jpg" width="47" height="31" border="0" /></a></td>
      <td><a href="http://s.vancl.com/1866.html?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_22.jpg" width="49" height="31" border="0" /></a></td>
      <td><a href="http://nvxue.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_23.jpg" width="45" height="31" border="0" /></a></td>
      <td><a href="http://sports.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_24.jpg" width="54" height="31" border="0" /></a></td>
      <td><a href="http://neiyi.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_25.jpg" width="51" height="31" border="0" /></a></td>
      <td><a href="http://accessories.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_26.jpg" width="45" height="31" border="0" /></a></td>
      <td><a href="http://miook.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_27.jpg" width="61" height="31" border="0" /></a></td>
      <td><a href="http://bag.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_28.jpg" width="50" height="31" border="0" /></a></td>
      <td><a href="http://nvren.vancl.com/search?navtype=03&amp;attrid_series=21665&amp;view=1&amp;Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_29.jpg" width="71" height="31" border="0" /></a></td>
      <td><a href="http://fashion.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_30.jpg" width="71" height="31" border="0" /></a></td>
      <td><a href="http://star.vancl.com/?Source=email_20120224_Z" target="_blank"><img src="http://i.vanclimg.com/zhuanti/edm_20120224/menu20120224_31.jpg" width="52" height="31" border="0" /></a></td>
    </tr>
  </table>*/
}
