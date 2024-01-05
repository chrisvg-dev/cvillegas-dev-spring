package com.cvillegas.app.main.dto;

import com.cvillegas.app.main.model.BaseEntity;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.Collection;
import java.util.Map;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
public class ResponseWrapperDto {
    private String key;
    private Collection<? extends BaseEntity> data;
}
