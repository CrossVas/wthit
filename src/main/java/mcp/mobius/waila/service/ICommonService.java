package mcp.mobius.waila.service;

import java.nio.file.Path;
import java.util.Optional;

import mcp.mobius.waila.api.__internal__.Internals;
import mcp.mobius.waila.util.ModInfo;

public interface ICommonService {

    ICommonService INSTANCE = Internals.loadService(ICommonService.class);

    boolean isClientSide();

    Path getGameDir();

    Path getConfigDir();

    Optional<ModInfo> createModInfo(String namespace);

}
