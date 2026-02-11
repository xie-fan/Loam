package org.loam.yolo.api.bean.dto;

import lombok.Data;
import org.bson.types.ObjectId;
import org.loam.yolo.api.bean.entity.TrainRecord;

@Data
public class TrainRecordReqDto {

    private ObjectId datasetId;

    public TrainRecord toTrainRecord() {
        TrainRecord trainRecord = new TrainRecord();
        trainRecord.setDatasetId(datasetId);
        return trainRecord;
    }
}
