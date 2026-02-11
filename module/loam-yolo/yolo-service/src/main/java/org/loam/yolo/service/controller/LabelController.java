package org.loam.yolo.service.controller;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.mongo.utils.ObjectIdUtil;
import org.loam.yolo.api.bean.dto.LabelReqDto;
import org.loam.yolo.api.bean.entity.Label;
import org.loam.yolo.service.service.LabelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/label")
public class LabelController {

    private LabelService labelService;

    @Autowired
    public void setLabelService(LabelService labelService) {
        this.labelService = labelService;
    }

    @GetMapping("/{imageId}")
    public DataSet<List<Label>> getLabels(@PathVariable String imageId) {
        List<Label> labels = labelService.getLabels(ObjectIdUtil.format(imageId));
        return DataSet.success(labels);
    }

    @PutMapping
    public DataSet<List<Label>> updateLabels(@RequestBody LabelReqDto reqDto) {
        List<Label> labels = labelService.updateLabels(reqDto);
        return DataSet.success(labels);
    }

    @PostMapping("/pre-label/{imageId}")
    public DataSet<List<Label>> preLabelImage(@PathVariable String imageId) {
        List<Label> labels = labelService.preLabelImage(ObjectIdUtil.format(imageId));
        return DataSet.success(labels);
    }
}
