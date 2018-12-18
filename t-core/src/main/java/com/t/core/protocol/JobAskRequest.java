package com.t.core.protocol;

import com.t.core.remote.exception.RemoteCommandFieldCheckException;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

/**
 * @author tb
 * @date 2018/12/18 14:26
 */
@Getter
@Setter
public class JobAskRequest extends AbstractRemoteCommandBody {

    private List<String> jobIds;

    @Override
    public void checkFields() throws RemoteCommandFieldCheckException {
        if (jobIds == null || jobIds.size() == 0) {
            throw new RemoteCommandFieldCheckException("jobIds could not be empty");
        }
    }
}
