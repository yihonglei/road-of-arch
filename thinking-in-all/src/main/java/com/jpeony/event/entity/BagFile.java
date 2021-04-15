package com.jpeony.event.entity;

import java.io.Serializable;

public class BagFile implements Serializable {
    private static final long serialVersionUID = 1L;

    private String name;

    private long size;

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return this.size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "BagFile{, name=" + this.name + ", size=" + this.size + "}";
    }
}
