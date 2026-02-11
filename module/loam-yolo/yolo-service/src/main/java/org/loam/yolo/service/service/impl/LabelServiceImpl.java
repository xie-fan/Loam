package org.loam.yolo.service.service.impl;

import org.bson.types.ObjectId;
import org.loam.mongo.utils.ObjectIdUtil;
import org.loam.yolo.api.bean.dto.LabelReqDto;
import org.loam.yolo.api.bean.entity.Image;
import org.loam.yolo.api.bean.entity.Label;
import org.loam.yolo.service.dao.ImageRepository;
import org.loam.yolo.service.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class LabelServiceImpl implements LabelService {

    private ImageRepository imageRepository;

    @Autowired
    public LabelServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Label> getLabels(ObjectId imageId) {
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image != null && image.getLabels() != null) {
            return image.getLabels();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Label> updateLabels(LabelReqDto reqDto) {
        ObjectId imageId = ObjectIdUtil.format(reqDto.getImageId());
        Image image = imageRepository.findById(imageId).orElse(null);
        if (image != null) {
            image.setLabels(reqDto.getLabels());
            imageRepository.save(image);
            return image.getLabels();
        }
        return Collections.emptyList();
    }

    @Override
    public List<Label> preLabelImage(ObjectId imageId) {
        // 预标注方法，暂时不做处理，返回空列表
        return new ArrayList<>();
    }
}
