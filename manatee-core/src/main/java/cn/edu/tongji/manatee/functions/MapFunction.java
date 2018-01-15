package cn.edu.tongji.manatee.functions;

/**
 *
 * @param <T>
 * @param <R>
 */
public interface MapFunction<T,R> {

    /**
     *
     * @param t
     * @return
     */
    public R call(T t);

}
