package com.henry.base.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.AccessType;

import javax.persistence.*;
import java.io.Serializable;

@Data
@NoArgsConstructor
@Entity
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, visible = true, property = "newsEnum")
@JsonSubTypes({
        @JsonSubTypes.Type(value = VideoNews.class, name = "VIDEO"),
        @JsonSubTypes.Type(value = ImageNews.class, name = "IMAGES"),
        @JsonSubTypes.Type(value = TextNews.class, name = "TEXT"),
})
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) // a table per class "for each entity"
public abstract class News implements Serializable {

    @Id
    private Integer id;

    private String title, description;

    // It let me access to Enum. The method would let me return enum type on each chield
    @AccessType(AccessType.Type.PROPERTY)
    public abstract NewsEnum newsEnum();

    // we make a relation and join the column in common. There are two fetch type: EAGER OR LAZY
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "writer_id")
    private Writer owner;
}
