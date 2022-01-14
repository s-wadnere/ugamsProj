package com.ugamsproj.core.models.impl;

import com.adobe.granite.workflow.WorkflowException;
import com.adobe.granite.workflow.WorkflowSession;
import com.adobe.granite.workflow.exec.WorkItem;
import com.adobe.granite.workflow.exec.WorkflowData;
import com.adobe.granite.workflow.exec.WorkflowProcess;
import com.adobe.granite.workflow.metadata.MetaDataMap;
import org.osgi.framework.Constants;
import org.osgi.service.component.annotations.Component;

import javax.jcr.*;

@Component(
        service = WorkflowProcess.class,
        property = {
                "process.label" + " = ugam project Workflow",
                Constants.SERVICE_VENDOR + "=ugam project",
                Constants.SERVICE_DESCRIPTION + " = Custom ugams project workflow step."
        }
)
public class UgamProjectWorkflow implements WorkflowProcess{
    @Override
    public void execute(WorkItem workItem, WorkflowSession workflowSession, MetaDataMap metaDataMap) throws WorkflowException {
        try {
            WorkflowData workflowData = workItem.getWorkflowData();
            if (workflowData.getPayloadType().equals("JCR_PATH")) {
                Session session = workflowSession.adaptTo(Session.class);
            String path = workflowData.getPayload().toString() + "/jcr:content";
            Node node = (Node) session.getItem(path);
            String[] processArgs = metaDataMap.get("PROCESS_ARGS", "string").split(",");
            for (String wfArgs : processArgs) {
                String[] args = wfArgs.split(":");
                String prop = args[0];
                String value = args[1];
                if (node != null) {
                    node.setProperty(prop, value);
                }
            }
        }
    } catch (Exception e) {
            e.getStackTrace();
        }
    }
}
