# JavaDesignPatterns
《Twenty-Three Design Patterns in Java》

"Java二十三种设计模式" 翻译成英文为 "Twenty-Three Design Patterns in Java"。
这23种设计模式是经典的《Design Patterns: Elements of Reusable Object-Oriented Software》一书中所描述的设计模式，
通常被称为“Gang of Four”（GoF）设计模式。以下是这23种设计模式分类：

### 创建型模式 (Creational Patterns)
1. **Singleton (单例模式)**: Ensure a class has only one instance, and provide a global point of access to it.
   单例模式 (Singleton Pattern): 确保一个类只有一个实例，并提供一个全局访问点。
2. **Factory Method (工厂方法模式)**: Define an interface for creating an object, but let subclasses decide which class to instantiate.
3. **Abstract Factory (抽象工厂模式)**: Provide an interface for creating families of related or dependent objects without specifying their concrete classes.
4. **Builder (建造者模式)**: Separate the construction of a complex object from its representation so that the same construction process can create different representations.
5. **Prototype (原型模式)**: Specify the kinds of objects to create using a prototypical instance, and create new objects by copying this prototype.

### 结构型模式 (Structural Patterns)
6. **Adapter (适配器模式)**: Convert the interface of a class into another interface clients expect. Adapter lets classes work together that couldn't otherwise because of incompatible interfaces.
7. **Bridge (桥接模式)**: Decouple an abstraction from its implementation so that the two can vary independently.
8. **Composite (组合模式)**: Compose objects into tree structures to represent part-whole hierarchies. Composite lets clients treat individual objects and compositions of objects uniformly.
9. **Decorator (装饰模式)**: Attach additional responsibilities to an object dynamically. Decorators provide a flexible alternative to subclassing for extending functionality.
10. **Facade (外观模式)**: Provide a unified interface to a set of interfaces in a subsystem. Facade defines a higher-level interface that makes the subsystem easier to use.
11. **Flyweight (享元模式)**: Use sharing to support large numbers of fine-grained objects efficiently.
12. **Proxy (代理模式)**: Provide a surrogate or placeholder for another object to control access to it.

### 行为型模式 (Behavioral Patterns)
13. **Chain of Responsibility (责任链模式)**: Avoid coupling the sender of a request to its receiver by giving more than one object a chance to handle the request. Chain the receiving objects and pass the request along the chain until an object handles it.
14. **Command (命令模式)**: Encapsulate a request as an object, thereby letting you parameterize clients with different requests, queue or log requests, and support undoable operations.
15. **Interpreter (解释器模式)**: Given a language, define a representation for its grammar along with an interpreter that uses the representation to interpret sentences in the language.
16. **Iterator (迭代器模式)**: Provide a way to access the elements of an aggregate object sequentially without exposing its underlying representation.
17. **Mediator (中介者模式)**: Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently.
18. **Memento (备忘录模式)**: Without violating encapsulation, capture and externalize an object's internal state so that the object can be restored to this state later.
19. **Observer (观察者模式)**: Define a one-to-many dependency between objects so that when one object changes state, all its dependents are notified and updated automatically.
20. **State (状态模式)**: Allow an object to alter its behavior when its internal state changes. The object will appear to change its class.
21. **Strategy (策略模式)**: Define a family of algorithms, encapsulate each one, and make them interchangeable. Strategy lets the algorithm vary independently from clients that use it.
22. **Template Method (模板方法模式)**: Define the skeleton of an algorithm in an operation, deferring some steps to subclasses. Template Method lets subclasses redefine certain steps of an algorithm without changing the algorithm's structure.
23. **Visitor (访问者模式)**: Represent an operation to be performed on the elements of an object structure. Visitor lets you define a new operation without changing the classes of the elements on which it operates.

这些设计模式提供了标准化的解决方案，帮助开发者解决常见的软件设计问题。
它们不仅适用于Java，也适用于其他面向对象编程语言。通过学习和应用这些设计模式，开发者可以编写更灵活、可维护和可扩展的代码。