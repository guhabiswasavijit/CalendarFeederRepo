package org.seven.imageservlet.servlet;

import java.io.IOException;
import java.io.InputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import lombok.extern.slf4j.Slf4j;
@Slf4j
public class CalendarFeederServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String IMAGE_FILE_PARAM = "fileName";
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    	log.info(getServletInfo());
    	CloseableHttpClient httpClient = HttpClients.createDefault();
    	String imageFileName = req.getParameter(IMAGE_FILE_PARAM);
        try {
            HttpGet request = new HttpGet("http://127.0.0.1/images/"+imageFileName);
            CloseableHttpResponse response = httpClient.execute(request);
            try {
            	log.info("got protocol {}",response.getProtocolVersion()); 
            	log.info("got status {}",response.getStatusLine().getStatusCode()); 
            	log.info("got status line {}",response.getStatusLine().getReasonPhrase());
            	log.info("got status line {}",response.getStatusLine().toString());
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    log.info("got entity {}",entity.getContentType());
                    InputStream imageStream = entity.getContent();
                    resp.addHeader(entity.getContentType().getName(),entity.getContentType().getValue());
                    byte[] imageBuffer = new byte[(int)entity.getContentLength()];
                    imageStream.read(imageBuffer);
                    resp.getOutputStream().write(imageBuffer);
                }
            } finally {
                response.close();
            }
        } finally {
            httpClient.close();
        }
    }
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}


