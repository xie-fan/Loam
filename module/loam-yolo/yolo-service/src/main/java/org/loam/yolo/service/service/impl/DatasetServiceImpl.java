package org.loam.yolo.service.service.impl;

import org.bson.types.ObjectId;
import org.loam.common.core.bean.vo.DataSet;
import org.loam.common.core.bean.vo.DataTable;
import org.loam.mongo.utils.MongoQueryBuilder;
import org.loam.yolo.api.bean.dto.DatasetReqDto;
import org.loam.yolo.api.bean.entity.Dataset;
import org.loam.yolo.service.dao.DataSetRepository;
import org.loam.yolo.service.service.DatasetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DatasetServiceImpl implements DatasetService {

    private DataSetRepository dataSetRepository;

    @Autowired
    public DatasetServiceImpl(DataSetRepository dataSetRepository) {
        this.dataSetRepository = dataSetRepository;
    }

    @Override
    public Page<Dataset> getDatasetList(DatasetReqDto reqDto, int pageNum, int pageSize) {
        return dataSetRepository.findAll(Example.of(reqDto.toDataset()), MongoQueryBuilder.builder(pageNum, pageSize));
    }

    @Override
    public Dataset getDataset(ObjectId id) {
        return dataSetRepository.findById(id).orElse(null);
    }

    @Override
    public Dataset updateDataset(DatasetReqDto reqDto) {
        return dataSetRepository.save(reqDto.toDataset());
    }

    @Override
    public Dataset addDataset(DatasetReqDto reqDto) {
        return dataSetRepository.insert(reqDto.toDataset());
    }

    @Override
    public void deleteDataset(ObjectId id) {
        dataSetRepository.deleteById(id);
    }
}
