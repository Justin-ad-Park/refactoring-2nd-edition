package designpattern.flyweight;

public class FlyWeightObject {
    private String name;

    public FlyWeightObject(String name) throws InterruptedException {
        System.out.println(name + " : 객체 생성에 걸리는 시간 1초");
        Thread.sleep(1000);

        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }

}
