class State:
    def handle(self, context):
        pass


class OnState(State):
    def handle(self, context):
        print("The light is already on.")
        context.set_state(OffState())


class OffState(State):
    def handle(self, context):
        print("The light is off. Turning it on now.")
        context.set_state(OnState())


class LightSwitch:
    def __init__(self):
        self.state = OffState()  # 初始状态是“关”

    def set_state(self, state: State):
        self.state = state

    def press(self):
        self.state.handle(self)


# 使用示例
light_switch = LightSwitch()
light_switch.press()  # 打开灯
light_switch.press()  # 关闭灯
