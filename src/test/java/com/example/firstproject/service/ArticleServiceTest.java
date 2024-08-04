package com.example.firstproject.service;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.transaction.annotation.Transactional;
import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test; // Test 패키지 임포트
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;  // 앞으로 사용할 수 있는 패키지 임포트

@SpringBootTest
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;
    @Test
    void index() {
        // 1. 예상 데이터
        Article a = new Article( 1L,"가가가가", "1111");
        Article b = new Article(2L, "나나나나", "2222");
        Article c = new Article(3L, "다다다다", "3333");
        Article d = new Article(4L, "라라라라", "4444");
        Article e = new Article(5L, "라라라라", "4444");
        List<Article>expected = new ArrayList<Article>(Arrays.asList(a,b,c,d,e));
        // 2. 실제 데이터
        List<Article> articles = articleService.index();
        // 3. 비교 및 검증
        assertEquals(expected.toString(), articles.toString());

    }

    @Test
    void show_성공_존재하는_id_입력() {
        // 1. 예상 데이터
        Long id = 1L;
        Article expected = new Article(id, "가가가가","1111");
        // 2. 실제 데이터
        Article article = articleService.show(id);
        //3. 비교 및 검증
        assertEquals(expected.toString(), article.toString());
    }

    @Test
    void show_실패_존재하지_않는_id_입력(){
        //1. 예상 데이터

        // given 데이터
        Long id = -1L;
        Article expected = null;
        //2. 실제 데이터
        Article article = articleService.show(id);
        // 3. 비교 및 검증

        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void create_성공_title과_content만_있는_dto_입력() {
        //1. 예상 데이터
        String title ="라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(null,title,content);
        Article expeted = new Article(16L, title, content);
        //2. 실제 데이터
        Article article = articleService.create(dto);
        // 3. 비교 및 검증
        assertEquals(expeted.toString(),article.toString());
    }
    @Test
    @Transactional
    void create_실패_id가_포함된_dto_입력(){
        // 1. 예상 데이터
        Long id = 4L;
        String title = "라라라라";
        String content = "4444";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = null; //
        //2. 실제 데이터
        Article article = articleService.create(dto);
        //3. 비교 및 검증
        assertEquals(expected,article);

    }

    @Test
    @Transactional
    void update_성공_존재하는_id와_title_content가_있는_dto_입력() {
        //1. 예상 데이터
        Long id = 5L;
        String title = "마마마마";
        String content ="5555";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = new Article(id,title,content);
        //2. 실제데이터
        Article article = articleService.update(id,dto);
        //3. 비교 및검증
        assertEquals(expected.toString(),article.toString());
    }
    @Test
    @Transactional
    void update_성공_존재하는_id와_title만_있는_dto_입력(){
        // 1. 예상 데이터
        Long id = 5L;
        String title = "먀먀먀먀";
        String content = null;
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expected = new Article(5L,"먀먀먀먀",null);
        // 실제 데이터
        Article article = articleService.update(id,dto);
        // 비교 및 검증
        assertEquals(expected.toString(),article.toString());

    }
    @Test
    @Transactional
    void update_실패_존재하지_않는_id의_dto_입력(){
        // 예상 데이터
        Long id = 150L;
        String title = "마마마마";
        String content = "5555";
        ArticleForm dto = new ArticleForm(id,title,content);
        Article expepted = null;
        // 실제 데이터
        Article article = articleService.update(id,dto);
        // 비교 및 검증
        assertEquals(expepted,article);
    }

    @Test
    @Transactional
    void delete_성공_존재하는_id_입력(){
        // 예상 데이터
        Long id = 5L;
        Article excepted = new Article(id,"라라라라","4444");
        // 실제 데이터
        Article article = articleService.delete(id);
        // 비교 및 검 증
        assertEquals(excepted.toString(),article.toString());
    }

    @Test
    @Transactional
    void delete_실패_존재하지_않는_id_입력(){
        // 예상 데이터
        Long id = 3500L;
        Article excepted = null;
        Article article = articleService.delete(id);
        // 비교 및 검증
        assertEquals(excepted,article);

    }


}