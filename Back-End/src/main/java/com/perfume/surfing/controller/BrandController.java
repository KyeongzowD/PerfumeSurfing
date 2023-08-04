package com.perfume.surfing.controller;

import com.perfume.surfing.domain.Brand;
import com.perfume.surfing.service.BrandService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BrandController {

    private final BrandService brandService;
정
    @PostMapping("/api/b1/brands")
    public CreateBrandResponse saveBrandB1(@RequestBody @Valid CreateBrandRequest request){
        Brand brand=new Brand();
        brand.setName(request.name);

        int id=brandService.add(brand);//join함수 어데있음
        return new CreateBrandResponse(id);
    }

    @Data
    static class CreateBrandRequest{
        private String name;
    }

    @Data
    static class CreateBrandResponse{
        private int id;

        public CreateBrandResponse(int id){this.id=id;}
    }

    @PutMapping("/api/b1/brands/{id}")
    public UpdateBrandResponse updateBrandB1(
            @PathVariable("id") int id,
            @RequestBody @Valid UpdateBrandRequest request){

        brandService.update(id,request.getName());
        Optional<Brand> findBrand=brandService.findOne(id);

        return new UpdateBrandResponse(findBrand.get().getId(), findBrand.get().getName());
    }

    @Data
    static class UpdateBrandRequest{
        private String name;
    }

    @Data
    @AllArgsConstructor
    static class UpdateBrandResponse{
        private int id;
        private String name;
    }
}