package com.project.childprj.service;

import com.project.childprj.domain.Post;
import com.project.childprj.domain.PostRecommend;
import com.project.childprj.domain.User;
import com.project.childprj.repository.PostRecommendRepository;
import com.project.childprj.repository.PostRepository;
import com.project.childprj.repository.UserRepository;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;

@Service
public class PostServiceImpl implements PostService{

    private UserRepository userRepository;
    private PostRepository postRepository;
    private PostRecommendRepository postRecommendRepository;

    @Autowired
    public PostServiceImpl(SqlSession sqlSession) {
        postRecommendRepository = sqlSession.getMapper(PostRecommendRepository.class);
        postRepository = sqlSession.getMapper(PostRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    // 글 목록 조회 (페이징 + 검색어)
    @Override
    public List<Post> list(Integer page, String sq, Model model) {
        HttpSession session = U.getSession();

        if (page == null) page = 1;
        if (page < 1) page = 1;

        if (sq == null) sq = "";

        String postOrderWay = (String) session.getAttribute("postOrderWay");
        if (postOrderWay == null) postOrderWay = "최신순";

        Integer pagesPerSection = 5;
        Integer rowsPerPage = 5;

        int totalLength = postRepository.selectCountAll(sq);
        int totalPage = (int) Math.ceil(totalLength / (double) rowsPerPage);

        int startPage = 0;
        int endPage = 0;

        List<Post> posts = null;

        if (totalLength > 0) {
            if (page > totalPage) page = totalPage;

            int fromRow = (page - 1) * rowsPerPage;

            startPage = (((page - 1) / pagesPerSection) * pagesPerSection) + 1;
            endPage = startPage + pagesPerSection - 1;
            if (endPage > totalPage) endPage = totalPage;

            if (postOrderWay.equals("최신순")) {
                posts = postRepository.selectFromCntOrderByDate(fromRow, rowsPerPage, sq);
            } else if (postOrderWay.equals("추천순")) {
                posts = postRepository.selectFromCntOrderByRcmCnt(fromRow, rowsPerPage, sq);
            }
            model.addAttribute("posts", posts);
        } else {
            page = 0;
        }

        model.addAttribute("page", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("rowsPerPage", rowsPerPage);
        model.addAttribute("postOrderWay", postOrderWay);
        model.addAttribute("sq", sq);

        model.addAttribute("url", U.getRequest().getRequestURI());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        return posts;
    }

    // 글 작성
    @Override
    public int write(Post post) {
        User user = U.getLoggedUser();

        user = userRepository.findUserById(user.getId());
        post.setUser(user);

        int cnt = postRepository.insert(post);

        return cnt;
    }

    // 특정 글 가져오기
    @Override
    public Post postDetail(Long id) {
        return postRepository.findPostById(id);
    }

    // 조회수 올리기
    @Override
    public void incViewCnt(Long id) {
        postRepository.incViewCnt(id);
    }

    // 특정 글 삭제
    @Override
    public int detailDelete(Long id) { return postRepository.detailDelete(id); }

    // 추천 눌렀나?
    @Override
    public boolean clickCheck(Long userId, Long postId) {
        PostRecommend postRecommend = postRecommendRepository.clickCheck(userId, postId);
        return (postRecommend != null);
    }

    // 추천
    @Override
    public int recommend(Long userId, Long postId) {
        postRepository.incRecomCnt(postId);
        return postRecommendRepository.recommend(userId, postId);
    }

    // 비추천
    @Override
    public int opposite(Long userId, Long postId) {
        postRepository.decRecomCnt(postId);
        return postRecommendRepository.opposite(userId, postId);
    }

    // 글 수정
    @Override
    public int update(Post post) {
        int result = postRepository.update(post);
        return result;
    }

    // home -- hot five
    @Override
    public List<Post> selectFive() {
        return postRepository.selectFive();
    }

}
