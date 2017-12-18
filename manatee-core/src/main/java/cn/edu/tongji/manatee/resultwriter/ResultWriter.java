package cn.edu.tongji.manatee.resultwriter;

import java.util.Collection;

/**
 * Created by xubing on 13:16 for manatee.
 * <p>
 * I love coding forever
 */
public interface ResultWriter<T, R> {

    /**
     *
     * @param result
     * @return
     */
    public R writeOneResult(T result);

    public R writeManayResult(Collection<T> results, boolean force);

    public boolean commit();

    public boolean close();

}
