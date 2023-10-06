package com.angkko.movie.model.domain;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter
public class RankAttributeConverter implements AttributeConverter<String, Integer> {
    @Override
    public Integer convertToDatabaseColumn(String attribute) {
        switch (attribute) {
            case "일반 관람객" -> {
                return 0;
            }
            case "전문 평론가" -> {
                return 1;
            }
            case "관리자" -> {
                return 2;
            }
        }
        return null;
    }

    @Override
    public String convertToEntityAttribute(Integer dbData) {
        switch (dbData) {
            case 0 -> {
                return "일반 관람객";
            }
            case 1 -> {
                return "전문 평론가";
            }
            case 2 -> {
                return "관리자";
            }
        }
        return null;
    }
}
