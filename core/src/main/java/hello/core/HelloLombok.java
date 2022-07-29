package hello.core;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Arrays;

@Getter
@Setter
@ToString
/**
 * getter, setter를 직접 만들지 않고도 사용 가능
 */
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("asdf");

        System.out.println("name = " + helloLombok);
    }
}
