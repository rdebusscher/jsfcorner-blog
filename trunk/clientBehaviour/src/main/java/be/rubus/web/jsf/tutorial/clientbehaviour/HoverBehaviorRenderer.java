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
package be.rubus.web.jsf.tutorial.clientbehaviour;

import javax.faces.application.ResourceDependency;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorContext;
import javax.faces.render.ClientBehaviorRenderer;
import javax.faces.render.FacesBehaviorRenderer;

/**
 *
 */
@FacesBehaviorRenderer(rendererType="hover")
@ResourceDependency(name = "hover.css")
public class HoverBehaviorRenderer extends ClientBehaviorRenderer {

    private static final String MOUSEOVER_EVENT = "mouseover";
    private static final String MOUSEOUT_EVENT = "mouseout";

    @Override
    public String getScript(ClientBehaviorContext behaviorContext, ClientBehavior behavior) {
        if (MOUSEOVER_EVENT.equals(behaviorContext.getEventName())) {
            return "this.className += ' hoverCls '";
        }
        if (MOUSEOUT_EVENT.equals(behaviorContext.getEventName())) {
            return "this.className = this.className.replace( /(?:^|\\s)hoverCls(?!\\S)/g , '' )";
        }
        return null;
    }
}
