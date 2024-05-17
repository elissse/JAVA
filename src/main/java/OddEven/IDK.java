package OddEven;

import org.w3c.dom.ls.LSOutput;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class IDK {
    private static ReentrantLock apartment = new ReentrantLock(true);
    private static ReentrantLock car = new ReentrantLock(true);

    public static void main(String[] args) throws InterruptedException {
        isItLocked("apartment", apartment);
        isItLocked("car", car);
        IDK idk = new IDK();
        System.out.println("so i have the key for apartment and my friend has the key for the car");
        new Thread(idk::me, "me").start();
        new Thread(idk::friend, "friend").start();
    }

    public static void isItLocked(String what, ReentrantLock whatwhat) {
        if (whatwhat.isLocked()) System.out.println(what + " is locked");
        else System.out.println(what + " is unlocked");
    }

    public void me() {
        apartment.lock();
        System.out.println("i just exited and locked the apartment and going to the car hoping it's open and yes i leave our car open because i'm just that cool");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        car.lock();
        System.out.println("i reached the car successfully and unlocked it and it hadn't even been stolen despite being left open and then i locked it when i got in because i don't want to be bothered");
        car.unlock();
        System.out.println("i'm done with all the driving in my red mercedes so i unlocked it and left it that way yay");
        apartment.unlock();
        System.out.println("i unlocked the apartment and entered it now i can rest from this very hard day of driving around");
    }

    public void friend() {
        car.lock();
        System.out.println("my friend is done with driving around so he locked the car (because unlike me he's afraid that our new shiny perfect car will be stolen if left unlocked) and wants to get back in the apartment hoping it's open (but what he doesn't know is that i left and locked it and he has no way of getting in and that's bad and sad)");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        apartment.lock();
        System.out.println("he got to the apartment successfully and thank god it's open so he got in and locked it for some reason but i'm not home yet i don't really know how i will get in i guess he doesn't want me to so i'm sad;(");
        apartment.unlock();
        System.out.println("oh no i was wrong i knocked and my friend opened the door for me yay");
        car.unlock();
        System.out.println("i was very um persuasive i guess because my friend went out and opened it and left it open because no one is going to steal it honest");
    }
}
