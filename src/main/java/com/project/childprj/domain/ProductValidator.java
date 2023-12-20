package com.project.childprj.domain;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class ProductValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        boolean result = Product.class.isAssignableFrom(clazz);
        return result;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Product product = (Product) target;

        if (product.getPrice() == null) {
            errors.rejectValue("price", "가격을 입력해 주세요");
        }

        if (product.getProductName() == null || product.getProductName().trim().isEmpty()) {
            errors.rejectValue("productName", "상품명을 입력해 주세요");
        }

        if (product.getRegion() == null || product.getRegion().trim().isEmpty() || product.getRegion().equals("지역선택")) {
            errors.rejectValue("region", "지역을 선택해 주세요");
        }

        if (product.getContent() == null || product.getContent().trim().isEmpty()) {
            errors.rejectValue("content", "내용을 입력해 주세요");
        }
    }
}
