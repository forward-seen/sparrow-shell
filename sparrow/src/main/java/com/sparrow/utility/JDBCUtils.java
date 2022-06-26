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

package com.sparrow.utility;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.Closeable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCUtils {
    private static Logger logger = LoggerFactory.getLogger(JDBCUtils.class);

    public static void close(Connection x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            logger.error("close connection error", e);
        }
    }

    public static void close(Statement x) {
        if (x == null) {
            return;
        }
        try {
            x.close();
        } catch (Exception e) {
            logger.error("close statement error", e);
        }
    }

    public static void close(ResultSet rs) {
        if (rs == null) {
            return;
        }
        try {
            rs.close();
        } catch (Exception e) {
            logger.debug("close result set error", e);
        }
    }

    public static void close(Closeable x) {
        if (x == null) {
            return;
        }

        try {
            x.close();
        } catch (Exception e) {
            logger.error("close error", e);
        }
    }
}
