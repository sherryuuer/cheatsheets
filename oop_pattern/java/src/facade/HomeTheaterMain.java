package facade;

// 客户端代码
public class HomeTheaterMain {
    public static void main(String[] args) {
        DVDPlayer dvd = new DVDPlayer();
        Projector projector = new Projector();
        SoundSystem sound = new SoundSystem();

        HomeTheaterFacade homeTheater = new HomeTheaterFacade(dvd, projector, sound);
        homeTheater.watchMovie();
        homeTheater.endMovie();
    }
}

// 子系统的各个组件
class DVDPlayer {
    public void on() {
        System.out.println("DVD Player is on");
    }

    public void play() {
        System.out.println("DVD Player is playing");
    }

    public void off() {
        System.out.println("DVD Player is off");
    }
}

class Projector {
    public void on() {
        System.out.println("Projector is on");
    }

    public void off() {
        System.out.println("Projector is off");
    }
}

class SoundSystem {
    public void on() {
        System.out.println("Sound System is on");
    }

    public void off() {
        System.out.println("Sound System is off");
    }
}

// Facade 类
class HomeTheaterFacade {
    private DVDPlayer dvd;
    private Projector projector;
    private SoundSystem sound;

    public HomeTheaterFacade(DVDPlayer dvd, Projector projector, SoundSystem sound) {
        this.dvd = dvd;
        this.projector = projector;
        this.sound = sound;
    }

    public void watchMovie() {
        dvd.on();
        dvd.play();
        projector.on();
        sound.on();
        System.out.println("Movie is playing");
    }

    public void endMovie() {
        dvd.off();
        projector.off();
        sound.off();
        System.out.println("Movie has ended");
    }
}
