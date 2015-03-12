package io.cattle.platform.core.dao;

import io.cattle.platform.core.model.Network;
import io.cattle.platform.core.model.NetworkService;
import io.cattle.platform.core.model.Nic;

import java.util.List;

public interface NetworkDao {

    List<? extends NetworkService> getAgentInstanceNetworkService(long instanceId, String serviceKind);

    List<? extends NetworkService> getNetworkService(long instanceId, String serviceKind);

    Nic getPrimaryNic(long instanceId);

    List<? extends Network> getNetworksForAccount(long accountId, String kind);

    Network getNetworkForObject(Object object, String networkKind);

}
