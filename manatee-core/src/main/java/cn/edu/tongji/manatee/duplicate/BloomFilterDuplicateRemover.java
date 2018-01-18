package cn.edu.tongji.manatee.duplicate;

import cn.edu.tongji.manatee.dtos.RawTaskDTO;

/**
 * Created by xubing on 13:35 for manatee.
 * <p>
 * I love coding forever
 */

public class BloomFilterDuplicateRemover implements DuplicateRemover<RawTaskDTO>{

    @Override
    public String takeSignature(RawTaskDTO rawTaskDTO) {
        return null;
    }

    @Override
    public boolean put(RawTaskDTO rawTaskDTO) {
        return false;
    }

}
