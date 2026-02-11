package org.loam.yolo.service.controller;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.DataTable;
import org.loam.common.core.bean.vo.Message;
import org.loam.mongo.utils.ObjectIdUtil;
import org.loam.yolo.api.bean.dto.DatasetReqDto;
import org.loam.yolo.api.bean.entity.Dataset;
import org.loam.yolo.service.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DatasetController {

    private DatasetService datasetService;
    @Autowired
    public void setDatasetService(DatasetService datasetService) {
        this.datasetService = datasetService;
    }

    @GetMapping("/list")
    public DataTable<List<Dataset>> getDatasetList(DatasetReqDto reqDto,
            @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize){
        Page<Dataset> datasetPage = datasetService.getDatasetList(reqDto, pageNum, pageSize);
        return DataTable.success(datasetPage.getContent(), datasetPage.getTotalElements());
    }

    @GetMapping("/{datasetId}")
    public DataSet<Dataset> getDataset(@PathVariable String datasetId){
        Dataset dataset = datasetService.getDataset(ObjectIdUtil.format(datasetId));
        return DataSet.success(dataset);
    }

    @PutMapping
    public DataSet<Dataset> updateDataset(@RequestBody DatasetReqDto reqDto){
        Dataset dataset = datasetService.updateDataset(reqDto);
        return DataSet.success(dataset);
    }

    @PostMapping
    public DataSet<Dataset> addDataset(@RequestBody DatasetReqDto reqDto){
        Dataset dataset = datasetService.addDataset(reqDto);
        return DataSet.success(dataset);
    }

    @DeleteMapping("/{datasetId}")
    public Message deleteDataset(@PathVariable String datasetId){
        datasetService.deleteDataset(ObjectIdUtil.format(datasetId));
        return DataSet.success();
    }
}
