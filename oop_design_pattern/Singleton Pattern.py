import threading


class Singleton:
    _instance = None

    def __new__(cls):
        if cls._instance is None:
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


# Another example
class PrinterService:
    # 定义了一个线程锁,用于控制对实例的并发访问。
    _instance_lock = threading.Lock()
    _unique_instance = None

    def __new__(cls):
        # 使用 with 语句获取线程锁,确保下面的代码在多线程环境下是安全的。
        with cls._instance_lock:
            if cls._unique_instance is None:
                cls._unique_instance = super(PrinterService, cls).__new__(cls)
                cls._unique_instance._init_printer_service()

        return cls._unique_instance

    # 自定义的初始化方法
    def _init_printer_service(self):
        self.mode = "GrayScale"

    def get_printer_status(self):
        return self.mode

    def set_mode(self, mode):
        self.mode = mode
        print(f"Mode changed to {mode}")


worker1 = PrinterService()
worker2 = PrinterService()

worker1.set_mode("Color")
worker2.set_mode("Grayscale")

worker1_mode = worker1.get_printer_status()
worker2_mode = worker2.get_printer_status()

print(worker1_mode)
print(worker2_mode)
