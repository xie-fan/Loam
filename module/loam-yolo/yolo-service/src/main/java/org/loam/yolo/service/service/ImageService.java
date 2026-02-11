package org.loam.yolo.service.service;

import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.dto.ImageReqDto;
import org.loam.yolo.api.bean.entity.Image;
import org.springframework.data.domain.Page;

public interface ImageService {

    Page<Image> getImageList(ImageReqDto reqDto, int pageNum, int pageSize);

    Image getImage(ObjectId id);

    Image updateImage(ImageReqDto reqDto);

    Image addImage(ImageReqDto reqDto);

    void deleteImage(ObjectId id);
}
