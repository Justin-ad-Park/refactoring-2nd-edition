package designpattern.flyweight;

import java.util.Map;
import java.util.TreeMap;

public class FlyWeightObjectFactory {
    private Map<String, FlyWeightObject> pool;

    public FlyWeightObjectFactory() {
        this.pool = new TreeMap<>();
    }

    public FlyWeightObject getObject(String key) throws InterruptedException {
        FlyWeightObject fwObject = pool.get(key);
        if(fwObject == null) {
            fwObject = new FlyWeightObject(key);
            pool.put(key, fwObject);
        }

        return fwObject;
    }
}
