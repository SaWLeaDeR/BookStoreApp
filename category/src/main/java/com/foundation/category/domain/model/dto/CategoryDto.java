package com.foundation.category.domain.model.dto;

import java.io.Serializable;

public class CategoryDto implements Serializable {

    private static final long serialVersionUID = -4953759199685393093L;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
