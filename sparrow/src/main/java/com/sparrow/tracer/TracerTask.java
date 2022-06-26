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

package com.sparrow.tracer;

import com.sparrow.tracer.impl.TracerImpl;

import java.util.concurrent.CountDownLatch;

public abstract class TracerTask implements Runnable {
    public TracerTask(Tracer tracer, CountDownLatch countDownLatch) {
        this.tracer = tracer;
        this.cursor = tracer.cursor();
        this.countDownLatch = countDownLatch;
    }

    public TracerTask(Tracer tracer) {
        this(tracer, null);
    }

    private Tracer tracer;
    private Span cursor;
    private CountDownLatch countDownLatch;

    public abstract void task();

    @Override
    public void run() {
        ((TracerImpl) tracer).setCursor(this.cursor);
        try {
            this.task();
        } finally {
            if (countDownLatch != null) {
                countDownLatch.countDown();
            }
        }
    }
}
