package org.loam.yolo.api.bean.dto;

import lombok.Data;
import org.loam.yolo.api.bean.entity.Label;

import java.util.List;

@Data
public class LabelReqDto {

    private String imageId;

    private List<Label> labels;
}
