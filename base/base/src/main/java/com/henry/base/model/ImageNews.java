package com.henry.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import java.util.List;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "ImageNews")
public class ImageNews extends News{

    @ElementCollection
    private List<String> imageUrl;


    @Override
    public NewsEnum newsEnum() {
        return NewsEnum.IMAGE;
    }
}
