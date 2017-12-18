package cn.edu.tongji.manatee.duplicate;

/**
 * Created by xubing on 13:24 for manatee.
 * <p>
 * I love coding forever
 */
public interface DuplicateRemover<T> {

    public String takeSignature(T rawTaskDTO);

    public boolean put(T rawTaskDTO);

}
