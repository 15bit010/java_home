package cache.factories;

import cache.Cache;
import cache.storage.HashMapBasedStorage;

public class CacheFactory<Key,Value> {
      public Cache<Key,Value> defaultCache(final int capacity){
          return new Cache<Key,Value>(new HashMapBasedStorage<Key,Value>(capacity));
      }
}
