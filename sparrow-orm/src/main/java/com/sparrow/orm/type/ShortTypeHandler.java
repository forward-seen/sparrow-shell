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
package com.sparrow.orm.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ShortTypeHandler implements TypeHandler<Short> {

    @Override
    public void setParameter(PreparedStatement ps, int i, Short parameter) throws SQLException {
        ps.setShort(i, parameter);
    }

    @Override
    public Short getResult(ResultSet rs, String columnName) throws SQLException {
        return rs.getShort(columnName);
    }

    @Override
    public Short getResult(ResultSet rs, int columnIndex) throws SQLException {
        return rs.getShort(columnIndex);
    }

    @Override
    public Short getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return cs.getShort(columnIndex);
    }
}
