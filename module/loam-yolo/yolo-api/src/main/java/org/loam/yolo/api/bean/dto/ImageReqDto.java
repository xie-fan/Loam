package org.loam.yolo.api.bean.dto;

import lombok.Data;
import org.loam.yolo.api.bean.entity.Image;
import org.loam.yolo.api.bean.entity.Label;

import java.util.List;

@Data
public class ImageReqDto {

    private String name;

    private String url;

    private List<Label> labels;

    public Image toImage() {
        Image image = new Image();
        image.setName(name);
        image.setUrl(url);
        image.setLabels(labels);
        return image;
    }
}
