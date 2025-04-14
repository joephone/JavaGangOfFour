package com.transcendence.gangoffour._01_creational.factory.factorymethod;

import android.content.Context;

public class ShapeViewFactoryManager {
    private static ShapeViewFactoryManager instance;

    private ShapeViewFactoryManager() {}

    public static synchronized ShapeViewFactoryManager getInstance() {
        if (instance == null) {
            instance = new ShapeViewFactoryManager();
        }
        return instance;
    }

    public interface ShapeViewFactory {
        ShapeView create(Context context);
    }

    private static class CircleViewFactory implements ShapeViewFactory {
        private static CircleViewFactory instance;

        static CircleViewFactory getInstance() {
            if (instance == null) {
                instance = new CircleViewFactory();
            }
            return instance;
        }

        @Override
        public ShapeView create(Context context) {
            return new CircleView(context);
        }
    }

    private static class RectangleViewFactory implements ShapeViewFactory {
        private static RectangleViewFactory instance;

        static RectangleViewFactory getInstance() {
            if (instance == null) {
                instance = new RectangleViewFactory();
            }
            return instance;
        }

        @Override
        public ShapeView create(Context context) {
            return new RectangleView(context);
        }
    }

    public ShapeViewFactory getFactory(String type) {
        switch (type) {
            case "circle":
                return CircleViewFactory.getInstance();
            case "rectangle":
                return RectangleViewFactory.getInstance();
            default:
                throw new IllegalArgumentException("Unknown shape type");
        }
    }
}
