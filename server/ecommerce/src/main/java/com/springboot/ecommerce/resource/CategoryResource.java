package com.springboot.ecommerce.resource;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.springboot.ecommerce.entity.Category;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;
import lombok.With;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Date;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder(toBuilder = true)
@With
@ToString
public class CategoryResource
{
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Long id;

    @NotBlank
    @Size(max = 255)
    private final String name;

    @NotBlank
    @Size(max = 255)
    private final String code;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String createdBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Date createAt;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final String modifiedBy;

    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private final Date modifiedAt;

    private final Boolean isDeleted;

    public CategoryResource(Category entity) {
        this.id = entity.getId();
        this.name = entity.getName();
        this.code = entity.getCode();
        this.createdBy = entity.getCreatedBy();
        this.createAt = entity.getCreatedAt();
        this.modifiedBy = entity.getModifiedBy();
        this.modifiedAt = entity.getModifiedAt();
        this.isDeleted = entity.isDeleted();
    }

    public Category toEntity() {
        return Category.builder()
                .id(id)
                .name(name)
                .code(code)
                .createdBy(createdBy)
                .createdAt(createAt)
                .modifiedBy(modifiedBy)
                .modifiedAt(modifiedAt)
                .isDeleted(isDeleted)
                .build();
    }
}
