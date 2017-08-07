- 定义：提供一个方法顺序访问一个聚合对象的各个元素，而又不暴露其内部表示；
- 例如，我们要通过一个对外暴露的方法来展现不同集合的元素（List和数组），可以通过自定义实现Iterator接口，同时使用Iterator来完成暴露操作；
- 单一责任原则：一个类只有一个引起变化的原因；