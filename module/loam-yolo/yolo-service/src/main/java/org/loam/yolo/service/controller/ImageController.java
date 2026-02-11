package org.loam.yolo.service.controller;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.DataTable;
import org.loam.common.core.bean.vo.Message;
import org.loam.mongo.utils.ObjectIdUtil;
import org.loam.yolo.api.bean.dto.ImageReqDto;
import org.loam.yolo.api.bean.entity.Image;
import org.loam.yolo.service.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/image")
public class ImageController {

    private ImageService imageService;

    @Autowired
    public void setImageService(ImageService imageService) {
        this.imageService = imageService;
    }

    @GetMapping("/list")
    public DataTable<List<Image>> getImageList(ImageReqDto reqDto,
            @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        Page<Image> imagePage = imageService.getImageList(reqDto, pageNum, pageSize);
        return DataTable.success(imagePage.getContent(), imagePage.getTotalElements());
    }

    @GetMapping("/{imageId}")
    public DataSet<Image> getImage(@PathVariable String imageId) {
        Image image = imageService.getImage(ObjectIdUtil.format(imageId));
        return DataSet.success(image);
    }

    @PutMapping
    public DataSet<Image> updateImage(@RequestBody ImageReqDto reqDto) {
        Image image = imageService.updateImage(reqDto);
        return DataSet.success(image);
    }

    @PostMapping
    public DataSet<Image> addImage(@RequestBody ImageReqDto reqDto) {
        Image image = imageService.addImage(reqDto);
        return DataSet.success(image);
    }

    @DeleteMapping("/{imageId}")
    public Message deleteImage(@PathVariable String imageId) {
        imageService.deleteImage(ObjectIdUtil.format(imageId));
        return Message.success();
    }
}
