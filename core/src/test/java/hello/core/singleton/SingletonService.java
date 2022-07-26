package hello.core.singleton;

public class SingletonService {
    private static final SingletonService instance = new SingletonService(); // 자기 자신을 내부에 딱 하나 가지고 있는다.

    public static SingletonService getInstance() {
        return instance;
    }

    private SingletonService(){} //외부 사용을 막는다.

    public void logic(){
        System.out.println("싱글톤 객체 로직 호출");
    }
}
