class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
            # init是初始化不确保创建新的对象
            cls._instance = super(Singleton, cls).__new__(cls)
            cls._instance.value = None
        return cls._instance

    def getValue(self):
        return self.value

    def setValue(self, value):
        self.value = value


# 使用示例
s = Singleton()

print(s.getValue())  # None

s.setValue("a value string")
print(s.getValue())  # "a value string"

s2 = Singleton()

print(s2.getValue())  # "a value string"
