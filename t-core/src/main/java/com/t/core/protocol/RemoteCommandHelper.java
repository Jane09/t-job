package com.t.core.protocol;

/**
 * @author tb
 * @date 2018/12/18 13:58
 */
public final class RemoteCommandHelper {
    // 0, REQUEST_COMMAND
    private static final int RPC_TYPE = 0;
    // 1, RPC
    private static final int RPC_ONEWAY = 1;

    public static void markResponseType(RemoteCommand remotingCommand) {
        int bits = 1 << RPC_TYPE;
        remotingCommand.setFlag(remotingCommand.getFlag() | bits);
    }

    public static boolean isResponseType(RemoteCommand remotingCommand) {
        int bits = 1 << RPC_TYPE;
        return (remotingCommand.getFlag() & bits) == bits;
    }

    public static void markOnewayRPC(RemoteCommand remotingCommand) {
        int bits = 1 << RPC_ONEWAY;
        remotingCommand.setFlag(remotingCommand.getFlag() | bits);
    }

    public static boolean isOnewayRPC(RemoteCommand remotingCommand) {
        int bits = 1 << RPC_ONEWAY;
        return (remotingCommand.getFlag() & bits) == bits;
    }

    public static RemoteCommandType getRemotingCommandType(RemoteCommand remotingCommand) {
        if (RemoteCommandHelper.isResponseType(remotingCommand)) {
            return RemoteCommandType.RESPONSE_COMMAND;
        }
        return RemoteCommandType.REQUEST_COMMAND;
    }
}
