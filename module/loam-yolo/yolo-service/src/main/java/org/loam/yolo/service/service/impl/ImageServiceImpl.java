package org.loam.yolo.service.service.impl;

import org.bson.types.ObjectId;
import org.loam.mongo.utils.MongoQueryBuilder;
import org.loam.yolo.api.bean.dto.ImageReqDto;
import org.loam.yolo.api.bean.entity.Image;
import org.loam.yolo.service.dao.ImageRepository;
import org.loam.yolo.service.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class ImageServiceImpl implements ImageService {

    private ImageRepository imageRepository;

    @Autowired
    public ImageServiceImpl(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public Page<Image> getImageList(ImageReqDto reqDto, int pageNum, int pageSize) {
        return imageRepository.findAll(Example.of(reqDto.toImage()), MongoQueryBuilder.builder(pageNum, pageSize));
    }

    @Override
    public Image getImage(ObjectId id) {
        return imageRepository.findById(id).orElse(null);
    }

    @Override
    public Image updateImage(ImageReqDto reqDto) {
        return imageRepository.save(reqDto.toImage());
    }

    @Override
    public Image addImage(ImageReqDto reqDto) {
        return imageRepository.insert(reqDto.toImage());
    }

    @Override
    public void deleteImage(ObjectId id) {
        imageRepository.deleteById(id);
    }
}
