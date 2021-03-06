package io.cattle.platform.lb.instance.process;

import io.cattle.platform.core.constants.InstanceConstants;
import io.cattle.platform.core.constants.LoadBalancerConstants;
import io.cattle.platform.core.model.Instance;
import io.cattle.platform.core.model.LoadBalancerTarget;
import io.cattle.platform.engine.handler.HandlerResult;
import io.cattle.platform.engine.handler.ProcessPostListener;
import io.cattle.platform.engine.process.ProcessInstance;
import io.cattle.platform.engine.process.ProcessState;
import io.cattle.platform.lb.instance.service.LoadBalancerInstanceManager;
import io.cattle.platform.process.common.handler.AbstractObjectProcessLogic;
import io.cattle.platform.util.type.Priority;

import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

@Named
public class LoadBalancerInstanceRemovePostListener extends AbstractObjectProcessLogic implements ProcessPostListener, Priority {

    @Inject
    LoadBalancerInstanceManager lbInstanceManager;

    @Override
    public String[] getProcessNames() {
        return new String[] { InstanceConstants.PROCESS_REMOVE };
    }

    @Override
    public HandlerResult handle(ProcessState state, ProcessInstance process) {
        Instance instance = (Instance) state.getResource();
        deleteInstanceTargets(instance);
        return null;
    }

    private void deleteInstanceTargets(Instance instance) {
        List<? extends LoadBalancerTarget> targets = objectManager.mappedChildren(objectManager.loadResource(Instance.class, instance.getId()),
                LoadBalancerTarget.class);
        for (LoadBalancerTarget target : targets) {
            objectProcessManager.scheduleProcessInstance(LoadBalancerConstants.PROCESS_LB_TARGET_MAP_REMOVE, target, null);
        }
    }


    @Override
    public int getPriority() {
        return Priority.DEFAULT;
    }
}
