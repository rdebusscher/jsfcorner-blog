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
package be.c4j.jsf.primefaces.outputtext;


import javax.el.ValueExpression;
import javax.faces.component.html.HtmlOutputText;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Rudy De Busscher
 */
public class OutputText extends HtmlOutputText
{


    public static final String COMPONENT_TYPE = "be.c4j.jsf.primefaces.outputtext.OutputText";
    public static final String COMPONENT_FAMILY = "org.primefaces.component";
    private static final String DEFAULT_RENDERER = "be.c4j.jsf.primefaces.outputtext.OutputTextRenderer";
    private static final String OPTIMIZED_PACKAGE = "org.primefaces.component.";

    public OutputText()
    {
        setRendererType(DEFAULT_RENDERER);
    }

    enum PropertyKeys
    {
         truncateAt
    }


    @Override
    public String getFamily()
    {
        return COMPONENT_FAMILY;
    }

    public Integer getTruncateAt() {
      return (Integer) getStateHelper().eval(PropertyKeys.truncateAt, null);
    }

	public void setTruncateAt(Integer _truncateAt) {
		getStateHelper().put(PropertyKeys.truncateAt, _truncateAt);
		handleAttribute("truncateAt", _truncateAt);
	}

    public void handleAttribute(String name, Object value) {
        List<String> setAttributes = (List<String>) this.getAttributes().get("javax.faces.component.UIComponentBase.attributesThatAreSet");
        if(setAttributes == null) {
            String cname = this.getClass().getName();
            if(cname != null && cname.startsWith(OPTIMIZED_PACKAGE)) {
                setAttributes = new ArrayList<String>(6);
                this.getAttributes().put("javax.faces.component.UIComponentBase.attributesThatAreSet", setAttributes);
            }
        }
        if(setAttributes != null) {
            if(value == null) {
                ValueExpression ve = getValueExpression(name);
                if(ve == null) {
                    setAttributes.remove(name);
                } else if(!setAttributes.contains(name)) {
                    setAttributes.add(name);
                }
            }
        }
    }

}
