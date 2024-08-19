# APIResponseParser

## Overview

`APIResponseParser` is a **VERY BASIC VERSION** of a Java utility designed to parse XML responses from an API and extract specific data into a structured format. The example provided demonstrates how the parser can be used to extract information about a book from an XML response.

## Features

- **XML Parsing:** Extracts data from XML responses based on predefined tags.
- **Data Mapping:** Maps extracted data into a `Book` object.
- **Flexible Parsing:** Easily customizable to parse different XML structures.

## Project Structure

- **APIResponseParser.java:** Contains the logic to parse the XML response and map the data into a `Book` object.
- **Book.java:** Represents a `Book` entity with fields like `title`, `author`, `publicationYear`, `averageRating`, `ratingsCount`, and `imageUrl`.

## Usage

1. **Clone the repository:**

    ```bash
    git clone https://github.com/notaarryan/APIResponseParser.git
    cd APIResponseParser
    ```

2. **Compile the Java files:**

    ```bash
    javac APIResponseParser.java Book.java
    ```

3. **Run the parser:**

    ```bash
    java APIResponseParser
    ```

4. **Example XML Response:**

    The following is a sample XML response that can be parsed using `APIResponseParser`:

    ```xml
    <work>
        <id type="integer">2361393</id>
        <books_count type="integer">813</books_count>
        <ratings_count type="integer">1,16,315</ratings_count>
        <text_reviews_count type="integer">3439</text_reviews_count>
        <original_publication_year type="integer">1854</original_publication_year>
        <average_rating>4.5</average_rating>
        <best_book>
            <id type="integer">16902</id>
            <title>Walden</title>
            <author>
                <name>Henry David Thoreau</name>
            </author>
            <image_url>http://images.gr-assets.com/books/1465675526m/16902.jpg</image_url>
        </best_book>
    </work>
    ```

5. **Output:**

    Running the parser on the above XML will produce the following output:

    ```
    Title: Walden
    Author: Henry David Thoreau
    Publication Year: 1854
    Average Rating: 4.5
    Ratings Count: 116315
    Image Url: http://images.gr-assets.com/books/1465675526m/16902.jpg
    ```

## Customization

To customize the parser for a different XML structure, modify the `startRule` values in `APIResponseParser.java` according to the new XML tags.

## Contributing

Contributions are welcome! Feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License.
