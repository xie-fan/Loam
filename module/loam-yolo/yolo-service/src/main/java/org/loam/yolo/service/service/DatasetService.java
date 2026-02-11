package org.loam.yolo.service.service;

import org.bson.types.ObjectId;
import org.loam.common.core.bean.vo.DataTable;
import org.loam.yolo.api.bean.dto.DatasetReqDto;
import org.loam.yolo.api.bean.entity.Dataset;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface DatasetService {
    Page<Dataset> getDatasetList(DatasetReqDto reqDto, int pageNum, int pageSize);

    Dataset getDataset(ObjectId id);

    Dataset updateDataset(DatasetReqDto reqDto);

    Dataset addDataset(DatasetReqDto reqDto);

    void deleteDataset(ObjectId id);
}
