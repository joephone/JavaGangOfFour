package com.transcendence.gangoffour._01_creational.prototype;

/**
 * Cloneable 的作用是标记一个类允许克隆，但实际克隆行为由开发者通过重写 clone() 控制。
 * 在 Android 开发中，除非有明确需求，否则更推荐使用其他对象复制方式（如 Parcelable 或拷贝构造函数）。
 */
public class Shape implements Cloneable {
    private String type;
    private int color; // 新增颜色属性
    private int size;  // 新增大小属性

    public Shape(String type, int color, int size) {
        this.type = type;
        this.color = color;
        this.size = size;
    }

    public String getType() {
        return type;
    }

    public int getColor() {
        return color;
    }

    public int getSize() {
        return size;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public void setSize(int size) {
        this.size = size;
    }

    @Override
    public Shape clone() {
        try {
            return (Shape) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}