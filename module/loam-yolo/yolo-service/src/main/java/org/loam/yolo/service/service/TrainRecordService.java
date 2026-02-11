package org.loam.yolo.service.service;

import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.dto.TrainRecordReqDto;
import org.loam.yolo.api.bean.entity.TrainRecord;
import org.springframework.data.domain.Page;

public interface TrainRecordService {

    Page<TrainRecord> getTrainRecordList(TrainRecordReqDto reqDto, int pageNum, int pageSize);

    TrainRecord getTrainRecord(ObjectId id);

    TrainRecord updateTrainRecord(TrainRecordReqDto reqDto);

    TrainRecord addTrainRecord(TrainRecordReqDto reqDto);

    void deleteTrainRecord(ObjectId id);
}
