package com.henry.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "VideoNews")
public class VideoNews extends News{

    private String videoTitle, videoDescription, videoUrl;


    @Override
    public NewsEnum newsEnum() {
        return NewsEnum.VIDEO;
    }
}
