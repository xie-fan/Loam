package org.loam.yolo.service.service;

import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.dto.LabelReqDto;
import org.loam.yolo.api.bean.entity.Label;

import java.util.List;

public interface LabelService {

    List<Label> getLabels(ObjectId imageId);

    List<Label> updateLabels(LabelReqDto reqDto);

    List<Label> preLabelImage(ObjectId imageId);
}
