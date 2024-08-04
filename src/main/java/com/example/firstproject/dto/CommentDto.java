package com.example.firstproject.dto;


import com.example.firstproject.entity.Comment;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class CommentDto {
    private Long id;
    @JsonProperty("article_id")
    private Long articleId; //   해당 클래스가 엔티티가 아닌 단순 데이터 전달 클래스
    private String nickname;
    private String body;

    public static CommentDto createCommentDto(Comment comment) {
        return new CommentDto(
                comment.getId(), // 댓글 엔티티의 id
                comment.getArticle().getId(),
                comment.getNickname(),
                comment.getBody()
        );
    }
}
