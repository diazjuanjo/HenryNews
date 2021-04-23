package com.henry.base.model;

public enum NewsEnum {

    VIDEO("Video News"),
    IMAGE("Image News"),
    TEXT("Text News");

    private String description;

    // generate a constructor and a getter
    NewsEnum(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    // method for search the value of enum
    public static NewsEnum find(String value){
        for (NewsEnum val:
             values()) {
            if (val.toString().equalsIgnoreCase(value)){
                return val;
            }
        }
        throw new IllegalArgumentException(String.format("Invalid TypeNews: %s", value));
    }
}
