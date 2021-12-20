package com.tugulbayraktar.springboot.mongodb.dto;

import javax.validation.constraints.Size;

public class CategoryDto {

    private String id;
    @Size(max = 50)
    private String name;
    private String level;
    private String superCategoryId;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getSuperCategoryId() {
        return superCategoryId;
    }

    public void setSuperCategoryId(String superCategoryId) {
        this.superCategoryId = superCategoryId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
