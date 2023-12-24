package com.project.childprj.service;


import com.project.childprj.domain.Post;
import com.project.childprj.domain.Product;
import com.project.childprj.domain.ProductImg;
import com.project.childprj.domain.User;
import com.project.childprj.repository.ProductCommentRepository;
import com.project.childprj.repository.ProductImgRepository;
import com.project.childprj.repository.ProductRepository;
import com.project.childprj.repository.UserRepository;
import com.project.childprj.util.U;
import jakarta.servlet.http.HttpSession;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@Service
public class ProductServiceImpl implements ProductService {

    @Value("${app.upload.path}")
    private String uploadDir;

    private ProductRepository productRepository;
    private UserRepository userRepository;
    private ProductImgRepository productImgRepository;

    @Autowired
    public ProductServiceImpl(SqlSession sqlSession) {
        productImgRepository = sqlSession.getMapper(ProductImgRepository.class);
        productRepository = sqlSession.getMapper(ProductRepository.class);
        userRepository = sqlSession.getMapper(UserRepository.class);
    }

    // 글 목록 조회 (페이징 + 검색어)
    @Override
    public List<Product> list(Integer page, String sq, Model model) {
        HttpSession session = U.getSession();

        if (page == null) page = 1;
        if (page < 1) page = 1;

        if (sq == null) sq = "";

        String productOrderWay = (String) session.getAttribute("productOrderWay");
        if (productOrderWay == null) productOrderWay = "최신순";

        Integer pagesPerSection = 5;
        Integer rowsPerPage = 8;

        int totalLength = productRepository.selectCountAll(sq);
        int totalPage = (int) Math.ceil(totalLength / (double) rowsPerPage);

        int startPage = 0;
        int endPage = 0;

        List<Product> products = null;
        List<ProductImg> productImgs = null;

        if (totalLength > 0) {
            if (page > totalPage) page = totalPage;

            int fromRow = (page - 1) * rowsPerPage;

            startPage = (((page - 1) / pagesPerSection) * pagesPerSection) + 1;
            endPage = startPage + pagesPerSection - 1;
            if (endPage > totalPage) endPage = totalPage;

            if (productOrderWay.equals("최신순")) {
                products = productRepository.selectFromCntOrderByDate(fromRow, rowsPerPage, sq);
            } else if (productOrderWay.equals("가격순")) {
                products = productRepository.selectFromCntOrderByPrice(fromRow, rowsPerPage, sq);
            }
            model.addAttribute("products", products);
        } else {
            page = 0;
        }

        model.addAttribute("page", page);
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("rowsPerPage", rowsPerPage);
        model.addAttribute("productOrderWay", productOrderWay);
        model.addAttribute("sq", sq);

        model.addAttribute("url", U.getRequest().getRequestURI());
        model.addAttribute("startPage", startPage);
        model.addAttribute("endPage", endPage);

        // 이미지 나열
        // 아니 리스트놈이 안 나와서 볼 수가 없어
        for(Product e : products){
            e.setProductImg(productImgRepository.findByProduct(e.getId())); // 아이디로 이미지 찾아서 객체 세팅
        }

        return products;
    }

    // 글 작성
    public int write(Product product) {
        User user = U.getLoggedUser();

        user = userRepository.findUserById(user.getId());
        product.setUser(user);

        int cnt = productRepository.insert(product);

        return cnt;
    }

    // 특정 글 가져오기
    @Override
    public Product productDetail(Long id) {
        return productRepository.findProductById(id);
    }

    @Override
    public void incViewCnt(Long id) {
        productRepository.incViewCnt(id);
    }

    // 특정 글 삭제
    @Override
    public int detailDelete(Long id) {
        return productRepository.detailDelete(id);
    }

    // 글 수정
    @Override
    public int update(Product product) {
        int result = productRepository.update(product);
        return result;
    }

    // 사진 불러오기
    @Override
    public ProductImg findByProduct(Long productId) {
        return productImgRepository.findByProduct(productId);
    }

    // 대표 사진 등록
    @Override
    public boolean imgInsert(Map<String, MultipartFile> file, Long productId) {

        changeImg(file, productId);
        return (file != null);
    }

    private void changeImg(Map<String, MultipartFile> file, Long productId){

        // 배사 있으면 삭제
        if(productImgRepository.findByProduct(productId) != null){
            productImgRepository.imgDelete(productId);
        }

        if(file == null) return;

        for(Map.Entry<String, MultipartFile> e : file.entrySet()){

            // 시작 이름 설정
            if(!e.getKey().startsWith("product")) continue;

            // 물리적 저장
            ProductImg productImg = upload(e.getValue());

            // DB 저장
            if(productImg != null){
                productImg.setProductId(productId);
                productImgRepository.imgInsert(productImg);
            }
        }
    }

    private ProductImg upload(MultipartFile multipartFile){

        ProductImg productImg = null;
        String sourceName = null;
        String fileName = null;

        String originalFileName = multipartFile.getOriginalFilename();

        if(originalFileName.isEmpty()){
            sourceName = "default.jpg";
            fileName = sourceName;
        } else {
            sourceName = StringUtils.cleanPath(originalFileName); // 경로 깨끗?

            // 저장될 파일명
            fileName = sourceName; // 일단 같은 이름으로 저장

            File file = new File(uploadDir, fileName); // 중복 확인

            if(file.exists()){  // 이미 존재하는 파일명,  중복된다면 다른 이름은 변경하여 파일 저장
                // a.txt => a_2378142783946.txt  : time stamp 값을 활용할 거다!
                // "a" => "a_2378142783946" : 확장자 없는 경우

                int pos = fileName.lastIndexOf(".");
                if(pos > -1){  // 확장자 있는 경우
                    String name = fileName.substring(0, pos);   // 파일 '이름'
                    String ext = fileName.substring(pos + 1);  // 파일 '확장자'

                    fileName = name + "_" + System.currentTimeMillis() + "." + ext;
                } else {  // 확장자 없는 경우
                    fileName += "_" + System.currentTimeMillis();
                }
            }

            // 파일 절대경로
            Path copyOfLocation = Paths.get(new File(uploadDir, fileName).getAbsolutePath());

            try {
                // inputStream을 가져와서
                // copyOfLocation (저장위치)로 파일을 쓴다.
                // copy의 옵션은 기존에 존재하면 REPLACE(대체한다), 오버라이딩 한다
                Files.copy(
                        multipartFile.getInputStream(),
                        copyOfLocation,
                        StandardCopyOption.REPLACE_EXISTING
                );
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        productImg = ProductImg.builder()
                .sourceName(sourceName)
                .fileName(fileName)
                .build();

        return productImg;
    }

    // home -- hot five
    @Override
    public List<Product> selectFive() {
        return productRepository.selectFive();
    }
}




