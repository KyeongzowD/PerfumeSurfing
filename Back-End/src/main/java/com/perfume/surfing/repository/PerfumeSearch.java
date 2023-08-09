package com.perfume.surfing.repository;

import com.perfume.surfing.domain.WordType;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class PerfumeSearch {
    private Long searchId;
    private WordType searchType;
}
