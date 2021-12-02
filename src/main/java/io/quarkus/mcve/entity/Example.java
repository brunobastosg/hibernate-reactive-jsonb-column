package io.quarkus.mcve.entity;

import io.quarkus.mcve.jpa.MapJsonConverter;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Map;

@Entity
public class Example {

    @Id
    private int id;

    @Convert(converter = MapJsonConverter.class)
    private Map<String, Object> content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Map<String, Object> getContent() {
        return content;
    }

    public void setContent(Map<String, Object> content) {
        this.content = content;
    }

}
