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


import org.primefaces.renderkit.CoreRenderer;
import org.primefaces.util.HTML;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.context.ResponseWriter;
import java.io.IOException;

/**
 * @author Rudy De Busscher
 */
public class OutputTextRenderer extends CoreRenderer
{

    public static final String UI_OUTPUTTEXT = "ui-outputlabel";

    @Override
    public void encodeEnd(FacesContext context, UIComponent component) throws IOException
    {
        super.encodeEnd(context, component);
        OutputText outputText = (OutputText) component;

        ResponseWriter writer = context.getResponseWriter();
        String clientId = outputText.getClientId(context);

        writer.startElement("span", null);
        writer.writeAttribute("id", clientId, null);
        writer.writeAttribute("class", UI_OUTPUTTEXT, "id");
        writer.writeAttribute("name", clientId, null);
        String value = outputText.getValue().toString();
        Integer truncateAt = outputText.getTruncateAt();
        if (truncateAt != null && value.length() > truncateAt) {
            writer.writeAttribute("title", value, null);
            value = value.substring(0, truncateAt-1)+"...";
        }
        renderPassThruAttributes(context, outputText, HTML.INPUT_TEXT_ATTRS);

        if (outputText.getStyle() != null)
        {
            writer.writeAttribute("style", outputText.getStyle(), null);
        }

        writer.writeText(value, null);
        writer.endElement("span");
    }


}
