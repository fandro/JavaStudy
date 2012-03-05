package freemarker;

import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

import freemarker.template.Configuration;
import freemarker.template.DefaultObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class TestFreeMarker {
	
	public static void main(String[] args) {
		Configuration cfg = new Configuration();
		try {
			System.out.println(ClassLoader.getSystemResource("freemarker/mail").getPath());
			cfg.setDirectoryForTemplateLoading(new File(ClassLoader.getSystemResource("freemarker/mail").getPath()));
			cfg.setObjectWrapper(new DefaultObjectWrapper());
			
			Template temp = cfg.getTemplate("test.ftl");
			//temp.
			Map root = new HashMap();
			root.put("user", "fuweibo");
			
			Map address = new HashMap();
			address.put("home", "河北");
			address.put("company", "beijing");
			
			root.put("address", address);
			
			// 输出信息
			
			Writer out = new OutputStreamWriter(System.out);
			temp.process(root, out);
			out.flush();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TemplateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
