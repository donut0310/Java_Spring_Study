package hello.core.singleton;

public class StatefulService {
    /**
     * 무상태를 지키지 않은 코드
    private int price; //상태를 유지하는 필드

    public void order(String name, int price){
        System.out.println("name = " + name + ", price = " + price);
        this.price = price; //여기가 문제!
    }
    public int getPrice(){
        return price;
    }
     */

    /**
     * 무상태를 지킨 코드
     */
    public int order(String name,int price){
        System.out.println("name = " + name + ", price = " + price);
        return price;
    }

}
