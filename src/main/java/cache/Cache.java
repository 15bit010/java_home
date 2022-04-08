package cache;

import cache.storage.Storage;

public class Cache<Key,Value> {
    private final Storage<Key,Value> storage;

    public Cache(Storage<Key, Value> storage) {
        this.storage = storage;
    }
    public void put(Key key,Value value){
        this.storage.add(key,value);
    }
    public Value get(Key key){
        return this.storage.get(key);
    }
}
