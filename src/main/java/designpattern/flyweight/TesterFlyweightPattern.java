package designpattern.flyweight;

public class TesterFlyweightPattern {
    public static void main(String[] args) throws InterruptedException {
        FlyWeightObjectFactory fwFactory = new FlyWeightObjectFactory();
        FlyWeightObject fwObject = fwFactory.getObject("Justin");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Jordan");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Anna");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Justin");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Justin");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Anna");
        System.out.println(fwObject);

        fwObject = fwFactory.getObject("Jordan");
        System.out.println(fwObject);

        String justin1 = "Justin1";
        System.out.println("Justin1 : " + justin1.hashCode());

        String justin2 = "Justin" + "1";
        System.out.println("Justin2 : " + justin2.hashCode());

        String justin3 = new String("Justin1");
        System.out.println("Justin3 : " + justin3.hashCode());

        if(justin1.equals(justin2))
            System.out.println("동일값");

        if(justin1 == justin2)
            System.out.println("동일객체");
    }
}
