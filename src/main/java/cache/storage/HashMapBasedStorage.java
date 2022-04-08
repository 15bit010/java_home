package cache.storage;
import java.util.HashMap;
import java.util.Map;

import cache.exceptions.NotFoundException;
import cache.exceptions.StorageFullException;

public class HashMapBasedStorage<Key,Value> implements Storage<Key,Value> {
    Map<Key, Value> storage;
    private final Integer capacity;

    public HashMapBasedStorage(Integer capacity) {
        this.storage = new HashMap<>();
        this.capacity = capacity;
    }

    @Override
    public void add(Key key, Value value) {
      try{
          if(isFullStorage()){
              throw new StorageFullException("Storage full....");
          }
          storage.put(key,value);
      }catch (StorageFullException exception){
          throw exception;
      }
    }

    @Override
    public void remove(Key key) {
      try{
         if(isFullStorage()){
             throw new NotFoundException(key+" does not exists in cache.");
         }
         storage.remove(key);
      }catch (NotFoundException exception){
          throw exception;
      }
    }

    @Override
    public Value get(Key key) {
        try {
            if (isFullStorage()) {
                throw new NotFoundException(key + " does not exists in cache.");
            }
            return storage.get(key);
        }catch (NotFoundException exception){
            throw exception;
        }
    }

    private boolean isFullStorage(){
        return this.storage.size()==capacity;
    }
}
