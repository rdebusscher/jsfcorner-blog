/*
 * Licensed to the Apache Software Foundation (ASF) under one
 * or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information
 * regarding copyright ownership. The ASF licenses this file
 * to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance
 * with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package be.c4j.jsf.primefaces.view;

/**
 * @author Rudy De Busscher
 */

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "bean")
public class Bean
{
    private String text;

    public Bean()
    {
        text = "This is a very long text.  On screens where you have multiple items of this kind, you loose a lot of space.  By truncating it and showing the full text in the tooltip, you win a lot of space.";
    }

    public String getText()
    {
        return text;
    }

    public void setText(String text)
    {
        this.text = text;
    }
}
