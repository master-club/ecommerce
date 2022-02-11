package com.springboot.ecommerce.repository.sort;

import com.springboot.ecommerce.common.domain.SortParam;
import com.springboot.ecommerce.common.domain.SortParam.Direction;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Sort;

import java.util.Arrays;

@Getter
@Setter
@AllArgsConstructor
public class CategorySort
{
    private SortColumn sortBy;

    private Sort.Direction direction;

    public static CategorySort fromSort(SortParam sort) {
        Sort.Direction direction = Sort.Direction.ASC;

        if (Direction.fromDirection(sort.getDirection()).equals(Direction.DESC)) {
            direction = Sort.Direction.DESC;
        }

        return new CategorySort(SortColumn.fromPropertyName(sort.getProperty()), direction);
    }

    @AllArgsConstructor(access = AccessLevel.PRIVATE)
    public enum SortColumn
    {
        ID("id");

        @Getter
        private final String propertyName;

        public static SortColumn fromPropertyName(String propertyName) {
            return Arrays.stream(values())
                    .filter(v -> v.propertyName.equals(propertyName))
                    .findFirst()
                    .orElseThrow(
                            () -> new IllegalArgumentException("propertyName = '" + propertyName + "' is not supported."));
        }
    }
}
