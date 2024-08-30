# 子系统的各个组件
class DVDPlayer:
    def on(self):
        print("DVD Player is on")

    def play(self):
        print("DVD Player is playing")

    def off(self):
        print("DVD Player is off")


class Projector:
    def on(self):
        print("Projector is on")

    def off(self):
        print("Projector is off")


class SoundSystem:
    def on(self):
        print("Sound System is on")

    def off(self):
        print("Sound System is off")


# Facade 类
class HomeTheaterFacade:
    def __init__(self, dvd, projector, sound):
        self.dvd = dvd
        self.projector = projector
        self.sound = sound

    def watch_movie(self):
        self.dvd.on()
        self.dvd.play()
        self.projector.on()
        self.sound.on()
        print("Movie is playing")

    def end_movie(self):
        self.dvd.off()
        self.projector.off()
        self.sound.off()
        print("Movie has ended")


# 客户端代码
if __name__ == "__main__":
    dvd = DVDPlayer()
    projector = Projector()
    sound = SoundSystem()

    home_theater = HomeTheaterFacade(dvd, projector, sound)
    home_theater.watch_movie()
    home_theater.end_movie()
