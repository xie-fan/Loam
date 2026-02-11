package org.loam.yolo.service.service.impl;

import org.bson.types.ObjectId;
import org.loam.mongo.utils.MongoQueryBuilder;
import org.loam.yolo.api.bean.dto.TrainRecordReqDto;
import org.loam.yolo.api.bean.entity.TrainRecord;
import org.loam.yolo.service.dao.TrainRecordRepository;
import org.loam.yolo.service.service.TrainRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public class TrainRecordServiceImpl implements TrainRecordService {

    private TrainRecordRepository trainRecordRepository;

    @Autowired
    public TrainRecordServiceImpl(TrainRecordRepository trainRecordRepository) {
        this.trainRecordRepository = trainRecordRepository;
    }

    @Override
    public Page<TrainRecord> getTrainRecordList(TrainRecordReqDto reqDto, int pageNum, int pageSize) {
        return trainRecordRepository.findAll(Example.of(reqDto.toTrainRecord()),
                MongoQueryBuilder.builder(pageNum, pageSize));
    }

    @Override
    public TrainRecord getTrainRecord(ObjectId id) {
        return trainRecordRepository.findById(id).orElse(null);
    }

    @Override
    public TrainRecord updateTrainRecord(TrainRecordReqDto reqDto) {
        return trainRecordRepository.save(reqDto.toTrainRecord());
    }

    @Override
    public TrainRecord addTrainRecord(TrainRecordReqDto reqDto) {
        return trainRecordRepository.insert(reqDto.toTrainRecord());
    }

    @Override
    public void deleteTrainRecord(ObjectId id) {
        trainRecordRepository.deleteById(id);
    }
}
