package com.example;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;


@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class ZzApplication {

	JSONObject json=new JSONObject();
	private String readAll(Reader rd) throws IOException {
		StringBuilder sb = new StringBuilder();
		int cp;
		while ((cp = rd.read()) != -1) {
			sb.append((char) cp);
		}
		return sb.toString();
	}

	private JSONObject readJsonFromUrl(String url) throws IOException, JSONException {
		InputStream is = new URL(url).openStream();
		try {
			BufferedReader rd = new BufferedReader(new InputStreamReader(is, Charset.forName("UTF-8")));
			String jsonText = readAll(rd);
			JSONObject json = new JSONObject(jsonText);
			return json;
		} finally {
			is.close();
		}
	}
	@RequestMapping("/")
	public @ResponseBody
	List<JsonObject> getJsonList() throws JSONException, IOException {
		List<JsonObject> jsonObject = new ArrayList<JsonObject>();
   //**************BBC SPORT***********
	json = readJsonFromUrl("https://newsapi.org/v1/articles?source=bbc-sport&sortBy=top&apiKey=b84a33e51a9a4337adacb9c8cd593724");
  //***************BBC NEWS***********
		//json = readJsonFromUrl("https://newsapi.org/v1/articles?source=bbc-news&sortBy=top&apiKey=b84a33e51a9a4337adacb9c8cd593724");
	for (int i = 0; i < json.getJSONArray("articles").length()-1; i++) {
		String publishedTime=(String) json.getJSONArray("articles").getJSONObject(i).get("publishedAt");
		String authorName=(String) json.getJSONArray("articles").getJSONObject(i).get("author");
		String imageUrl=(String) json.getJSONArray("articles").getJSONObject(i).get("urlToImage");
		String discription=(String) json.getJSONArray("articles").getJSONObject(i).get("description");
		String title=(String) json.getJSONArray("articles").getJSONObject(i).get("title");
		String ariticlUrl=(String) json.getJSONArray("articles").getJSONObject(i).get("url");
		jsonObject.add(i,new JsonObject(publishedTime,authorName,discription,title,imageUrl,ariticlUrl ));
	}
		return jsonObject;
	}
	
	public static void main(String[] args) throws IOException, JSONException  {
		SpringApplication.run(ZzApplication.class, args);
	}
}

