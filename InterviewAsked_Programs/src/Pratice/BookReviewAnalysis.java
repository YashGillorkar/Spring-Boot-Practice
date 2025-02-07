package Pratice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import lombok.Data;

@Data
class BookReview {

	private String bookId;
	private Double rating;
	private String comment;

	public BookReview(String bookId, Double rating, String comment) {
		super();
		this.bookId = bookId;
		this.rating = rating;
		this.comment = comment;
	}

}

public class BookReviewAnalysis {

	public static void main(String[] args) {
		List<BookReview> bookReviewList = new ArrayList<BookReview>();
		bookReviewList.add(new BookReview("book1", 3.8, "Good Read"));
		bookReviewList.add(new BookReview("book2", 2.5, "Not My Favorite"));
		bookReviewList.add(new BookReview("book2", 3.0, "It was ok"));
		bookReviewList.add(new BookReview("book3", 5.0, "Excellent"));
		bookReviewList.add(new BookReview("book3", 4.8, "Amazing Read"));
		bookReviewList.add(new BookReview("book3", 4.2, "Very informative."));

		Map<String, List<BookReview>> bookReviewsMap = bookReviewList.stream()
				.filter(review -> review.getRating() >= 3.0).collect(Collectors.groupingBy(BookReview::getBookId));

		bookReviewsMap.forEach((bookId, reviewList) -> {
			Double averageRating = reviewList.stream().mapToDouble(BookReview::getRating).average().orElse(0.0);
			// Double averageRating = reviewList.stream().mapToDouble(bookreview ->
			// bookreview.getRating()).average()
			// .orElse(0.0);

			Integer count = reviewList.size();

			System.out.println("Book Id : " + bookId + ", Average Rating : " + averageRating + ", Count : " + count);

		});
	}
}
