package org.loam.yolo.api.bean.dto;

import lombok.Data;
import org.loam.yolo.api.bean.entity.Dataset;

@Data
public class DatasetReqDto {

    private String name;

    public Dataset toDataset(){
        Dataset dataset = new Dataset();
        dataset.setName(name);
        return dataset;
    }
}
