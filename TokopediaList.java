package webScraper;

import java.io.IOException;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;
import com.opencsv.CSVWriter;
import org.jsoup.Jsoup;
import org.jsoup.nodes.*;
import org.jsoup.select.Elements;
import java.io.FileReader;

public class TokopediaList {

	 public static void main(String[] args) {
		    try {
		      // Here we create a document object and use JSoup to fetch the website
		      Document doc = Jsoup.connect("https://www.tokopedia.com/p/handphone-tablet/handphone?page=1&rt=4,5").get();

		      // With the document fetched, we use JSoup's title() method to fetch the title
		      System.out.printf("Title: %s\n", doc.title());

		      // Get the list of repositories
		      Elements repositories = doc.getElementsByClass("css-bk6tzz e1nlzfl3");

		      /**
		       * For each repository, extract the following information:
		       * 1. Title
		       * 2. Number of issues
		       * 3. Description
		       * 4. Full name on github
		       */
		      for (Element repository : repositories) {
		        // Extract Name of Product.
		        String repositoryTitle = repository.getElementsByClass("css-1bjwylw").text();

		        // Extract the price
		        String repositoryPrice = repository.getElementsByClass("css-o5uqvq").text();

		        // Extract the image link
		        String repositoryImageLink = repository.getElementsByClass("css-t8frx0").text();

		        // Get the name of store
		        String repositoryNameOfStore = repository.getElementsByClass("css-1kr22w3").text();
		        
		        // Get the rating
		        String repositoryRating= repository.getElementsByClass("css-153qjw7").text();
		        
		        
		        // Format and print the information to the console
		        System.out.println(repositoryTitle);
		        System.out.println("\t" + repositoryPrice);
		        System.out.println("\t" + repositoryImageLink);
		        System.out.println("\t" + repositoryNameOfStore);
		        System.out.println("\t" + repositoryRating);
		        System.out.println("\n");
		        
		        CSVWriter write = new CSVWriter(new FileWriter("test//sample1.csv"));
		        
		        String set1[] = {"Name of product", "Price" , "Image Link", "Store", "Rating"};
		        String set2[] = {repositoryTitle, repositoryPrice, repositoryImageLink, repositoryNameOfStore, repositoryRating};
		        
		        
		        
		        List list = new ArrayList();
		        list.add(set1);
		        list.add(set2);
		        
		        
		        write.writeAll(list);
		        write.flush();
		        
		        System.out.println("data entered");
		      }

		    // In case of any IO errors, we want the messages written to the console
		    } catch (IOException e) {
		      e.printStackTrace();
		    }
		}
}
