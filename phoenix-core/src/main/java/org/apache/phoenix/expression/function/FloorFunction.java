/*
 * Copyright 2010 The Apache Software Foundation
 *
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements.  See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership.  The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.phoenix.expression.function;

import java.util.List;

import org.apache.phoenix.expression.Expression;
import org.apache.phoenix.parse.FloorParseNode;
import org.apache.phoenix.parse.FunctionParseNode.Argument;
import org.apache.phoenix.parse.FunctionParseNode.BuiltInFunction;
import org.apache.phoenix.schema.PDataType;
/**
 * 
 * Base class for built-in FLOOR function.
 *
 * @author samarth.jain
 * @since 3.0.0
 */
@BuiltInFunction(name = FloorFunction.NAME,
                 nodeClass = FloorParseNode.class,
                 args = {
                        @Argument(allowedTypes={PDataType.TIMESTAMP, PDataType.DECIMAL}),
                        @Argument(allowedTypes={PDataType.VARCHAR, PDataType.INTEGER}, defaultValue = "null", isConstant=true),
                        @Argument(allowedTypes={PDataType.INTEGER}, defaultValue="1", isConstant=true)
                        } 
                )
public abstract class FloorFunction extends ScalarFunction {
    
    public static final String NAME = "FLOOR";
    
    public FloorFunction(List<Expression> children) {
        super(children);
    }
    
    @Override
    public String getName() {
        return NAME;
    }
}