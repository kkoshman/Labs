import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class HelloImpl  extends HttpServlet {

	  final String flScript = "d:\\env\\osgi_workspace\\Practice1\\WebContent\\forPages\\info.xsl";
	  final String flData = "d:\\env\\osgi_workspace\\Practice1\\WebContent\\forPages\\info.xml";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession(true);
		
		  final File xmlFile = new File(flData); 
		  final File xsltFile = new File(flScript);
		  
		  //Чтение данных в JAXP через Source 
		  final Source xmlSource = new StreamSource(xmlFile); 
		  final Source xsltSource = new StreamSource(xsltFile);
		  
		  //Открыть процессор XSLT 
		  final TransformerFactory transFact = TransformerFactory.newInstance(); 
		  Transformer trans;
		try {
			trans = transFact.newTransformer(xsltSource);
		  // Применить таблицу стилей к входному документу 
		  trans.transform(xmlSource, new StreamResult(out));
		  
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		doGet(request, response);
	}

}
