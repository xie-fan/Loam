package org.loam.yolo.service.controller;

import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.DataTable;
import org.loam.common.core.bean.vo.Message;
import org.loam.mongo.utils.ObjectIdUtil;
import org.loam.yolo.api.bean.dto.TrainRecordReqDto;
import org.loam.yolo.api.bean.entity.TrainRecord;
import org.loam.yolo.service.service.TrainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/train-record")
public class TrainRecordController {

    private TrainRecordService trainRecordService;

    @Autowired
    public void setTrainRecordService(TrainRecordService trainRecordService) {
        this.trainRecordService = trainRecordService;
    }

    @GetMapping("/list")
    public DataTable<List<TrainRecord>> getTrainRecordList(TrainRecordReqDto reqDto,
            @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10") int pageSize) {
        Page<TrainRecord> trainRecordPage = trainRecordService.getTrainRecordList(reqDto, pageNum, pageSize);
        return DataTable.success(trainRecordPage.getContent(), trainRecordPage.getTotalElements());
    }

    @GetMapping("/{recordId}")
    public DataSet<TrainRecord> getTrainRecord(@PathVariable String recordId) {
        TrainRecord trainRecord = trainRecordService.getTrainRecord(ObjectIdUtil.format(recordId));
        return DataSet.success(trainRecord);
    }

    @PutMapping
    public DataSet<TrainRecord> updateTrainRecord(@RequestBody TrainRecordReqDto reqDto) {
        TrainRecord trainRecord = trainRecordService.updateTrainRecord(reqDto);
        return DataSet.success(trainRecord);
    }

    @PostMapping
    public DataSet<TrainRecord> addTrainRecord(@RequestBody TrainRecordReqDto reqDto) {
        TrainRecord trainRecord = trainRecordService.addTrainRecord(reqDto);
        return DataSet.success(trainRecord);
    }

    @DeleteMapping("/{recordId}")
    public Message deleteTrainRecord(@PathVariable String recordId) {
        trainRecordService.deleteTrainRecord(ObjectIdUtil.format(recordId));
        return Message.success();
    }
}
