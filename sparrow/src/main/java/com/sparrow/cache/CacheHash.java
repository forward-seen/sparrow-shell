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

package com.sparrow.cache;

import com.sparrow.constant.cache.Key;
import com.sparrow.exception.CacheConnectionException;
import java.util.Collection;
import java.util.Map;

public interface CacheHash {
    Map<String, String> getAll(Key key) throws CacheConnectionException;

    <K, T> Map<K, T> getAll(Key key, Class keyClazz, Class clazz) throws CacheConnectionException;

    <K, T> Map<K, T> getAll(Key key, Class keyClazz, Class clazz, CacheDataNotFound<Map<K, T>> hook);

    Long getSize(Key key) throws CacheConnectionException;

    String get(Key key, String field) throws CacheConnectionException;

    Map<String, String> get(Key key, Collection<String> fieldList) throws CacheConnectionException;

    <T> Map<String, T> get(Key key, Collection<String> fieldList, Class valueType) throws CacheConnectionException;

    <T> T get(Key key, String field, Class clazz) throws CacheConnectionException;

    <T> T get(Key key, String field, Class clazz, CacheDataNotFound<T> hook);

    Long put(Key key, String field, Object value) throws CacheConnectionException;

    <K, T> Integer put(Key key, Map<K, T> map) throws CacheConnectionException;
}
