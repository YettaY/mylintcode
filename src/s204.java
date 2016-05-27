/**
 * Created by yanglu on 16/5/24.
 */
public class s204 {
    public static s204 instance=null;
    public static s204 getInstance() {
        if (instance==null)
            return new s204();
        return instance;
    }
}
