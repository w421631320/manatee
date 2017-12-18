package cn.edu.tongji.manatee.duplicate;

import cn.edu.tongji.manatee.dtos.RawTaskDTO;

import java.util.HashSet;

/**
 * Created by xubing on 13:26 for manatee.
 * <p>
 * I love coding forever
 */

public class HashSetDuplicateRemover implements DuplicateRemover<RawTaskDTO> {

    private static final HashSet<RawTaskDTO>  container = new HashSet<>();

    @Override
    public String takeSignature(RawTaskDTO rawTaskDTO) {
        return null;
    }

    @Override
    public boolean put(RawTaskDTO rawTaskDTO) {
        return false;
    }
}
