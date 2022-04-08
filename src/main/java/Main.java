import cache.Cache;
import cache.factories.CacheFactory;

public class Main {
    public static void main(String []args){
                 System.out.println("Test");
        CacheFactory<Integer,Integer> cf=new CacheFactory<>();
        Cache<Integer,Integer> cache=cf.defaultCache(2);
        cache.put(1,2);
        System.out.println("hello " + cache.get(1));
    }
}
