package com.henry.base.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity(name = "TextNews")
public class TextNews extends News{

    private String text;


    @Override
    public NewsEnum newsEnum() {
        return NewsEnum.TEXT;
    }
}
