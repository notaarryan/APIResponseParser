import java.lang.String;

public class APIResponseParser {
    public static Book parse(String response) {
        Book book = new Book();
        String endRule = "<";

        String startRule = "<title>";
        String title = parse(response, startRule, endRule);
        book.setTitle(title);

        startRule = "<name>";
        String author = parse(response, startRule,endRule);
        book.setAuthor(author);

        startRule = "<original_publication_year type=\"integer\">";
        int publicationYear = Integer.parseInt(parse(response,startRule,endRule));
        book.setPublicationYear(publicationYear);


        startRule = "<average_rating>";
        double averageRating = Double.parseDouble(parse(response,startRule,endRule));
        book.setAverageRating(averageRating);

        startRule = "<ratings_count type=\"integer\">";
        int ratingsCount = Integer.parseInt(parse(response,startRule,endRule).replaceAll(",",""));
        book.setRatingsCount(ratingsCount);

        startRule = "<image_url>";
        String imageUrl = parse(response,startRule,endRule);
        book.setImageUrl(imageUrl);

        return book;

    }

    // write overloaded parse method with the 3 parameters response, startRule, endRule

    private static String parse(String response, String startRule, String endRule) {
        response = response.substring(response.indexOf(startRule)+startRule.length());
        return response.substring(0,response.indexOf(endRule));
    }

    public static void main(String[] args) {
        String response = "<work>" +
                "<id type=\"integer\">2361393</id>" +
                "<books_count type=\"integer\">813</books_count>" +
                "<ratings_count type=\"integer\">1,16,315</ratings_count>" +
                "<text_reviews_count type=\"integer\">3439</text_reviews_count>" +
                "<original_publication_year type=\"integer\">1854</original_publication_year>" +
                "<original_publication_month type=\"integer\" nil=\"true\"/>" +
                "<original_publication_day type=\"integer\" nil=\"true\"/>" +
                "<average_rating>3.79</average_rating>" +
                "<best_book type=\"Book\">" +
                "<id type=\"integer\">16902</id>" +
                "<title>Walden</title>" +
                "<author>" +
                "<id type=\"integer\">10264</id>" +
                "<name>Henry David Thoreau</name>" +
                "</author>" +
                "<image_url>" +
                "http://images.gr-assets.com/books/1465675526m/16902.jpg" +
                "</image_url>" +
                "<small_image_url>" +
                "http://images.gr-assets.com/books/1465675526s/16902.jpg" +
                "</small_image_url>" +
                "</best_book>" +
                "</work>";

        Book book = APIResponseParser.parse(response);
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());
        System.out.println("Publication Year: " + book.getPublicationYear());
        System.out.println("Average Rating: " + book.getAverageRating());
        System.out.println("Ratings Count: " + book.getRatingsCount());
        System.out.println("Image Url: " + book.getImageUrl());
    }
}