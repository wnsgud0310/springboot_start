package com.example.firstproject.api;

import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Comment;
import com.example.firstproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CommentApiController {

    @Autowired
    private CommentService commentService;

    @GetMapping("/api/articles/{articleId}/comments")
    //1. 댓글조회
    // 반환 타입 ResponseEntity
    public ResponseEntity<List<CommentDto>> comments(@PathVariable Long articleId) {
        // 서비스에 위임
        List<CommentDto> dtos = commentService.comments(articleId);

        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(dtos);

    }

    //2. 댓글 생성
    @PostMapping("/api/articles/{articleId}/comments")
    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
                                             @RequestBody CommentDto dto) {

        // 서비스에 위임
        CommentDto createDto = commentService.create(articleId, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(createDto);

    }
//    @PostMapping("/api/articles/{articleId}/comments")
//    public ResponseEntity<CommentDto> create(@PathVariable Long articleId,
//                                             @RequestBody CommentDto dto) {
//
//        CommentDto saved = null;
//
//        //파라미터 articledId 와 DTO 의 articleId 비교
//        if (articleId == dto.getArticleId()) {
//
//            saved = commentService.create(articleId, dto);
//        }
//
//        //결과 응답
//        return (saved != null) ?
//                ResponseEntity.status(HttpStatus.OK).body(saved) :
//                ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
//    }


    //3. 댓글 수정
    @PatchMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> update(@PathVariable Long id,
                                             @RequestBody CommentDto dto) {
        // 서비스에 위임
        CommentDto updatedDto = commentService.update(id, dto);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(updatedDto);

    }

    //4. 댓글 삭제
    @DeleteMapping("/api/comments/{id}")
    public ResponseEntity<CommentDto> delete(@PathVariable Long id) {
        // 서비스에 위임
        CommentDto deletedDto = commentService.delete(id);
        // 결과 응답
        return ResponseEntity.status(HttpStatus.OK).body(deletedDto);


    }
}
