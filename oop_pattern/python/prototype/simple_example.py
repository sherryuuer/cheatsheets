import copy


class Prototype:
    def clone(self):
        return copy.deepcopy(self)


class ConcretePrototype(Prototype):
    def __init__(self, value):
        self.value = value

    def __str__(self):
        return f'ConcretePrototype with value: {self.value}'


# 使用示例
prototype = ConcretePrototype(42)
print(f"Original object: {prototype}")

# 克隆对象
cloned_object = prototype.clone()
print(f"Cloned object: {cloned_object}")

# 验证是不同的对象实例
print(f"Are objects the same instance? {
      'Yes' if prototype is cloned_object else 'No'}")
