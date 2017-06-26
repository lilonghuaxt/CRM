package pers.llh.crm.util;
import java.util.UUID;
/**
 * 自动生成Id
 * @author lilonghua
 *
 */
public class UUIDUtil {
	
	public static String getUUID() throws Exception {
        String s = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        return s;
    }

}
