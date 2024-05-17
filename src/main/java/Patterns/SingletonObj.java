package Patterns;

public class SingletonObj {
    private static SingletonObj instance;

    private SingletonObj() {
    } // other classes cannot create instance of this class!

    //if we put synchronised in public static synchronised SingleObj get() then many threads cannot get in this method bad ;(

    public static SingletonObj getInstance() { // проблемы будут когда будет несколько потоков, нужно синхронизировать
        if (instance == null) {
            synchronized (SingletonObj.class) {
                if (instance == null) {
                    instance = new SingletonObj();
                }
            }
        }
        return instance;
    }
}
