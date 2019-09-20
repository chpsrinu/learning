package WebCrawler;

public class App {
	
	public static void main(String[] args) {
		WebCrawler webCrawler = new WebCrawler();
		
		String url = "https://www.bbc.com";
		webCrawler.discoverWeb(url);
	}

}
