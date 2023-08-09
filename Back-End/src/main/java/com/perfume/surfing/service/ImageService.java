//package com.perfume.surfing.service;
//
//
//import com.perfume.surfing.domain.Image;
//import com.perfume.surfing.repository.ImageRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//@Transactional(readOnly = true)
//@RequiredArgsConstructor
//public class ImageService {
//
//    private final ImageRepository imageRepository;
//
//    // 이미지 추가
//    // @Transactional(readOnly = true) -> 클래스 전체를 ReadOnly를 취해 DB접근시 속도, 메모리 등 성능을 향상 시키고
//    // 추가의 readOnly를 풀어 DB에 값 변경을 할 수 있도록 함
//    @Transactional
//    public int add(Image image){
//        validateDuplicateBrand(image);  // 중복 검사
//        imageRepository.save(image);
//        return image.getId();//
//    }
//
//    private void validateDuplicateBrand(Image image){
//        imageRepository.findByName(image.getName())
//                .ifPresent(m->{
//                    throw new IllegalStateException("이미 존재하는 이미지입니다.");
//                });
//    }
//
//    // 검색 =============================
//    // 전체 검색
//    public List<Image> findImages(){
//        return imageRepository.findAll();
//    }
//    // ID로 검색
//    public Optional<Image> findOne(int imageId){
//        return imageRepository.findById(imageId);
//    }
//}
