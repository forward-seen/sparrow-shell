/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.sparrow.cache.impl.redis.jedis.cluter;

import com.sparrow.cache.CacheKey;
import com.sparrow.constant.cache.KEY;
import com.sparrow.exception.CacheConnectionException;
import redis.clients.jedis.JedisCluster;

public class RedisCacheKey extends AbstractCommand implements CacheKey {
    RedisCacheKey(RedisPool redisPool) {
        this.redisPool = redisPool;
    }

    @Override
    public Long expireSeconds(final KEY key, final Long expire) throws CacheConnectionException {
        return redisPool.execute(new Executor<Long>() {
            @Override public Long execute(JedisCluster jedis) throws CacheConnectionException {
                return jedis.expire(key.key(), expire);
            }
        }, key);
    }

    @Override
    public Long delete(final KEY key) throws CacheConnectionException {
        return redisPool.execute(new Executor<Long>() {
            @Override public Long execute(JedisCluster jedis) throws CacheConnectionException {
                return jedis.del(key.key());
            }
        },key);
    }

    @Override
    public Long ttl(final KEY key) throws CacheConnectionException {
        return redisPool.execute(new Executor<Long>() {
            @Override
            public Long execute(JedisCluster jedis) {
                return jedis.ttl(key.key());
            }
        }, key);
    }

    @Override
    public Long expireSecondsAt(final KEY key, final Long expire) throws CacheConnectionException {
        return redisPool.execute(new Executor<Long>() {
            @Override
            public Long execute(JedisCluster jedis) {
                return jedis.expireAt(key.key(), expire);
            }
        }, key);
    }
}
