package Pratice;

import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.stream.Collectors;

import lombok.Data;

@Data
class Post {

	private Integer id;
	private Integer likes;
	private String content;

	public Post(Integer id, Integer likes, String content) {
		super();
		this.id = id;
		this.likes = likes;
		this.content = content;
	}

}

public class TotalLikesPerUser {

	public static void main(String[] args) {
		List<Post> postList = new LinkedList<>();
		postList.add(new Post(1, 50, "Post 1 by user 1"));
		postList.add(new Post(2, 30, "Post 1 by user 2"));
		postList.add(new Post(1, 20, "Post 2 by user 1"));
		postList.add(new Post(3, 70, "Post 1 by user 3"));
		postList.add(new Post(2, 10, "Post 2 by user 2"));
		postList.add(new Post(3, 100, "Post 2 by user 2"));

		List<Entry<Integer, Integer>> result = postList.stream()
				.collect(Collectors.groupingBy(Post::getId, Collectors.summingInt(Post::getLikes))).entrySet().stream()
				.filter(entry -> entry.getValue() > 50).collect(Collectors.toList());

		result.forEach(entry -> {
			System.out.println("User Id:-" + entry.getKey() + " TotalLike :- " + entry.getValue());
		});

	}

}
