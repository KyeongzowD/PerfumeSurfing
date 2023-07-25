package com.perfume.surfing.service;

import com.perfume.surfing.domain.*;
import com.perfume.surfing.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class CustomerService {//조회만 가능


}